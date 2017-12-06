package de.hizr.poe.itemindexer.service.filter.item;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Component;

import de.hizr.poe.itemindexer.model.Item;

/**
 * @author hizr
 */
@Component
public class EmptyNoteItemFilter implements ItemFilter {

	// ... business methods

	@Override
	public List<Item> filter(final List<Item> items) {

		final List<Item> result = items.stream() //
				.filter(item -> item.getNote() != null && !item.getNote().isEmpty()) //
				.collect(toList());

		return result;
	}

}
