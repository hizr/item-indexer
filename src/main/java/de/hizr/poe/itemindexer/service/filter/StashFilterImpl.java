package de.hizr.poe.itemindexer.service.filter;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.hizr.poe.itemindexer.model.Stash;

/**
 * @author hizr
 */
@Service
public class StashFilterImpl implements StashFilter {

	// ... constants

	private static final Logger LOG = LoggerFactory.getLogger(StashFilterImpl.class);

	// ... business methods

	@Override
	public List<Stash> filter(final List<Stash> stashes) {
		List<Stash> result = stashes;
		LOG.info("Stashes size befor: {}", result.size());

		result = filterPrivateStashes(result);

		LOG.info("Stashes size after: {}", result.size());

		return result;
	}

	// ... utility methods

	private List<Stash> filterPrivateStashes(final List<Stash> stashes) {
		final List<Stash> result = stashes //
				.stream() //
				.filter(st -> st.isVisible() == true) //
				.collect(Collectors.toList());
		return result;
	}

}
