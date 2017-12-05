package de.hizr.poe.itemindexer.exception;

import java.io.Serializable;

/**
 * @author hizr
 */
public class NotSupportedException extends RuntimeException {

	/**
	 * See {@link Serializable}
	 */
	private static final long serialVersionUID = -6566743167644722210L;

	// ... construction

	public NotSupportedException(final String message) {
		super(message);
	}

	public NotSupportedException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
