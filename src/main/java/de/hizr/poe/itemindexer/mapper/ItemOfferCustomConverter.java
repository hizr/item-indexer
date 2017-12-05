package de.hizr.poe.itemindexer.mapper;

import org.springframework.stereotype.Component;

import de.hizr.poe.itemindexer.elastic.model.Offer;
import de.hizr.poe.itemindexer.elastic.model.OfferType;
import de.hizr.poe.itemindexer.model.Item;

/**
 * @author hizr
 */
@Component
public class ItemOfferCustomConverter extends AbstractOneWayCustomConverter<Item, Offer> {

	public ItemOfferCustomConverter() {
		super(Item.class, Offer.class);
	}

	@Override
	public Offer convertTo(final Item sourceNotNull) {
		final String note = sourceNotNull.getNote();

		final String[] split = note.split(" ");

		final OfferType typ = OfferType.valueBy(split[0]);
		final String amount = split[1];
		final String currency = split[2];

		return new Offer(typ, currency, amount);
	}

}
