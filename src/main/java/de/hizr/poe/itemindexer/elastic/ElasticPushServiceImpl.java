package de.hizr.poe.itemindexer.elastic;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hizr.poe.itemindexer.elastic.model.ItemIndex;

/**
 * @author hizr
 */
@Service
public class ElasticPushServiceImpl implements ElasticPushService {

	// ... member

	@Autowired
	private RestHighLevelClient client;

	// ... business methods

	@Override
	public void pushItems(final List<ItemIndex> itemIndexes) {

		close();
	}

	// ... utility methods

	private void close() {
		try {
			client.close();
		} catch (final IOException e) {
			final String message = "cannot close {} ...";
			throw new RuntimeException(String.format(message, RestHighLevelClient.class.getSimpleName()), e);
		}

	}

}
