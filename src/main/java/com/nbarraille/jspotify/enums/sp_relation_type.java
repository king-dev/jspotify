package com.nbarraille.jspotify.enums;

public interface sp_relation_type {
	public static final int SP_RELATION_TYPE_UNKNOWN = 0; // Not yet known
	public static final int SP_RELATION_TYPE_NONE = 1; // No relation
	public static final int SP_RELATION_TYPE_UNIDIRECTIONAL = 2; // The currently logged in user is following this user
	public static final int SP_RELATION_TYPE_BIDIRECTIONAL = 3; // Bidirectional friendship established
}
