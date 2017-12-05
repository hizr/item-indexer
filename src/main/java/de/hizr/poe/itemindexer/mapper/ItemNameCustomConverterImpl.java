package de.hizr.poe.itemindexer.mapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import de.hizr.poe.itemindexer.model.Item;

/**
 * @author hizr
 */
@Component
public class ItemNameCustomConverterImpl extends AbstractOneWayCustomConverter<Item, String> {

	private static final String LOCALIZATION_MARKUP = "<<set:MS>><<set:M>><<set:S>>";

	public ItemNameCustomConverterImpl() {
		super(Item.class, String.class);
	}

	@Override
	public String convertTo(final Item sourceNotNull) {
		return StringUtils.remove(sourceNotNull.getName(), LOCALIZATION_MARKUP);
	}

}
