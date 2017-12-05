package de.hizr.poe.itemindexer.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;

/**
 * @author hizr
 */
public class Value {

	// ... member

	private String key;

	private int value;

	// ... business methods

	@JsonAnySetter
	public void set(final String key, final Integer value) {
		this.key = key;
		this.value = value;
	}

	// ... getter and setter

	public String getKey() {
		return key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(final int value) {
		this.value = value;
	}
}
