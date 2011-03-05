package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_playlist;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface PlaylistStateChanged extends StdCallCallback{
	public void playlist_state_changed(sp_playlist pl, Pointer userdata);
}