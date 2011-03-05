package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_inbox;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface InboxpostComplete extends StdCallCallback{
	public void inboxpost_complete_cb(sp_inbox result, Pointer userdata);
}
