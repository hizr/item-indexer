package de.hizr.poe.itemindexer.elastic.model;

/**
 * @author hizr
 */
public enum OfferType {

	// ... instances

	BUYOUT("~b/o"), PRICE("~price");

	// ... member

	private String initcator;

	// ... construction

	private OfferType(final String initcator) {
		this.initcator = initcator;
	}

	// ... business methods

	public static OfferType valueBy(final String indicator) {
		OfferType result = null;

		for (final OfferType type : values()) {
			if (type.initcator.equals(indicator)) {
				result = type;
				break;
			}
		}

		if (result == null) {
			final String msg = "No %s found for '%s'";
			throw new IllegalArgumentException(String.format(msg, OfferType.class.getSimpleName(), indicator));
		}

		return result;
	}

	// ... getter

	public String getInitcator() {
		return initcator;
	}

}
