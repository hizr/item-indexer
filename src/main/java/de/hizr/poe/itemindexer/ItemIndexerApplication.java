package de.hizr.poe.itemindexer;

import java.util.List;

import org.dozer.CustomConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import com.github.dozermapper.spring.DozerBeanMapperFactoryBean;

@SpringBootApplication
public class ItemIndexerApplication {

	// ... member

	@Autowired
	private ItemIndexer indexer;

	@Autowired
	private List<CustomConverter> customConverters;

	// ... main method

	public static void main(final String[] args) {
		SpringApplication.run(ItemIndexerApplication.class, args);
	}

	// ... bean factory methods

	@Bean
	@Scope(value = "singleton")
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
