package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_playlist;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface PlaylistUpdateInProgress extends StdCallCallback{
	public void playlist_update_in_progress(sp_playlist pl, boolean done, Pointer userdata);
}