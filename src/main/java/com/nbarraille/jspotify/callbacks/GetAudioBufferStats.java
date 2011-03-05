package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_audio_buffer_stats;
import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface GetAudioBufferStats extends StdCallCallback {
	public void get_audio_buffer_stats(sp_session session, sp_audio_buffer_stats stats);
}
