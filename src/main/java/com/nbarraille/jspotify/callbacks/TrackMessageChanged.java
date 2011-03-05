package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_playlist;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface TrackMessageChanged extends StdCallCallback{
	public void track_message_changed(sp_playlist pl, int position, String message, Pointer userdata);
}