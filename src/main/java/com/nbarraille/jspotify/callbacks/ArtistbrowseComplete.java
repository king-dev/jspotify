package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_artistbrowse;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface ArtistbrowseComplete extends StdCallCallback{
	public void artistbrowse_complete_cb(sp_artistbrowse result, Pointer userdata);
}
