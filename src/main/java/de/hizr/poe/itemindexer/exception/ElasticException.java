package de.hizr.poe.itemindexer.exception;

import java.io.Serializable;

/**
 * @author hizr
 */
public class ElasticException extends RuntimeException {

	/**
	 * See {@link Serializable}
	 */
	private static final long serialVersionUID = 8899222253270636193L;

	// ... construction

	public ElasticException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ElasticException(final String message) {
		super(message);
	}

}
