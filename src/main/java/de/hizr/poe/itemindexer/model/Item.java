package de.hizr.poe.itemindexer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author hizr
 */
public class Item {

	// ... member

	private boolean verified;

	@JsonProperty("w")
	private int width;

	@JsonProperty("h")
	private int height;

	private int ilvl;

	private String icon;

	private String league;

	private String id;

	private List<Socket> sockets;

	private String name;

	private String typeLine;

	private boolean identified;

	private boolean corrupted;

	private boolean lockedToCharacter;

	private String note;

	// ... getter and setter

	private List<Property> properties;

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(final List<Property> properties) {
		this.properties = properties;
	}

	public List<Property> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(final List<Property> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	private List<Property> requirements;

	private List<String> exexplicitMods;

	private List<String> implicitMods;

	private List<String> enchantMods;

	private List<String> craftedMods;

	private List<String> flavourText;

	private int frameType;

	private String inventoryId;

	private List<Item> socketedItems;

	private List<Property> additionalProperties;

	public List<Item> getSocketedItems() {
		return socketedItems;
	}

	public void setSocketedItems(final List<Item> socketedItems) {
		this.socketedItems = socketedItems;
	}

	private String secDescrText;

	private String descrText;

	private String artFilename;

	private boolean duplicated;

	private int maxStackSize;

	private List<Property> nextLevelRequirements;

	private int stackSize;

	private int talismanTier;

	private List<String> utilityMods;

	private boolean support;

	private List<String> cosmeticMods;

	private String prophecyDiffText;

	private String prophecyText;

	private boolean isRelic;

	public List<Property> getRequirements() {
		return requirements;
	}

	public void setRequirements(final List<Property> requirements) {
		this.requirements = requirements;
	}

	public List<Property> getNextLevelRequirements() {
		return nextLevelRequirements;
	}

	public void setNextLevelRequirements(final List<Property> nextLevelRequirements) {
		this.nextLevelRequirements = nextLevelRequirements;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(final String icon) {
		this.icon = icon;
	}

	public String getLeague() {
		return league;
	}

	public int getIlvl() {
		return ilvl;
	}

	public void setIlvl(final int ilvl) {
		this.ilvl = ilvl;
	}

	public void setLeague(final String league) {
		this.league = league;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public List<Socket> getSockets() {
		return sockets;
	}

	public void setSockets(final List<Socket> sockets) {
		this.sockets = sockets;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
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

	public List<String> getExexplicitMods() {
		return exexplicitMods;
	}

	public void setExexplicitMods(final List<String> exexplicitMods) {
		this.exexplicitMods = exexplicitMods;
	}

	public List<String> getImplicitMods() {
		return implicitMods;
	}

	public void setImplicitMods(final List<String> implicitMods) {
		this.implicitMods = implicitMods;
	}

	public List<String> getEnchantMods() {
		return enchantMods;
	}

	public void setEnchantMods(final List<String> enchantMods) {
		this.enchantMods = enchantMods;
	}

	public List<String> getCraftedMods() {
		return craftedMods;
	}

	public void setCraftedMods(final List<String> craftedMods) {
		this.craftedMods = craftedMods;
	}

	public List<String> getFlavourText() {
		return flavourText;
	}

	public void setFlavourText(final List<String> flavourText) {
		this.flavourText = flavourText;
	}

	public int getFrameType() {
		return frameType;
	}

	public void setFrameType(final int frameType) {
		this.frameType = frameType;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(final String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getSecDescrText() {
		return secDescrText;
	}

	public void setSecDescrText(final String secDescrText) {
		this.secDescrText = secDescrText;
	}

	public String getDescrText() {
		return descrText;
	}

	public void setDescrText(final String descrText) {
		this.descrText = descrText;
	}

	public String getArtFilename() {
		return artFilename;
	}

	public void setArtFilename(final String artFilename) {
		this.artFilename = artFilename;
	}

	public boolean isDuplicated() {
		return duplicated;
	}

	public void setDuplicated(final boolean duplicated) {
		this.duplicated = duplicated;
	}

	public int getMaxStackSize() {
		return maxStackSize;
	}

	public void setMaxStackSize(final int maxStackSize) {
		this.maxStackSize = maxStackSize;
	}

	public int getStackSize() {
		return stackSize;
	}

	public void setStackSize(final int stackSize) {
		this.stackSize = stackSize;
	}

	public int getTalismanTier() {
		return talismanTier;
	}

	public void setTalismanTier(final int talismanTier) {
		this.talismanTier = talismanTier;
	}

	public List<String> getUtilityMods() {
		return utilityMods;
	}

	public void setUtilityMods(final List<String> utilityMods) {
		this.utilityMods = utilityMods;
	}

	public boolean isSupport() {
		return support;
	}

	public void setSupport(final boolean support) {
		this.support = support;
	}

	public List<String> getCosmeticMods() {
		return cosmeticMods;
	}

	public void setCosmeticMods(final List<String> cosmeticMods) {
		this.cosmeticMods = cosmeticMods;
	}

	public String getProphecyDiffText() {
		return prophecyDiffText;
	}

	public void setProphecyDiffText(final String prophecyDiffText) {
		this.prophecyDiffText = prophecyDiffText;
	}

	public String getProphecyText() {
		return prophecyText;
	}

	public void setProphecyText(final String prophecyText) {
		this.prophecyText = prophecyText;
	}

	public boolean isRelic() {
		return isRelic;
	}

	public void setRelic(final boolean isRelic) {
		this.isRelic = isRelic;
	}

}
