package de.hizr.poe.itemindexer.model;

/**
 * @author hizr
 */
public class Property {

	// ... member

	private String name;

	private int displayMode;

	private int type;

	private int progress;

	// ... getter and setter

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getDisplayMode() {
		return displayMode;
	}

	public void setDisplayMode(final int displayMode) {
		this.displayMode = displayMode;
	}

	public int getType() {
		return type;
	}

	public void setType(final int type) {
		this.type = type;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(final int progress) {
		this.progress = progress;
	}

}
