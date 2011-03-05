package com.nbarraille.jspotify.callbacks;

import com.nbarraille.jspotify.model.sp_image;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public interface ImageLoaded extends StdCallCallback{
	public void image_loaded(sp_image image, Pointer userdata);
}
