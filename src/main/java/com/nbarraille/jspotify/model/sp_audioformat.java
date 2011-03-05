package com.nbarraille.jspotify.model;

import com.nbarraille.jspotify.enums.sp_sampletype;
import com.sun.jna.Structure;

public class sp_audioformat extends Structure{
	public sp_sampletype sample_type; // Sample type enum,.
	public int sample_rate; // Audio sample rate, in samples per second.
	public int channels; // Number of channels. Currently 1 or 2.
}
