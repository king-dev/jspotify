package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_audioformat;
import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface MusicDelivery extends StdCallCallback {
	public void music_delivery(sp_session session, sp_audioformat format, Pointer frames, int num_frames);
}
