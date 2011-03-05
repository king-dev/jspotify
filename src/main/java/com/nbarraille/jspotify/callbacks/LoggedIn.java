package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface LoggedIn extends StdCallCallback {
	public void logged_in(sp_session session, int error);
}
