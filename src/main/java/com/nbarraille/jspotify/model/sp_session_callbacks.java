package com.nbarraille.jspotify.model;

import com.nbarraille.jspotify.callbacks.ConnectionError;
import com.nbarraille.jspotify.callbacks.EndOfTrack;
import com.nbarraille.jspotify.callbacks.GetAudioBufferStats;
import com.nbarraille.jspotify.callbacks.LogMessage;
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
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public class sp_session_callbacks extends Structure{
	public static class ByReference extends sp_session_callbacks implements Structure.ByReference { }
	public StdCallCallback logged_in; // Called when login has been processed and was successful
	public LoggedOut logged_out; // Called when logout has been processded. Either called explicitly if you initialize a logout operation, or implicitly if there is a permanent connection error.
	public MetadataUpdated metadata_updated; // Called whenever metadata has been updated. If you have metadata cached outside of libspotify, you should purge your caches and fetch new versions.
	public ConnectionError connection_error; // Called when there is a connection error, and the library has problems reconnecting to the Spotify service. Could be called multiple times (as long as the problem is present)
	public MessageToUser message_to_user; // Called when the acces point wants to display a message to the user. In the desktop client, these are shown in a blueish toolbar just below the search box.
	public NotifyMainThread notify_main_thread; // Called when processing needs to take place on the main thread. You need to call sp_session_process_events() in the main thread to get libspotify to do more work. Failure to do so may cause request timeouts, or a lost connections.
	public MusicDelivery music_delivery; // Called when there is decompressed audio data available.
	public PlayTokenLost play_token_lost; // Music has been paused because only one account may play music at the same time.
	public LogMessage log_message; // Logging callback
	public EndOfTrack end_of_track; // End of track. Called when the currently played track has reached its end.
	public StreamingError streaming_error; // Streaming error. Called when streaming cannot start or continue.
	public UserinfoUpdated userinfo_updated; // Called after user info (anything related to sp_user objects) have been updated.	
	public StartPlayback start_playback; // Called when audio playback should start. For this to work correctly the application must also implement get_audio_buffer_stats(). This function is called from an internal session thread - you need to have proper synchronization. This function must never block.
	public StopPlayback stop_playback; // Called when audio playback should stop. For this to work correctly the application must also implement get_audio_buffer_stats(). This function is called from an internal session thread - you need to have proper synchronization. This function must never block.
	public GetAudioBufferStats get_audio_buffer_stats; // Called to query application about its audio buffer. This function is called from an internal session thread - you need to have proper synchronization! This function must never block.
}
