package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_playlist;
import com.nbarraille.jspotify.model.sp_user;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface TrackCreatedChanged extends StdCallCallback{
	public void track_created_changed(sp_playlist pl, int position, sp_user user, int when, Pointer userdata);
}