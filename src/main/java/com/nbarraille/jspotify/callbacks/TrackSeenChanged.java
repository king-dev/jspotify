package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_playlist;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface TrackSeenChanged extends StdCallCallback{
	public void track_seen_changed(sp_playlist pl, int position, boolean seen, Pointer userdata);
}