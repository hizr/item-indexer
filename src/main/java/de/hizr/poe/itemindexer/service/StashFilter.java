package de.hizr.poe.itemindexer.service;

import java.util.List;

import de.hizr.poe.itemindexer.model.Stash;

/**
 * @author hizr
 */
public interface StashFilter {

	List<Stash> filter(List<Stash> stashes);

}
