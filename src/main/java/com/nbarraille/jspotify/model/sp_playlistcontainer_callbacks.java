package com.nbarraille.jspotify.model;

import com.nbarraille.jspotify.callbacks.ContainerLoaded;
import com.nbarraille.jspotify.callbacks.PlaylistAdded;
import com.nbarraille.jspotify.callbacks.PlaylistMoved;
import com.nbarraille.jspotify.callbacks.PlaylistRemoved;
import com.sun.jna.Structure;

public class sp_playlistcontainer_callbacks extends Structure {
	public static class ByReference extends sp_playlistcontainer_callbacks implements Structure.ByReference { }
	public PlaylistAdded playlist_added; // Called when a new playlist has been added to the playlist container.
	public PlaylistRemoved playlist_removed; // Called when a playlist has been removed from the playlist container.
	public PlaylistMoved playlist_moved; // Called when a playlist has been moved in the playlist container.
	public ContainerLoaded container_loaded; // Called when the playlist container is loaded.
}
