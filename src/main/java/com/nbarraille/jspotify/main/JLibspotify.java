package com.nbarraille.jspotify.main;

import java.nio.Buffer;

import com.nbarraille.jspotify.callbacks.AlbumbrowseComplete;
import com.nbarraille.jspotify.callbacks.ArtistbrowseComplete;
import com.nbarraille.jspotify.callbacks.ImageLoaded;
import com.nbarraille.jspotify.callbacks.InboxpostComplete;
import com.nbarraille.jspotify.callbacks.SearchComplete;
import com.nbarraille.jspotify.callbacks.ToplistbrowseComplete;
import com.nbarraille.jspotify.model.sp_album;
import com.nbarraille.jspotify.model.sp_albumbrowse;
import com.nbarraille.jspotify.model.sp_artist;
import com.nbarraille.jspotify.model.sp_artistbrowse;
import com.nbarraille.jspotify.model.sp_image;
import com.nbarraille.jspotify.model.sp_inbox;
import com.nbarraille.jspotify.model.sp_link;
import com.nbarraille.jspotify.model.sp_playlist;
import com.nbarraille.jspotify.model.sp_playlist_callbacks;
import com.nbarraille.jspotify.model.sp_playlistcontainer;
import com.nbarraille.jspotify.model.sp_playlistcontainer_callbacks;
import com.nbarraille.jspotify.model.sp_search;
import com.nbarraille.jspotify.model.sp_session;
import com.nbarraille.jspotify.model.sp_session_config;
import com.nbarraille.jspotify.model.sp_subscribers;
import com.nbarraille.jspotify.model.sp_toplistbrowse;
import com.nbarraille.jspotify.model.sp_track;
import com.nbarraille.jspotify.model.sp_user;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface JLibspotify extends StdCallLibrary{
	
	// Methods definitions
	
	// Album methods
	boolean sp_album_is_loaded(sp_album album);
	boolean sp_album_is_available(sp_album album);
	sp_artist sp_album_artist(sp_album album);
	String sp_album_cover(sp_album album);
	String sp_album_name(sp_album album);
	int sp_album_year(sp_album album);
	int sp_album_type(sp_album album);
	void sp_album_add_ref(sp_album album);
	void sp_album_release(sp_album album);
	
	// Albumbrowse methods
	sp_albumbrowse sp_albumbrowse_create(sp_session session, sp_album album, AlbumbrowseComplete callback, Pointer userdata);
	boolean sp_albumbrowse_is_loaded(sp_albumbrowse alb);
	int sp_albumbrowse_error(sp_albumbrowse alb);
	sp_album sp_albumbrowse_album(sp_albumbrowse alb);
	sp_artist sp_albumbrowse_artist(sp_albumbrowse alb);
	int sp_albumbrowse_num_copyrights(sp_albumbrowse alb);
	String sp_albumbrowse_copyright(sp_albumbrowse alb, int index);
	int sp_albumbrowse_num_tracks(sp_albumbrowse alb);
	sp_track sp_albumbrowse_track(sp_albumbrowse alb, int index);
	String sp_albumbrowse_review(sp_albumbrowse alb);
	void sp_albumbrowse_add_ref(sp_albumbrowse alb);
	void sp_albumbrowse_release(sp_albumbrowse alb);
	
	// Artist methods
	String sp_artist_name(sp_artist artist);
	boolean sp_artist_is_loaded(sp_artist artist);
	void sp_artist_add_ref(sp_artist artist);
	void sp_artist_release(sp_artist artist);
	
	// Artistbrowse methods
	sp_artistbrowse sp_artistbrowse_create(sp_session session, sp_artist artist, ArtistbrowseComplete callback, Pointer userdata);
	boolean sp_artistbrowse_is_loaded(sp_artistbrowse arb);
	int sp_artistbrowse_error(sp_artistbrowse arb);
	sp_artist sp_artistbrowse_artist(sp_artistbrowse arb);
	int sp_artistbrowse_num_portraits(sp_artistbrowse arb);
	String sp_artistbrowse_portrait(sp_artistbrowse arb, int index);
	int sp_artistbrowse_num_tracks(sp_artistbrowse arb);
	sp_track sp_artistbrowse_track(sp_artistbrowse arb, int index);
	int sp_artistbrowse_num_albums(sp_artistbrowse arb);
	sp_album sp_artistbrowse_album(sp_artistbrowse arb, int index);
	int sp_artistbrowse_num_similar_artists(sp_artistbrowse arb);
	sp_artist sp_artistbrowse_similar_artist(sp_artistbrowse arb, int index);
	String sp_artistbrowse_biography(sp_artistbrowse arb);
	void sp_artistbrowse_add_ref(sp_artistbrowse arb);
	void sp_artistbrowse_release(sp_artistbrowse arb);
	
	// Image methods
	sp_image sp_image_create(sp_session session, String image_id);
	void sp_image_add_load_callback(sp_image image, ImageLoaded callback, Pointer userdata);
	void sp_image_remove_load_callback(sp_image image, ImageLoaded callback, Pointer userdata);
	boolean sp_image_is_loaded(sp_image image);
	int sp_image_error(sp_image image);
	int sp_image_format(sp_image image);
	Buffer sp_image_data(sp_image image, int data_size);
	String sp_image_image_id(sp_image image);
	void sp_image_add_ref(sp_image image);
	void sp_image_release(sp_image image);
	
	// Search methods
	sp_search sp_seach_create(sp_session session, String query, int track_offset, int track_count,int album_offset, 
			int album_count, int artist_offset, int artist_count, SearchComplete callback, Pointer userdata);
	sp_search sp_radio_search_create(sp_session session, int from_year, int to_year, int genres,
			SearchComplete callback, Pointer userdata);
	boolean sp_search_is_loaded(sp_search search);
	int sp_search_error(sp_search search);
	int sp_search_num_tracks(sp_search search);
	sp_track sp_search_track(sp_search search, int index);
	int sp_search_num_albums(sp_search search);
	sp_album sp_search_album(sp_search search, int index);
	int sp_search_num_artists(sp_search search);
	sp_artist sp_search_artist(sp_search search, int index);
	String sp_search_query(sp_search search);
	String sp_search_did_you_mean(sp_search search);
	int sp_search_total_tracks(sp_search search);
	int sp_search_total_albums(sp_search search);
	int sp_search_total_artists(sp_search search);
	void sp_search_add_ref(sp_search search);
	void sp_search_release(sp_search search);
	
	// Playlist methods
	boolean sp_playlist_is_loaded(sp_playlist playlist);
	void sp_playlist_add_callbacks(sp_playlist playlist, sp_playlist_callbacks callbacks, Pointer userdata);
	void sp_playlist_remove_callbacks(sp_playlist playlist, sp_playlist_callbacks callbacks, Pointer userdata);
	int sp_playlist_num_tracks(sp_playlist playlist);
	sp_track sp_playlist_track(sp_playlist playlist, int index);
	int sp_playlist_track_create_time(sp_playlist playlist, int index);
	sp_user sp_playlist_track_creator(sp_playlist playlist, int index);
	boolean sp_playlist_track_seen(sp_playlist playlist, int index);
	int sp_playlist_track_set_seen(sp_playlist playlist, int index, boolean seen);
	String sp_playlist_track_message(sp_playlist playlist, int index);
	String sp_playlist_name(sp_playlist playlist);
	int sp_playlist_rename(sp_playlist playlist, String new_name);
	sp_user sp_playlist_owner(sp_playlist playlist);
	boolean sp_playlist_is_collaborative(sp_playlist playlist);
	void sp_playlist_set_collaborative(sp_playlist playlist, boolean collaborative);
	void sp_playlist_set_autolink_tracks(sp_playlist playlist, boolean link);
	String sp_playlist_get_description(sp_playlist playlist);
	boolean sp_playlist_get_image(sp_playlist playlist, Buffer image);
	boolean sp_playlist_has_pending_change(sp_playlist playlist);
	int sp_playlist_add_tracks(sp_playlist playlist, sp_track[] tracks, int num_tracks, sp_session session);
	int sp_playlist_remove_tracks(sp_playlist playlist, int[] tracks, int num_tracks);
	int sp_playlist_reorder_tracks(sp_playlist playlist, int[] tracks, int num_tracks, int new_position);
	int sp_playlist_num_subscribers(sp_playlist playlist);
	sp_subscribers sp_playlist_subscribers(sp_playlist playlist);
	void sp_playlist_subscribers_free(sp_subscribers subscribers);
	void sp_playlist_update_subscribers(sp_session session, sp_playlist playlist);
	boolean sp_playlist_is_in_ram(sp_session session, sp_playlist playlist);
	void sp_playlist_set_in_ram(sp_session session, sp_playlist playlist, boolean in_ram);
	sp_playlist sp_playlist_create(sp_session session, sp_link link);
	void sp_playlist_add_ref(sp_playlist playlist);
	void sp_playlist_release(sp_playlist playlist);
	void sp_playlistcontainer_add_callbacks(sp_playlistcontainer pc, sp_playlistcontainer_callbacks callbacks, Pointer userdata);
	void sp_splaylistcontainer_remove_callbacks(sp_playlistcontainer pc, sp_playlistcontainer_callbacks callbacks, Pointer userdata);
	int sp_playlistcontainer_num_playlists(sp_playlistcontainer pc);
	sp_playlist sp_playlistcontainer_playlist(sp_playlistcontainer pc, int index);
	int sp_playlistcontainer_playlist_type(sp_playlistcontainer pc, int index);
	int sp_playlistcontainer_playlist_folder_name(sp_playlistcontainer pc, int index, String buffer, int buffer_size);
	int sp_playlistcontainer_playlist_folder_id(sp_playlistcontainer pc, int index);
	sp_playlist sp_playlistcontainer_add_new_playlist(sp_playlistcontainer pc, String name);
	sp_playlist sp_playlistcontainer_add_playlist(sp_playlistcontainer pc, sp_link link);
	int sp_playlistcontainer_remove_playlist(sp_playlistcontainer pc, int index);
	int sp_playlistcontainer_move_playlist(sp_playlistcontainer pc, int index, int new_position, boolean dry_run);
	int sp_playlistcontainer_add_folder(sp_playlistcontainer pc, int index, String name);
	sp_user sp_playlistcontainer_owner(sp_playlistcontainer pc);
	void sp_playlistcontainer_add_ref(sp_playlistcontainer pc);
	void sp_playlistcontainer_release(sp_playlistcontainer pc);
	
	// Toplist methods
	sp_toplistbrowse sp_toplistbrowse_create(sp_session session, int type, int region, String username, 
			ToplistbrowseComplete callback, Pointer userdata);
	boolean sp_toplistbrowse_is_loaded(sp_toplistbrowse tlb);
	int sp_toplistbrowse_error(sp_toplistbrowse tlb);
	void sp_toplistbrowse_add_ref(sp_toplistbrowse tlb);
	void sp_toplistbrowse_release(sp_toplistbrowse tlb);
	int sp_toplistbrowse_num_artists(sp_toplistbrowse tlb);
	sp_artist sp_toplistbrowse_artist(sp_toplistbrowse tlb, int index);
	int sp_toplistbrowse_num_albums(sp_toplistbrowse tlb);
	sp_album sp_toplistbrowse_album(sp_toplistbrowse tlb, int index);
	int sp_toplistbrowse_num_tracks(sp_toplistbrowse tlb);
	sp_track sp_toplistbrowse_track(sp_toplistbrowse tlb, int index);
	
	// User methods
	String sp_user_canonical_name(sp_user user);
	String sp_user_display_name(sp_user user);
	boolean sp_user_is_loaded(sp_user user);
	String sp_user_full_name(sp_user user);
	String sp_user_picture(sp_user user);
	int sp_user_relation_type(sp_session session, sp_user user);
	void sp_user_add_ref(sp_user user);
	void sp_user_release(sp_user user);
	
	// Inbox methods
	sp_inbox sp_inbox_post_tracks(sp_session session, String user, sp_track[] tracks, int num_tracks, String message,
			InboxpostComplete callback, Pointer userdata);
	int sp_inbox_error(sp_inbox inbox);
	void sp_inbox_add_ref(sp_inbox inbox);
	void sp_inbox_release(sp_inbox inbox);
	
	// Link methods
	sp_link sp_link_create_from_string(String link);
	sp_link sp_link_create_from_track(sp_track track, int offset);
	sp_link sp_link_create_from_album(sp_album album);
	sp_link sp_link_create_from_artist(sp_artist artist);
	sp_link sp_link_create_from_search(sp_search search);
	sp_link sp_link_create_from_playlist(sp_playlist playlist);
	sp_link sp_link_create_from_user(sp_user user);
	int sp_link_as_string(sp_link link, String buffer, int buffer_size);
	int sp_link_type(sp_link link);
	sp_track sp_link_as_track(sp_link link);
	sp_album sp_link_as_album(sp_link link);
	sp_artist sp_link_as_artist(sp_link link);
	sp_user sp_link_as_user(sp_link link);
	void sp_link_add_ref(sp_link link);
	void sp_link_release(sp_link link);
	
	// Track methods
	boolean sp_track_is_loaded(sp_track track);
	int sp_track_error(sp_track track);
	boolean sp_track_is_available(sp_session session, sp_track track);
	boolean sp_track_is_local(sp_track track);
	boolean sp_track_is_autolinked(sp_session session, sp_track track);
	boolean sp_track_is_starred(sp_session session, sp_track track);
	void sp_track_set_starred(sp_session session, sp_track track);
	int sp_track_num_artists(sp_track track);
	sp_artist sp_track_artist(sp_track track, int index);
	sp_album sp_track_album(sp_track track);
	String sp_track_name(sp_track track);
	int sp_track_duration(sp_track track);
	int sp_track_popularity(sp_track track);
	int sp_track_disc(sp_track track);
	int sp_track_index(sp_track track);
	sp_track sp_localtrack_create(String artist, String title, String album, int length);
	void sp_track_add_ref(sp_track track);
	void sp_track_release(sp_track track);
	
	// Session methods
	int sp_session_create(sp_session_config config, PointerByReference sess);
	void sp_session_release(sp_session session);
	int sp_session_login(sp_session session, String username, String password);
	sp_user sp_session_user(sp_session session);
	void sp_session_logout(sp_session session);
	int sp_session_connectionstate(sp_session session);
	Pointer sp_session_userdata(sp_session session);
	void sp_session_set_cache_size(sp_session session, int size);
	void sp_session_process_events(sp_session session, IntByReference next_timeout);
	int sp_session_player_load(sp_session session, sp_track track);
	void sp_session_player_seek(sp_session session, int offset);
	void sp_session_player_play(sp_session session, boolean play);
	void sp_session_player_unload(sp_session session);
	int sp_session_player_prefetch(sp_session session, sp_track track);
	sp_playlistcontainer sp_session_publishedcontainer_for_user_create(sp_session session, String canonical_username);
	void sp_session_preferred_bitrate(sp_session session, int bitrate);
	int sp_session_num_friends(sp_session session);
	sp_user sp_session_friend(sp_session session, int index);
	
	// Error methods
	String sp_error_message(int error);
	
}