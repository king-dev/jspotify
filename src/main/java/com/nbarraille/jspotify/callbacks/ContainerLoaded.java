package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_playlistcontainer;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface ContainerLoaded extends StdCallCallback{
	public void container_loaded(sp_playlistcontainer pc, Pointer userdata);
}
