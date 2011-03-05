package com.nbarraille.jspotify.model;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;


public class sp_search extends PointerType{
	public sp_search(Pointer address) {
		super(address);
	}
	public sp_search() {
		super();
	}
}
