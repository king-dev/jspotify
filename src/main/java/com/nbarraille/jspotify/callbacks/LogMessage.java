package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface LogMessage extends StdCallCallback {
	public void log_message(sp_session session, String data);
}
