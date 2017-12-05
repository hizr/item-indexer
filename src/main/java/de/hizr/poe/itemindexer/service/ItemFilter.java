package de.hizr.poe.itemindexer.service;

import java.util.List;

import de.hizr.poe.itemindexer.model.Item;

/**
 * @author hizr
 */
public interface ItemFilter {

	List<Item> filter(List<Item> items);

}
