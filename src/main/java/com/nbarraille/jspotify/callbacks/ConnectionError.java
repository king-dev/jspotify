package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface ConnectionError extends StdCallCallback {
	public void connection_error(sp_session session, int error);
}
