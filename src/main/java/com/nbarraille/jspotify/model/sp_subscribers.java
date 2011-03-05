package com.nbarraille.jspotify.model;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class sp_subscribers extends Structure{
	public Pointer[] subscribers;
}
