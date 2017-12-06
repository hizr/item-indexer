package de.hizr.poe.itemindexer.service.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hizr.poe.itemindexer.model.Item;
import de.hizr.poe.itemindexer.service.filter.item.ItemFilter;

/**
 * @author hizr
 */
@Service
public class ItemFilterServiceImpl implements ItemFilterService {

	// ... member

	@Autowired
	private List<ItemFilter> filters;

	// ... business methods

	@Override
	public List<Item> filter(final List<Item> items) {
		List<Item> result = items;

		for (final ItemFilter filter : filters) {
			result = filter.filter(result);
		}

		return result;
	}

}
