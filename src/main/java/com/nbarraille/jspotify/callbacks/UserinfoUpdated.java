package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface UserinfoUpdated extends StdCallCallback {
	public void userinfo_updated(sp_session session);
}
