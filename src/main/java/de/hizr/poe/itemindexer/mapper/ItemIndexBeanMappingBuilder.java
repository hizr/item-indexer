package de.hizr.poe.itemindexer.mapper;

import static org.dozer.loader.api.FieldsMappingOptions.customConverter;
import static org.dozer.loader.api.TypeMappingOptions.oneWay;

import org.dozer.loader.api.BeanMappingBuilder;

import de.hizr.poe.itemindexer.elastic.model.ItemIndex;
import de.hizr.poe.itemindexer.model.Item;
import de.hizr.poe.itemindexer.model.Stash;

public class ItemIndexBeanMappingBuilder extends BeanMappingBuilder {

	@Override
	protected void configure() {
		mapping(Stash.class, ItemIndex.class, oneWay());

		mapping(Item.class, ItemIndex.class, oneWay()) //
				.fields("this", "itemName", customConverter(ItemNameCustomConverterImpl.class)) //
				.fields("this", "offer", customConverter(ItemOfferCustomConverter.class)) //
		;

	}

}
