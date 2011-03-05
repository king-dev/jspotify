package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_playlist;
import com.nbarraille.jspotify.model.sp_track;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface TracksMoved extends StdCallCallback{
	public void tracks_added(sp_playlist pl, sp_track[] tracks, int num_tracks, int position, Pointer userdata);
}