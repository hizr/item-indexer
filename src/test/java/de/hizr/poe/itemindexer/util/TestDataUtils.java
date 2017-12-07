package de.hizr.poe.itemindexer.util;

import java.security.SecureRandom;

/**
 * @author hizr
 */
public class TestDataUtils {

	private static final String POSIBILE_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final SecureRandom RNG = new SecureRandom();

	public static String randomAlphaNumeric(final int countChars) {
		final StringBuilder sb = new StringBuilder(countChars);

		for (int i = 0; i < countChars; i++) {
			sb.append(POSIBILE_CHARS.charAt(RNG.nextInt(POSIBILE_CHARS.length())));
		}

		return sb.toString();
	}

}
