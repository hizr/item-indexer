package de.hizr.poe.itemindexer.service.filter.item;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import de.hizr.poe.itemindexer.elastic.model.OfferType;
import de.hizr.poe.itemindexer.model.Item;

/**
 * @author hizr
 */
@Component
public class UselessNoteItemFilter implements ItemFilter {

	// ... business methods

	@Override
	public List<Item> filter(final List<Item> items) {

		final List<Item> result = items.stream() //
				.filter(item -> isUseableNote(item)) //
				.collect(toList());

		return result;
	}

	// ... utility methods

	private boolean isUseableNote(final Item item) {
		boolean result = false;

		for (final OfferType ot : OfferType.values()) {
			result = StringUtils.containsAny(item.getNote(), ot.getInitcator());
			if (result) {
				break;
			}
		}

		return result;
	}

}
