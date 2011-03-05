package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_playlist;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface DescriptionChanged extends StdCallCallback{
	public void description_changed(sp_playlist pl, String description, Pointer userdata);
}