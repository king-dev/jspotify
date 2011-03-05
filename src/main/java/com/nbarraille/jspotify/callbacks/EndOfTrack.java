package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface EndOfTrack extends StdCallCallback {
	public void end_of_track(sp_session session);
}
