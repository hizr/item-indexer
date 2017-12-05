package de.hizr.poe.itemindexer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.hizr.poe.itemindexer.model.Item;

/**
 * @author hizr
 */
@Service
public class ItemFilterImpl implements ItemFilter {

	@Override
	public List<Item> filter(final List<Item> items) {
		List<Item> result = items;

		result = filterEmptyNotes(result);

		return result;
	}

	private List<Item> filterEmptyNotes(final List<Item> items) {

		final List<Item> result = items.stream() //
				.filter(item -> item.getNote() != null && !item.getNote().isEmpty()) //
				.collect(Collectors.toList());

		return result;
	}

}
