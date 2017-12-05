package de.hizr.poe.itemindexer.elastic.model;

public enum OfferType {

	BUYOUT("~b/o"), PRICE("~price");

	private String initcator;

	private OfferType(final String initcator) {
		this.initcator = initcator;
	}

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

	public String getInitcator() {
		return initcator;
	}

}
