package com.nbarraille.jspotify.main;

import java.util.HashMap;
import java.util.Map;

import com.nbarraille.jspotify.callbacks.ConnectionError;
import com.nbarraille.jspotify.callbacks.LoggedIn;
import com.nbarraille.jspotify.model.sp_session;
import com.nbarraille.jspotify.model.sp_session_callbacks;
import com.nbarraille.jspotify.model.sp_session_config;
import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;


public class Test{
	private static final int SPOTIFY_API_VERSION = 7;
	
	static{
		System.loadLibrary("libspotify");
	}
	
	public static void main(String[] args){
		
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(Library.OPTION_FUNCTION_MAPPER, new SpotifyFunctionMapper());
		
		JLibspotify lib = (JLibspotify)Native.loadLibrary("libspotify", JLibspotify.class, options);
		int errorId = 0;
			
		sp_session_config cfg = new sp_session_config();
		cfg.api_version = SPOTIFY_API_VERSION;
		cfg.cache_location = "C:\\jspotify";
		cfg.settings_location = "C:\\jspotify";
		Pointer ptr = new Memory(AppKey.size() * 8);
		ptr.write(0, AppKey.toBytes(), 0, AppKey.size());
		cfg.application_key = ptr;
		cfg.application_key_size = AppKey.size();
		cfg.user_agent = "jspotify";
		
		sp_session_callbacks sessCallbacks = new sp_session_callbacks();
		LoggedIn loggedInCallback = new LoggedIn(){

			public void logged_in(sp_session session, int error) {
				System.out.println("logged_in() called");
			}
			
		};
		
		ConnectionError connErrorCallback = new ConnectionError(){

			public void connection_error(sp_session session, int error) {
				System.out.println("connection_error() called");
			}
			
		};
		sessCallbacks.end_of_track = null;
		sessCallbacks.get_audio_buffer_stats = null;
		sessCallbacks.log_message = null;
		sessCallbacks.logged_out = null;
		
		sessCallbacks.message_to_user = null;
		sessCallbacks.metadata_updated = null;
		sessCallbacks.music_delivery = null;
		sessCallbacks.notify_main_thread = null;
		sessCallbacks.play_token_lost = null;
		sessCallbacks.start_playback = null;
		sessCallbacks.stop_playback = null;
		sessCallbacks.streaming_error = null;
		sessCallbacks.userinfo_updated = null;
		
		sessCallbacks.logged_in = loggedInCallback;
		
		//sessCallbacks.logged_in = null;
		sessCallbacks.connection_error = connErrorCallback;
		//sessCallbacks.connection_error = null;
		
		sessCallbacks.write();
		cfg.callbacks = sessCallbacks;
		
		PointerByReference sessionPbr = new PointerByReference();
		System.out.println("hop");
		errorId = lib.sessionCreate(cfg, sessionPbr);
		System.out.println("hap");
		sp_session session = new sp_session(sessionPbr.getValue());
		
		
		if(errorId != 0){
			System.out.println("error " + errorId);
			return;
		}
		
		System.out.println("no error");
		System.out.println("state " + lib.sessionConnectionstate(session));
		
		//lib.sessionLogin(session, "nbarraille", "u8VqdGkSpVK5");
		
		System.out.println("no error");
		System.out.println("state " + lib.sessionConnectionstate(session));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
			
	}
}