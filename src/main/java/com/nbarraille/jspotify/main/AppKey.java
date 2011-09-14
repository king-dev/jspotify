package com.nbarraille.jspotify.main;

public class AppKey {
	private static final char[] APP_KEY = { 0xCA, 0xFE, 0xBA, 0xBE };

	public static byte[] toBytes() {
		byte[] b = new byte[APP_KEY.length];
		for (int i = 0; i < APP_KEY.length; i++) {
			if (APP_KEY[i] > 127) {
				b[i] = (byte) (APP_KEY[i] - 256);
			} else {
				b[i] = (byte) APP_KEY[i];
			}
		}
		return b;
	}

	public static int size() {
		return APP_KEY.length;
	}
}
