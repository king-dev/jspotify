package com.nbarraille.jspotify.model;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;


public class sp_toplistbrowse extends PointerType{
	public sp_toplistbrowse(Pointer address) {
		super(address);
	}
	public sp_toplistbrowse() {
		super();
	}
}
