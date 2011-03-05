package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface NotifyMainThread extends StdCallCallback {
	public void notify_main_thread(sp_session session);
}
