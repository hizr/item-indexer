package de.hizr.poe.itemindexer.service.filter.item;

import java.util.List;

import de.hizr.poe.itemindexer.model.Item;

/**
 * @author hizr
 */
public interface ItemFilter {

	public List<Item> filter(final List<Item> items);

}
