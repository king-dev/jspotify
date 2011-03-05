package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_playlist;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface TracksRemoved extends StdCallCallback{
	public void tracks_moved(sp_playlist pl, int[] tracks, int num_tracks, int new_position, Pointer userdata);
}