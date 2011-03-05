package com.nbarraille.jspotify.enums;

public interface sp_connectionstate {
	public static final int SP_CONNECTION_STATE_LOGGED_OUT = 0; // User not yet logged in
	public static final int SP_CONNECTION_STATE_LOGGED_IN = 1; // Logged in against a Spotify access point
	public static final int SP_CONNECTION_STATE_DISCONNECTED = 2; // Was logged in but has now been disconnected
	public static final int SP_CONNECTION_STATE_UNDEFINED = 3; // The connection state is undefined
}
