package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_playlist;
import com.nbarraille.jspotify.model.sp_playlistcontainer;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface PlaylistRemoved extends StdCallCallback{
	public void playlist_removed(sp_playlistcontainer pc, sp_playlist playlist, int position, Pointer userdata);
}
