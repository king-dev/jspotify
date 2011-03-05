package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_albumbrowse;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface AlbumbrowseComplete extends StdCallCallback{
	public void albumbrowse_complete_cb(sp_albumbrowse result, Pointer userdata);
}
