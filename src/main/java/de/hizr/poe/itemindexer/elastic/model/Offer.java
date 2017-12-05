package de.hizr.poe.itemindexer.elastic.model;

/**
 * @author hizr
 */
public class Offer {

	// ... member

	private final OfferType typ;

	private final String currency;

	private final String amount;

	// ... construction

	public Offer(final OfferType typ, final String currency, final String amount) {
		super();
		this.typ = typ;
		this.currency = currency;
		this.amount = amount;
	}

	// ... getters

	public OfferType getTyp() {
		return typ;
	}

	public String getCurrency() {
		return currency;
	}

	public String getAmount() {
		return amount;
	}

}
