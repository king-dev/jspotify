package com.nbarraille.jspotify.model;

import com.sun.jna.Structure;

public class sp_audio_buffer_stats extends Structure{
	public int samples; // Samples in buffer.
	public int stutter; // Number of stutters (audio dropouts) since last query.
}
