package de.hizr.poe.itemindexer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.hizr.poe.itemindexer.elastic.ElasticPushService;
import de.hizr.poe.itemindexer.elastic.model.ItemIndex;
import de.hizr.poe.itemindexer.exception.JsonException;
import de.hizr.poe.itemindexer.mapper.ItemIndexMapper;
import de.hizr.poe.itemindexer.model.Item;
import de.hizr.poe.itemindexer.model.PublicStashTabs;
import de.hizr.poe.itemindexer.model.Stash;
import de.hizr.poe.itemindexer.service.PullService;
import de.hizr.poe.itemindexer.service.filter.ItemFilterService;
import de.hizr.poe.itemindexer.service.filter.StashFilter;

/**
 * @author hizr
 */
@Service
public class ItemIndexerImpl implements ItemIndexer {

	// ... constants

	private static final Logger LOG = LoggerFactory.getLogger(ItemIndexerImpl.class);

	// ... member

	@Autowired
	private PullService pullService;

	@Autowired
	private StashFilter stashFilter;

	@Autowired
	private ItemFilterService itemFilter;

	@Autowired
	private ItemIndexMapper itemIndexMapper;

	@Autowired
	private ElasticPushService pushService;

	// ... business methods

	@Override
	public void index() {

		try {
			String nextId = null;

			while (true) {
				final PublicStashTabs pullTabs = pullService.pullTabs(nextId);
				nextId = pullTabs.getNextChangeId();

				List<Stash> stashes = pullTabs.getStashes();

				stashes = filterStashes(stashes);

				final List<ItemIndex> itemIndexes = mapStashes(stashes);

				logItems(itemIndexes);
				pushService.pushItems(itemIndexes);

				Thread.sleep(1500);
			}

		} catch (final InterruptedException e) {

			LOG.error("somethink went wrong on indexing...", e);

		}
	}

	// ... utility methods

	private List<Stash> filterStashes(List<Stash> stashes) {
		stashes = stashFilter.filter(stashes);
		filterItems(stashes);
		return stashes;
	}

	private List<ItemIndex> mapStashes(final List<Stash> stashes) {
		final List<ItemIndex> result = new ArrayList<>();

		ItemIndex itemIndex;
		for (final Stash stash : stashes) {
			for (final Item item : stash.getItems()) {

				itemIndex = itemIndexMapper.map(stash, ItemIndex.class);
				itemIndexMapper.map(item, itemIndex);

				result.add(itemIndex);
			}
		}

		return result;
	}

	private void filterItems(final List<Stash> stashes) {
		List<Item> items;

		for (final Stash stash : stashes) {
			items = stash.getItems();
			items = itemFilter.filter(items);
			stash.setItems(items);
		}
	}

	private void logItems(final List<ItemIndex> items) {
		LOG.info("pushing {} items", items.size());

		for (final ItemIndex item : items) {
			LOG.debug("{}", new ItemLogWrapper(item));
		}
	}

	private static class ItemLogWrapper {

		private final ItemIndex item;
		private final ObjectMapper mapper = new ObjectMapper();

		private ItemLogWrapper(final ItemIndex item) {
			this.item = item;
		}

		@Override
		public String toString() {
			try {
				return mapper.writeValueAsString(item);
			} catch (final JsonProcessingException e) {
				throw new JsonException("cant process json", e);
			}
		}

	}
}
