package com.nbarraille.jspotify.model;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class sp_session_config extends Structure {
	public int api_version; // The version of the Spotify API your application
							// is compiled with.
	public String cache_location;
	public String settings_location;
	public Pointer application_key; // Your application key.
	public int application_key_size; // The size of the application key in bytes
	public String user_agent;
	public sp_session_callbacks.ByReference callbacks; // Delivery callbacks for
														// session events. NULL
														// if not interested in
														// any callbacks
	public Pointer userdata; // User supplied data for your application
	public boolean compress_playlists;
	public boolean dont_save_metadata_for_playlists;
	public boolean initially_unload_playlists;
	
	public sp_session_config() {}
	
	public sp_session_config(int apiVersion, String cacheLocation, String settingsLocation, char[] appKey) {
		api_version = apiVersion;
		cache_location = cacheLocation;
		settings_location = settingsLocation;
		Pointer appKeyPtr = new Memory(appKey.length);
		appKeyPtr.write(0, appKeyToBytes(appKey), 0, appKey.length);
		application_key = appKeyPtr;
		application_key_size = appKey.length;
		user_agent = "jspotify";
	}
	
	public static byte[] appKeyToBytes(char[] appKey) {
		byte[] b = new byte[appKey.length];
		for (int i = 0; i < appKey.length; i++) {
			if (appKey[i] > 127) {
				b[i] = (byte) (appKey[i] - 256);
			} else {
				b[i] = (byte) appKey[i];
			}
		}
		return b;
	}

}
