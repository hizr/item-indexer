package de.hizr.poe.itemindexer.mapper;

import org.dozer.DozerConverter;

import de.hizr.poe.itemindexer.exception.NotSupportedException;

/**
 * @author hizr
 *
 */
public abstract class AbstractOneWayCustomConverter<S, D> extends DozerConverter<S, D> {

	public AbstractOneWayCustomConverter(final Class<S> prototypeA, final Class<D> prototypeB) {
		super(prototypeA, prototypeB);
	}

	@Override
	public abstract D convertTo(S sourceNotNull);

	@Override
	public D convertTo(final S source, final D destination) {

		if (source != null) {
			return convertTo(source);
		}

		return null;
	}

	@Override
	public S convertFrom(final D source, final S destination) {
		throw new NotSupportedException("This method is not supported! Dont use this Converter for two way mapping!");
	}

}
