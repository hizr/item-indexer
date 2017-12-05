package de.hizr.poe.itemindexer.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.hizr.poe.itemindexer.model.PublicStashTabs;

/**
 * @author hizr
 */
@Service
public class PullServiceImpl implements PullService {

	// ... constants

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(PullServiceImpl.class);

	private static final String URL = "http://api.pathofexile.com/public-stash-tabs";
	private static final String ID = "?id=";

	// ... member

	@Autowired
	private RestTemplate restTemplate;

	// ... business methods

	@Override
	public PublicStashTabs pullTabs(final String nextId) {
		PublicStashTabs stashTabs = null;

		if (nextId != null && !nextId.isEmpty()) {
			LOG.info("load next items with id: {}", nextId);
			stashTabs = restTemplate.getForObject(URL + ID + nextId, PublicStashTabs.class);
		} else {
			LOG.info("load items intial");
			stashTabs = restTemplate.getForObject(URL, PublicStashTabs.class);
		}

		return stashTabs;
	}

}
