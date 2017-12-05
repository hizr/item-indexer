package de.hizr.poe.itemindexer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author hizr
 */
public class Stash {

	// ... member

	private String accountName;

	private String lastCharacterName;

	private String id;

	private String stash;

	private String stashType;

	private List<Item> items;

	@JsonProperty("public")
	private boolean visible;

	// ... getter and setter

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(final String accountName) {
		this.accountName = accountName;
	}

	public String getLastCharacterName() {
		return lastCharacterName;
	}

	public void setLastCharacterName(final String lastCharacterName) {
		this.lastCharacterName = lastCharacterName;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getStash() {
		return stash;
	}

	public void setStash(final String stash) {
		this.stash = stash;
	}

	public String getStashType() {
		return stashType;
	}

	public void setStashType(final String stashType) {
		this.stashType = stashType;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(final boolean visible) {
		this.visible = visible;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(final List<Item> items) {
		this.items = items;
	}

}
