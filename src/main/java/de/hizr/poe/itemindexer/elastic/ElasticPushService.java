package de.hizr.poe.itemindexer.elastic;

import java.util.List;

import de.hizr.poe.itemindexer.elastic.model.ItemIndex;

/**
 * @author hizr
 */
public interface ElasticPushService {

	void pushItems(List<ItemIndex> itemIndexes);

}
