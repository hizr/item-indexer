package de.hizr.poe.itemindexer.service;

import de.hizr.poe.itemindexer.model.PublicStashTabs;

/**
 * @author hizr
 */
public interface PullService {

	PublicStashTabs pullTabs(String nextId);

}
