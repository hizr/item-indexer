package de.hizr.poe.itemindexer.mapper;

import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

/**
 * @author hizr
 */
@Component
public class ItemIndexMapperImpl extends DozerBeanMapper implements ItemIndexMapper {

	public ItemIndexMapperImpl() {
		this(Collections.emptyList());
	}

	public ItemIndexMapperImpl(final List<String> mappingFiles) {
		super(mappingFiles);
		addMapping(new ItemIndexBeanMappingBuilder());
	}

}
