package com.nbarraille.jspotify.model;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;


public class sp_inbox extends PointerType{
	public sp_inbox(Pointer address) {
		super(address);
	}
	public sp_inbox() {
		super();
	}
}
