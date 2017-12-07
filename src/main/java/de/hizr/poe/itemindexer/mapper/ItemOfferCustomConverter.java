package de.hizr.poe.itemindexer.mapper;

import org.springframework.stereotype.Component;

import de.hizr.poe.itemindexer.elastic.model.Offer;
import de.hizr.poe.itemindexer.elastic.model.OfferType;
import de.hizr.poe.itemindexer.exception.NotSupportedException;
import de.hizr.poe.itemindexer.model.Item;

/**
 * @author hizr
 */
@Component
public class ItemOfferCustomConverter extends AbstractOneWayCustomConverter<Item, Offer> {

	// ... construction

	public ItemOfferCustomConverter() {
		super(Item.class, Offer.class);
	}

	// ... business methods

	@Override
	public Offer convertTo(final Item sourceNotNull) {
		final String note = sourceNotNull.getNote();

		final String[] split = note.split(" ");

		final OfferType typ = tryToMapOffer(note, split);
		final String amount = split[1];
		final String currency = split[2];

		return new Offer(typ, currency, amount);
	}

	// ... utility methods

	private OfferType tryToMapOffer(final String note, final String[] split) {
		OfferType ot = null;
		try {
			ot = OfferType.valueBy(split[0]);
		} catch (final Exception e) {
			final String message = "cannot map %s for note: '%s'";
			throw new NotSupportedException(String.format(message, OfferType.class.getSimpleName(), note), e);
		}
		return ot;
	}

}
