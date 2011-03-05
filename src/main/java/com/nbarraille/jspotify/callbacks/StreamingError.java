package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface StreamingError extends StdCallCallback {
	public void streaming_error(sp_session session, int error);
}
