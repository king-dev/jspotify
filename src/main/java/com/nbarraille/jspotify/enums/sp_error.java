package com.nbarraille.jspotify.enums;

public interface sp_error {
	public static final int SP_ERROR_OK = 0; // No errors encountered
	public static final int SP_ERROR_BAD_API_VERSION = 1; // The library version targeted does not match the one you claim you support
	public static final int SP_ERROR_API_INITIALIZATION_FAILED = 2; // Initialization of library failed - are cache locations etc. valid?
	public static final int SP_ERROR_TRACK_NOT_PLAYABLE = 3; // The track specified for playing cannot be played
	public static final int SP_ERROR_RESOURCE_NOT_LOADED = 4; // One or several of the supplied resources is not yet loaded
	public static final int SP_ERROR_BAD_APPLICATION_KEY = 5; // The application key is invalid
	public static final int SP_ERROR_BAD_USERNAME_OR_PASSWORD = 6; // Login failed because of bad username and/or password
	public static final int SP_ERROR_USER_BANNED = 7; // The specified username is banned
	public static final int SP_ERROR_UNABLE_TO_CONTACT_SERVER = 8; // Cannot connect to the spotify backend system
	public static final int SP_ERROR_CLIENT_TOO_OLD = 9; // Client is too old, library will need to be updated
	public static final int SP_ERROR_OTHER_PERMANENT = 10; // Some other error occured, and it is permanent (e.g. trying to relogin will not help
	public static final int SP_ERROR_BAD_USER_AGENT = 11; // The user agent string is invalid or too long
	public static final int SP_ERROR_MISSING_CALLBACK = 12; // No valid callback registered to handle events
	public static final int SP_ERROR_INVALID_INDATA = 13; // Input data was either missing or invalid
	public static final int SP_ERROR_INDEX_OUT_OF_RANGE = 14; // Index out of range
	public static final int SP_ERROR_USER_NEEDS_PREMIUM = 15; // The specified user needs a premium account
	public static final int SP_ERROR_OTHER_TRANSIENT = 16; // A Transient error occured
	public static final int SP_ERROR_IS_LOADING = 17; // The resource is currently loading
	public static final int SP_ERROR_NO_STREAM_AVAILABLE = 18; // Could not find any suitable stream to play
	public static final int SP_ERROR_PERMISSION_DENIED = 19; // Requested operation is not allowed
	public static final int SP_ERROR_INBOX_IS_FULL = 20; // Target inbox is full
	public static final int SP_ERROR_NO_CACHE = 21; // Cache is not enabled
	public static final int SP_ERROR_NO_SUCH_USER = 22; // Requested user does not exist
}
