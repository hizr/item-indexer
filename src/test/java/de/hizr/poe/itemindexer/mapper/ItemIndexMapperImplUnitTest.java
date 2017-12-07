package de.hizr.poe.itemindexer.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.dozer.CustomConverter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.hizr.poe.itemindexer.elastic.model.ItemIndex;
import de.hizr.poe.itemindexer.model.Item;

/**
 * @author hizr
 */
public class ItemIndexMapperImplUnitTest {

	private static final String ID = "asdf";
	private static final String NOTE = "~b/o 3 exa";

	private ItemIndexMapperImpl toTest;

	@BeforeMethod
	public void beforMethod() {
		final List<CustomConverter> customConverters = new ArrayList<>();

		customConverters.add(new ItemNameCustomConverterImpl());
		customConverters.add(new ItemOfferCustomConverter());

		toTest = new ItemIndexMapperImpl();
		toTest.setCustomConverters(customConverters);
	}

	@Test
	public void testMap() {
		final Item item = createItem();

		// test
		final ItemIndex itemIndex = toTest.map(item, ItemIndex.class);

		// assertion
		assertThat(itemIndex.getId()).isEqualTo(item.getId());
	}

	private Item createItem() {
		final Item item = new Item();

		item.setId(ID);
		item.setNote(NOTE);

		return item;
	}

}
