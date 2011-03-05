package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_search;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface SearchComplete extends StdCallCallback{
	public void search_complete_cb(sp_search result, Pointer userdata);
}
