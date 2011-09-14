package com.nbarraille.jspotify.model;

import com.nbarraille.jspotify.callbacks.DescriptionChanged;
import com.nbarraille.jspotify.callbacks.ImageChanged;
import com.nbarraille.jspotify.callbacks.PlaylistMetadataUpdated;
import com.nbarraille.jspotify.callbacks.PlaylistRenamed;
import com.nbarraille.jspotify.callbacks.PlaylistStateChanged;
import com.nbarraille.jspotify.callbacks.PlaylistUpdateInProgress;
import com.nbarraille.jspotify.callbacks.SubscribersChanged;
import com.nbarraille.jspotify.callbacks.TrackCreatedChanged;
import com.nbarraille.jspotify.callbacks.TrackMessageChanged;
import com.nbarraille.jspotify.callbacks.TrackSeenChanged;
import com.nbarraille.jspotify.callbacks.TracksAdded;
import com.nbarraille.jspotify.callbacks.TracksMoved;
import com.nbarraille.jspotify.callbacks.TracksRemoved;
import com.sun.jna.Structure;

public class sp_playlist_callbacks extends Structure {
	public static class ByReference extends sp_playlist_callbacks implements Structure.ByReference { }
	public TracksAdded tracks_added; // Called when one or more tracks have been added to a playlist.
	public TracksRemoved tracks_removed; // Called when one or more tracks have been removed from a playlist.
	public TracksMoved tracks_moved; // Called when one or more tracks have been moved within a playlist.
	public PlaylistRenamed playlist_renamed; // Called when a playlist has been renamed. sp_playlist_name can be used to find out the new name.
	public PlaylistStateChanged playlist_state_changed; // Called when state changed for a playlist. There are three states that trigger this callback:  Collaboration for this playlist has been turned on or off, The playlist started having pending changes or all pending changed have now been committed, the playlist started loading or finished loading.
	public PlaylistUpdateInProgress playlist_update_in_progress; // Called when a playlist is updating or is done updating. This is called before and after a series of changes are applied to the playlist. It allows e.g. the user interface to defer updating until the entire operation is complete.
	public PlaylistMetadataUpdated playlist_metadata_updated; // Called when metadata for one or more tracks in a playlist has been updated.
	public TrackCreatedChanged track_created_changed; // Called when create time and/or creator for a playlist entry changes.
	public TrackSeenChanged track_seen_changed; // Called when seen attribute for a playlist entry changes.
	public DescriptionChanged description_changed; // Called when playlist description has changed.
	public ImageChanged image_changed; // Called when playlist image has changed.
	public TrackMessageChanged track_message_changed; // Called when message attibute for a playlist entry changes.
	public SubscribersChanged subscribers_changed; // Called when playlist subscribers changes (count or list of names).
}
