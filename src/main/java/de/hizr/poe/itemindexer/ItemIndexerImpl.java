package de.hizr.poe.itemindexer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.hizr.poe.itemindexer.elastic.model.ItemIndex;
import de.hizr.poe.itemindexer.mapper.ItemIndexMapper;
import de.hizr.poe.itemindexer.model.Item;
import de.hizr.poe.itemindexer.model.PublicStashTabs;
import de.hizr.poe.itemindexer.model.Stash;
import de.hizr.poe.itemindexer.service.ItemFilter;
import de.hizr.poe.itemindexer.service.PullService;
import de.hizr.poe.itemindexer.service.StashFilter;

/**
 * @author hizr
 */
@Service
public class ItemIndexerImpl implements ItemIndexer {

	private static final Logger LOG = LoggerFactory.getLogger(ItemIndexerImpl.class);

	@Autowired
	private PullService pullService;

	@Autowired
	private StashFilter stashFilter;

	@Autowired
	private ItemFilter itemFilter;

	@Autowired
	private ItemIndexMapper itemIndexMapper;

	@Override
	public void index() {

		try {

			run();

		} catch (final InterruptedException | JsonProcessingException e) {

			LOG.error("Somethink went wrong on indexing...", e);

		}
	}

	private void run() throws InterruptedException, JsonProcessingException {
		String nextId = null;

		final PublicStashTabs pullTabs = pullService.pullTabs(nextId);
		nextId = pullTabs.getNextChangeId();

		List<Stash> stashes = pullTabs.getStashes();

		stashes = stashFilter.filter(stashes);

		filterItems(stashes);

		final List<ItemIndex> itemIndexes = mapStashes(stashes);

		printItems(itemIndexes);
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

	private void printItems(final List<ItemIndex> items) throws JsonProcessingException {
		final ObjectMapper mapper = new ObjectMapper();

		for (final ItemIndex item : items) {
			LOG.debug("{}", mapper.writeValueAsString(item));
		}
	}

	private List<Item> collectItems(final List<Stash> stashes) {
		final List<Item> items = new ArrayList<>();

		for (final Stash stash : stashes) {
			final List<Item> stashItems = stash.getItems();

			if (!stashItems.isEmpty()) {
				items.addAll(stashItems);
			}
		}

		return items;
	}

}
