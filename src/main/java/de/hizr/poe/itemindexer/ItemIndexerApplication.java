package de.hizr.poe.itemindexer;

import java.util.List;

import org.dozer.CustomConverter;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ItemIndexerApplication {

	@Autowired
	private ItemIndexer indexer;

	@Autowired
	private List<CustomConverter> customConverters;

	public static void main(final String[] args) {
		SpringApplication.run(ItemIndexerApplication.class, args);
	}

	@Bean
	public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean() {
		final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();

		dozerBeanMapperFactoryBean.setCustomConverters(customConverters);

		return dozerBeanMapperFactoryBean;
	}

	@Bean
	public RestTemplate restTemplate(final RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(final RestTemplate restTemplate) {
		return args -> {
			indexer.index();
		};
	}

}
