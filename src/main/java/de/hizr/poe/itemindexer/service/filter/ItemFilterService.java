package de.hizr.poe.itemindexer.service.filter;

import java.util.List;

import de.hizr.poe.itemindexer.model.Item;

/**
 * @author hizr
 */
public interface ItemFilterService {

	List<Item> filter(List<Item> items);

}
