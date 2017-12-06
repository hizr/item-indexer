package de.hizr.poe.itemindexer.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.hizr.poe.itemindexer.elastic.model.OfferType;
import de.hizr.poe.itemindexer.model.Item;
import de.hizr.poe.itemindexer.service.filter.item.UselessNoteItemFilter;

/**
 * @author hizr
 */
public class UselessNoteItemFilterUnitTest {

	private UselessNoteItemFilter toTest;

	@BeforeMethod
	public void beforMethod() {
		toTest = new UselessNoteItemFilter();
	}

	@Test
	public void testFilter() {
		final List<Item> items = createItems();

		final List<Item> filter = toTest.filter(items);

		assertThat(filter).hasSize(OfferType.values().length);
	}

	private List<Item> createItems() {
		final List<Item> list = new ArrayList<>();

		for (final OfferType ot : OfferType.values()) {
			list.add(createValidItem(ot));
		}

		for (int i = 0; i < 3; i++) {
			list.add(createInvalidRandomizedItem());
		}

		return list;
	}

	private Item createValidItem(final OfferType ot) {
		final Item item = new Item();

		item.setNote(ot.getInitcator());

		return item;
	}

	private Item createInvalidRandomizedItem() {
		return new Item();
	}

}
