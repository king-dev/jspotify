package com.nbarraille.jspotify.enums;

public interface sp_linktype {
	public static final int SP_LINKTYPE_INVALID = 0; // Link type not valid - default until the library has parsed the link, or when parsing failed
	public static final int SP_LINKTYPE_TRACK = 1; // Link type is track
	public static final int SP_LINKTYPE_ALBUM = 2; // Link type is album
	public static final int SP_LINKTYPE_ARTIST = 3; // Link type is artist
	public static final int SP_LINKTYPE_SEARCH = 4; // Link type is search
	public static final int SP_LINKTYPE_PLAYLIST = 5; // Link type is playlist
	public static final int SP_LINKTYPE_PROFILE = 6; // Link type is profile
	public static final int SP_LINKTYPE_STARRED = 7; // Link type is starred
	public static final int SP_LINKTYPE_LOCALTRACK = 8; // Link type is a local file
}
