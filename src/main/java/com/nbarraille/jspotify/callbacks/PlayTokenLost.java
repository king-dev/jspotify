package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_session;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface PlayTokenLost extends StdCallCallback {
	public void play_token_lost(sp_session session);
}
