package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface StopPlayback extends StdCallCallback {
	public void stop_playback(sp_session session);
}
