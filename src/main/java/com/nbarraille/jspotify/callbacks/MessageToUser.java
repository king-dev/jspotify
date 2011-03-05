package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface MessageToUser extends StdCallCallback {
	public void message_to_user(sp_session session, String message);
}
