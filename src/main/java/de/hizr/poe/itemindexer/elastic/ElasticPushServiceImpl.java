package de.hizr.poe.itemindexer.elastic;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.hizr.poe.itemindexer.elastic.model.ItemIndex;
import de.hizr.poe.itemindexer.exception.ElasticException;
import de.hizr.poe.itemindexer.exception.JsonException;

/**
 * @author hizr
 */
@Service
public class ElasticPushServiceImpl implements ElasticPushService {

	// ... constants

	private static final Logger LOG = LoggerFactory.getLogger(ElasticPushServiceImpl.class);

	private static final String INDEX_NAME = "item";
	private static final String TYPE = "doc";

	// ... member

	private RestHighLevelClient client;

	// ... business methods

	@Override
	public void pushItems(final List<ItemIndex> itemIndexes) {
		if (itemIndexes.size() > 0) {
			client = createClient();

			final BulkRequest bulkRequest = createBulkRequest(itemIndexes);

			performPush(bulkRequest);

			close();
		} else {
			LOG.info("skip bulk");
		}
	}

	// ... utility methods

	private RestHighLevelClient createClient() {
		final RestClientBuilder builder = RestClient.builder( //
				new HttpHost("localhost", 9200, "http"), //
				new HttpHost("localhost", 9201, "http") //
		);
		return new RestHighLevelClient(builder);
	}

	private void performPush(final BulkRequest bulkRequest) {
		try {

			LOG.info("try to bulk request {}", bulkRequest);
			client.bulk(bulkRequest);
			LOG.info("finished bulk");

		} catch (final IOException e) {
			final String message = "exception while bukling data to search engine...";
			throw new ElasticException(message, e);
		}
	}

	private BulkRequest createBulkRequest(final List<ItemIndex> itemIndexes) {
		IndexRequest request;
		final BulkRequest bulkRequest = new BulkRequest();
		final ObjectMapper mapper = new ObjectMapper();

		for (final ItemIndex itemIndex : itemIndexes) {
			request = createIndexRequest(mapper, itemIndex);
			bulkRequest.add(request);
		}

		return bulkRequest;
	}

	private IndexRequest createIndexRequest(final ObjectMapper mapper, final ItemIndex itemIndex) {
		final IndexRequest request = new IndexRequest(INDEX_NAME, TYPE, itemIndex.getId().toString());
		final byte[] jsonByteArray = createItemIndexJson(mapper, itemIndex);
		request.source(jsonByteArray, XContentType.JSON);
		return request;
	}

	private byte[] createItemIndexJson(final ObjectMapper mapper, final ItemIndex itemIndex) {
		try {
			return mapper.writeValueAsBytes(itemIndex);
		} catch (final JsonProcessingException e) {
			final String message = "cannot write %s as byteArray...";
			throw new JsonException(String.format(message, ItemIndex.class.getSimpleName()), e);
		}
	}

	private void close() {
		try {
			client.close();
		} catch (final IOException e) {
			final String message = "cannot close %s ...";
			throw new ElasticException(String.format(message, RestHighLevelClient.class.getSimpleName()), e);
		}
	}

}
