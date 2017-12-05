package de.hizr.poe.itemindexer.exception;

import java.io.Serializable;

/**
 * @author hizr
 */
public class JsonException extends RuntimeException {

	// ... constants

	/**
	 * See {@link Serializable}
	 */
	private static final long serialVersionUID = 777714909663364308L;

	// ... construction

	public JsonException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public JsonException(final String message) {
		super(message);
	}

}
