package de.hizr.poe.itemindexer.elastic.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.hizr.poe.itemindexer.model.Property;
import de.hizr.poe.itemindexer.model.Socket;

/**
 * @author hizr
 */
public class ItemIndex {

	// ... member

	private String id;

	private String accountName;

	private String lastCharacterName;

	private String stashId;

	private String stash;

	private boolean verified;

	@JsonProperty("w")
	private int width;

	@JsonProperty("h")
	private int height;

	private int ilvl;

	private String icon;

	private String league;

	private List<Socket> sockets;

	private String itemName;

	private String typeLine;

	private boolean identified;

	private boolean corrupted;

	private boolean lockedToCharacter;

	private String note;

	private String additionalNote;

	private Offer offer;

	private List<Property> properties;

	// ... getter and setter

	public String getAccountName() {
		return accountName;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
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

	public String getStashId() {
		return stashId;
	}

	public void setStashId(final String stashId) {
		this.stashId = stashId;
	}

	public String getStash() {
		return stash;
	}

	public void setStash(final String stash) {
		this.stash = stash;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(final boolean verified) {
		this.verified = verified;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	public int getIlvl() {
		return ilvl;
	}

	public void setIlvl(final int ilvl) {
		this.ilvl = ilvl;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(final String icon) {
		this.icon = icon;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(final String league) {
		this.league = league;
	}

	public List<Socket> getSockets() {
		return sockets;
	}

	public void setSockets(final List<Socket> sockets) {
		this.sockets = sockets;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(final String itemName) {
		this.itemName = itemName;
	}

	public String getTypeLine() {
		return typeLine;
	}

	public void setTypeLine(final String typeLine) {
		this.typeLine = typeLine;
	}

	public boolean isIdentified() {
		return identified;
	}

	public void setIdentified(final boolean identified) {
		this.identified = identified;
	}

	public boolean isCorrupted() {
		return corrupted;
	}

	public void setCorrupted(final boolean corrupted) {
		this.corrupted = corrupted;
	}

	public boolean isLockedToCharacter() {
		return lockedToCharacter;
	}

	public void setLockedToCharacter(final boolean lockedToCharacter) {
		this.lockedToCharacter = lockedToCharacter;
	}

	public String getNote() {
		return note;
	}

	public void setNote(final String note) {
		this.note = note;
	}

	public String getAdditionalNote() {
		return additionalNote;
	}

	public void setAdditionalNote(final String additionalNote) {
		this.additionalNote = additionalNote;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(final Offer offer) {
		this.offer = offer;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(final List<Property> properties) {
		this.properties = properties;
	}

}
