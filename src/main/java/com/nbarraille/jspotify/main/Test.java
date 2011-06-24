package com.nbarraille.jspotify.main;

import java.util.HashMap;
import java.util.Map;

import com.nbarraille.jspotify.callbacks.ConnectionError;
import com.nbarraille.jspotify.callbacks.ContainerLoaded;
import com.nbarraille.jspotify.callbacks.EndOfTrack;
import com.nbarraille.jspotify.callbacks.GetAudioBufferStats;
import com.nbarraille.jspotify.callbacks.LogMessage;
import com.nbarraille.jspotify.callbacks.LoggedIn;
import com.nbarraille.jspotify.callbacks.LoggedOut;
import com.nbarraille.jspotify.callbacks.MessageToUser;
import com.nbarraille.jspotify.callbacks.MetadataUpdated;
import com.nbarraille.jspotify.callbacks.MusicDelivery;
import com.nbarraille.jspotify.callbacks.NotifyMainThread;
import com.nbarraille.jspotify.callbacks.PlayTokenLost;
import com.nbarraille.jspotify.callbacks.StartPlayback;
import com.nbarraille.jspotify.callbacks.StopPlayback;
import com.nbarraille.jspotify.callbacks.StreamingError;
import com.nbarraille.jspotify.callbacks.UserinfoUpdated;
import com.nbarraille.jspotify.model.sp_audio_buffer_stats;
import com.nbarraille.jspotify.model.sp_audioformat;
import com.nbarraille.jspotify.model.sp_playlistcontainer;
import com.nbarraille.jspotify.model.sp_playlistcontainer_callbacks;
import com.nbarraille.jspotify.model.sp_session;
import com.nbarraille.jspotify.model.sp_session_callbacks;
import com.nbarraille.jspotify.model.sp_session_config;
import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallFunctionMapper;


public class Test{
	private static final int SPOTIFY_API_VERSION = 8;
	private static boolean mtNotification = false;
	private static sp_session_callbacks.ByReference sessCallbacks;
	private static sp_playlistcontainer_callbacks.ByReference pcCallbacks;
	
	static{
		NativeLibrary.getInstance("libspotify");
	}
	
	public static void main(String[] args) throws InterruptedException{
		
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(Library.OPTION_FUNCTION_MAPPER, new StdCallFunctionMapper(){});
		
		JLibspotify lib = (JLibspotify)Native.loadLibrary("libspotify", JLibspotify.class, options);
		int errorId = 0;
			
		sp_session_config cfg = new sp_session_config();
		cfg.api_version = SPOTIFY_API_VERSION;
		cfg.cache_location = "C:\\jspotify";
		cfg.settings_location = "C:\\jspotify";
		Pointer appKeyPtr = new Memory(AppKey.size());
		appKeyPtr.write(0, AppKey.toBytes(), 0, AppKey.size());
		cfg.application_key = appKeyPtr;
		cfg.application_key_size = AppKey.size();
		cfg.user_agent = "jspotify";
		
		
		initSessionCallbacks();
		cfg.callbacks = sessCallbacks;
		

		PointerByReference sessionPbr = new PointerByReference();
		errorId = lib.sp_session_create(cfg, sessionPbr);
		sp_session session = new sp_session(sessionPbr.getValue());
		if(errorId != 0){
			System.out.println("error " + errorId);
			return;
		}
		
		
		
		System.out.println("Logging in");
		lib.sp_session_login(session, "nbarraille", "waN779hkGMUGNKx");
		/*
		sp_user user;
		while((user = lib.sp_session_user(session)) == null){}
		sp_playlistcontainer pc = lib.sp_session_publishedcontainer_for_user_create(session, lib.sp_user_canonical_name(user));
		System.out.println("done");
		initPlaylistcontainerCallbacks();
		lib.sp_playlistcontainer_add_callbacks(pc, pcCallbacks, null);
		*/
		while(true){
			if(mtNotification){
				System.out.println("I'm the main thread, and I've been notified");
				mtNotification = false;
			}
			Thread.sleep(500);
			//System.out.println("Checking sessionstate... " + lib.sp_session_connectionstate(session));
		}
		/*
		System.out.println("Logging out");
		lib.sp_session_logout(session);
		*/
	}
	
	public static void initSessionCallbacks(){
		sessCallbacks = new sp_session_callbacks.ByReference();
		sessCallbacks.end_of_track = new EndOfTrack(){
			public void end_of_track(sp_session session){
				System.out.println("end_of_track() called");
			}
		};
		sessCallbacks.get_audio_buffer_stats = new GetAudioBufferStats(){
			public void get_audio_buffer_stats(sp_session session, sp_audio_buffer_stats stats){
				System.out.println("get_audio_buffer_stats() called");
			}
		};
		sessCallbacks.metadata_updated = new MetadataUpdated(){
			public void metadata_updated(sp_session session){
				System.out.println("metadata_updated() called");
			}
		};
		sessCallbacks.music_delivery = new MusicDelivery(){
			public void music_delivery(sp_session session, sp_audioformat format, Pointer frames, int num_frames){
				System.out.println("music_delivery() called");
			}
		};
		sessCallbacks.notify_main_thread = new NotifyMainThread(){
			public void notify_main_thread(sp_session session){
				System.out.println("notify_main_thread() called");
				mtNotification = true;
			}
		};
		sessCallbacks.play_token_lost = new PlayTokenLost(){
			public void play_token_lost(sp_session session){
				System.out.println("play_token_lost() called");
			}
		};
		sessCallbacks.start_playback = new StartPlayback(){
			public void start_playback(sp_session session){
				System.out.println("start_playback() called");
			}
		};
		sessCallbacks.stop_playback = new StopPlayback(){
			public void stop_playback(sp_session session){
				System.out.println("stop_playback() called");
			}
		};
		sessCallbacks.streaming_error = new StreamingError(){
			public void streaming_error(sp_session session, int error){
				System.out.println("streaming_error() called: " + error);
			}
		};
		sessCallbacks.userinfo_updated = new UserinfoUpdated(){
			public void userinfo_updated(sp_session session){
				System.out.println("userinfo_updated() called");
			}
		};
		
		sessCallbacks.logged_out = new LoggedOut() {
            public void logged_out(sp_session session) {
                System.out.println("logged_out() called");
            }
        };
		sessCallbacks.message_to_user = new MessageToUser() {
            public void message_to_user(sp_session session, String message) {
                System.out.println("message_to_user() called:" + message);
            }
        };
		sessCallbacks.log_message = new LogMessage() {
            public void cb(sp_session session, String message) {
                System.out.println("log_message() called:" + message);
            }
        };
		sessCallbacks.logged_in = new LoggedIn(){
			public void logged_in(sp_session session, int error) {
				System.out.println("logged_in() called");
			}
		};
		
		sessCallbacks.connection_error = new ConnectionError(){
			public void connection_error(sp_session session, int error) {
				System.out.println("connection_error() called" + error);
			}
		};
	}
	
	public static void initPlaylistcontainerCallbacks(){
		pcCallbacks = new sp_playlistcontainer_callbacks.ByReference();
		pcCallbacks.container_loaded = new ContainerLoaded(){
			public void container_loaded(sp_playlistcontainer pc, Pointer userdata){
				System.out.println("container_loaded() called");
			}
		};
		pcCallbacks.playlist_added = null;
		pcCallbacks.playlist_moved = null;
		pcCallbacks.playlist_removed = null;
	}
	
}