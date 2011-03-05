package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_toplistbrowse;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface ToplistbrowseComplete extends StdCallCallback{
	public void toplistbrowse_complete_cb(sp_toplistbrowse result, Pointer userdata);
}
