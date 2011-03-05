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
	boolean albumIsLoaded(sp_album album);
	boolean albumIsAvailable(sp_album album);
	sp_artist albumArtist(sp_album album);
	String albumCover(sp_album album);
	String albumName(sp_album album);
	int albumYear(sp_album album);
	int albumType(sp_album album);
	void albumAddRef(sp_album album);
	void albumRelease(sp_album album);
	
	// Albumbrowse methods
	sp_albumbrowse albumbrowseCreate(sp_session session, sp_album album, AlbumbrowseComplete callback, Pointer userdata);
	boolean albumbrowseIsLoaded(sp_albumbrowse alb);
	int albumbrowseError(sp_albumbrowse alb);
	sp_album albumbrowseAlbum(sp_albumbrowse alb);
	sp_artist albumbrowseArtist(sp_albumbrowse alb);
	int albumbrowseNumCopyrights(sp_albumbrowse alb);
	String albumbrowseCopyright(sp_albumbrowse alb, int index);
	int albumbrowseNumTracks(sp_albumbrowse alb);
	sp_track albumbrowseTrack(sp_albumbrowse alb, int index);
	String albumbrowseReview(sp_albumbrowse alb);
	void albumbrowseAddRef(sp_albumbrowse alb);
	void albumbrowseRelease(sp_albumbrowse alb);
	
	// Artist methods
	String artistName(sp_artist artist);
	boolean artistIsLoaded(sp_artist artist);
	void artistAddRef(sp_artist artist);
	void artistRelease(sp_artist artist);
	
	// Artistbrowse methods
	sp_artistbrowse artistbrowseCreate(sp_session session, sp_artist artist, ArtistbrowseComplete callback, Pointer userdata);
	boolean artistbrowseIsLoaded(sp_artistbrowse arb);
	int artistbrowseError(sp_artistbrowse arb);
	sp_artist artistbrowseArtist(sp_artistbrowse arb);
	int artistbrowseNumPortraits(sp_artistbrowse arb);
	String artistbrowsePortrait(sp_artistbrowse arb, int index);
	int artistbrowseNumTracks(sp_artistbrowse arb);
	sp_track artistbrowseTrack(sp_artistbrowse arb, int index);
	int artistbrowseNumAlbums(sp_artistbrowse arb);
	sp_album artistbrowseAlbum(sp_artistbrowse arb, int index);
	int artistbrowseNumSimilarArtists(sp_artistbrowse arb);
	sp_artist artistbrowseSimilarArtist(sp_artistbrowse arb, int index);
	String artistbrowseBiography(sp_artistbrowse arb);
	void artistbrowseAddReg(sp_artistbrowse arb);
	void artistbrowseRelease(sp_artistbrowse arb);
	
	// Image methods
	sp_image imageCreate(sp_session session, String image_id);
	void imageAddLoadCallback(sp_image image, ImageLoaded callback, Pointer userdata);
	void imageRemoveLoadCallback(sp_image image, ImageLoaded callback, Pointer userdata);
	boolean imageIsLoaded(sp_image image);
	int imageError(sp_image image);
	int imageFormat(sp_image image);
	Buffer imageData(sp_image image, int data_size);
	String imageImageId(sp_image image);
	void imageAddRef(sp_image image);
	void imageRelease(sp_image image);
	
	// Search methods
	sp_search seachCreate(sp_session session, String query, int track_offset, int track_count,int album_offset, 
			int album_count, int artist_offset, int artist_count, SearchComplete callback, Pointer userdata);
	sp_search radioSearchCreate(sp_session session, int from_year, int to_year, int genres,
			SearchComplete callback, Pointer userdata);
	boolean searchIsLoaded(sp_search search);
	int searchError(sp_search search);
	int searchNumTracks(sp_search search);
	sp_track searchTrack(sp_search search, int index);
	int searchNumAlbums(sp_search search);
	sp_album searchAlbum(sp_search search, int index);
	int searchNumArtists(sp_search search);
	sp_artist searchArtist(sp_search search, int index);
	String searchQuery(sp_search search);
	String searchDidYouMean(sp_search search);
	int searchTotalTracks(sp_search search);
	int searchTotalAlbums(sp_search search);
	int searchTotalArtists(sp_search search);
	void searchAddRef(sp_search search);
	void searchRelease(sp_search search);
	
	// Playlist methods
	boolean playlistIsLoaded(sp_playlist playlist);
	void playlistAddCallbacks(sp_playlist playlist, sp_playlist_callbacks callbacks, Pointer userdata);
	void playlistRemoveCallbacks(sp_playlist playlist, sp_playlist_callbacks callbacks, Pointer userdata);
	int playlistNumTracks(sp_playlist playlist);
	sp_track playlistTrack(sp_playlist playlist, int index);
	int playlistTrackCreateTime(sp_playlist playlist, int index);
	sp_user playlistTrackCreator(sp_playlist playlist, int index);
	boolean playlistTrackSeen(sp_playlist playlist, int index);
	int playlistTrackSetSeen(sp_playlist playlist, int index, boolean seen);
	String playlistTrackMessage(sp_playlist playlist, int index);
	String playlistName(sp_playlist playlist);
	int playlistRename(sp_playlist playlist, String new_name);
	sp_user playlistOwner(sp_playlist playlist);
	boolean playlistIsCollaborative(sp_playlist playlist);
	void playlistSetCollaborative(sp_playlist playlist, boolean collaborative);
	void playlistSetAutolinkTracks(sp_playlist playlist, boolean link);
	String playlistGetDescription(sp_playlist playlist);
	boolean playlistGetImage(sp_playlist playlist, Buffer image);
	boolean playlistHasPendingChange(sp_playlist playlist);
	int playlistAddTracks(sp_playlist playlist, sp_track[] tracks, int num_tracks, sp_session session);
	int playlistRemoveTracks(sp_playlist playlist, int[] tracks, int num_tracks);
	int playlistReorderTracks(sp_playlist playlist, int[] tracks, int num_tracks, int new_position);
	int playlistNumSubscribers(sp_playlist playlist);
	sp_subscribers playlistSubscribers(sp_playlist playlist);
	void playlistSubscribersFree(sp_subscribers subscribers);
	void playlistUpdateSubscribers(sp_session session, sp_playlist playlist);
	boolean playlistIsInRam(sp_session session, sp_playlist playlist);
	void playlistSetInRam(sp_session session, sp_playlist playlist, boolean in_ram);
	sp_playlist playlistCreate(sp_session session, sp_link link);
	void playlistAddRef(sp_playlist playlist);
	void playlistRelease(sp_playlist playlist);
	void playlistcontainerAddCallbacks(sp_playlistcontainer pc, sp_playlistcontainer_callbacks callbacks, Pointer userdata);
	void splaylistcontainerRemoveCallbacks(sp_playlistcontainer pc, sp_playlistcontainer_callbacks callbacks, Pointer userdata);
	int playlistcontainerNumPlaylists(sp_playlistcontainer pc);
	sp_playlist playlistcontainerPlaylist(sp_playlistcontainer pc, int index);
	int playlistcontainerPlaylistType(sp_playlistcontainer pc, int index);
	int playlistcontainerPlaylistFolderName(sp_playlistcontainer pc, int index, String buffer, int buffer_size);
	int playlistcontainerPlaylistFolderId(sp_playlistcontainer pc, int index);
	sp_playlist playlistcontainerAddNewPlaylist(sp_playlistcontainer pc, String name);
	sp_playlist playlistcontainerAddPlaylist(sp_playlistcontainer pc, sp_link link);
	int playlistcontainerRemovePlaylist(sp_playlistcontainer pc, int index);
	int playlistcontainerMovePlaylist(sp_playlistcontainer pc, int index, int new_position, boolean dry_run);
	int playlistcontainerAddFolder(sp_playlistcontainer pc, int index, String name);
	sp_user playlistcontainerOwner(sp_playlistcontainer pc);
	void playlistcontainerAddRef(sp_playlistcontainer pc);
	void playlistcontainerRelease(sp_playlistcontainer pc);
	
	// Toplist methods
	sp_toplistbrowse toplistbrowseCreate(sp_session session, int type, int region, String username, 
			ToplistbrowseComplete callback, Pointer userdata);
	boolean toplistbrowseIsLoaded(sp_toplistbrowse tlb);
	int toplistbrowseError(sp_toplistbrowse tlb);
	void toplistbrowseAddRef(sp_toplistbrowse tlb);
	void toplistbrowseRelease(sp_toplistbrowse tlb);
	int toplistbrowseNumArtists(sp_toplistbrowse tlb);
	sp_artist toplistbrowseArtist(sp_toplistbrowse tlb, int index);
	int toplistbrowseNumAlbums(sp_toplistbrowse tlb);
	sp_album toplistbrowseAlbum(sp_toplistbrowse tlb, int index);
	int toplistbrowseNumTracks(sp_toplistbrowse tlb);
	sp_track toplistbrowseTrack(sp_toplistbrowse tlb, int index);
	
	// User methods
	String userCanonicalName(sp_user user);
	String userDisplayName(sp_user user);
	boolean userIsLoaded(sp_user user);
	String userFullName(sp_user user);
	String userPicture(sp_user user);
	int userRelationType(sp_session session, sp_user user);
	void userAddReg(sp_user user);
	void userRelease(sp_user user);
	
	// Inbox methods
	sp_inbox inboxPostTracks(sp_session session, String user, sp_track[] tracks, int num_tracks, String message,
			InboxpostComplete callback, Pointer userdata);
	int inboxError(sp_inbox inbox);
	void inboxAddRef(sp_inbox inbox);
	void inboxRelease(sp_inbox inbox);
	
	// Link methods
	sp_link linkCreateFromString(String link);
	sp_link linkCreateFromTrack(sp_track track, int offset);
	sp_link linkCreateFromAlbum(sp_album album);
	sp_link linkCreateFromArtist(sp_artist artist);
	sp_link linkCreateFromSearch(sp_search search);
	sp_link linkCreateFromPlaylist(sp_playlist playlist);
	sp_link linkCreateFromUser(sp_user user);
	int linkAsString(sp_link link, String buffer, int buffer_size);
	int linkType(sp_link link);
	sp_track linkAsTrack(sp_link link);
	sp_album linkAsAlbum(sp_link link);
	sp_artist linkAsArtist(sp_link link);
	sp_user linkAsUser(sp_link link);
	void linkAddRef(sp_link link);
	void linkRelease(sp_link link);
	
	// Track methods
	boolean trackIsLoaded(sp_track track);
	int trackError(sp_track track);
	boolean trackIsAvailable(sp_session session, sp_track track);
	boolean trackIsLocal(sp_track track);
	boolean trackIsAutolinked(sp_session session, sp_track track);
	boolean trackIsStarred(sp_session session, sp_track track);
	void trackSetStarred(sp_session session, sp_track track);
	int trackNumArtists(sp_track track);
	sp_artist trackArtist(sp_track track, int index);
	sp_album trackAlbum(sp_track track);
	String trackName(sp_track track);
	int trackDuration(sp_track track);
	int trackPopularity(sp_track track);
	int trackDisc(sp_track track);
	int trackIndex(sp_track track);
	sp_track localtrackCreate(String artist, String title, String album, int length);
	void trackAddRef(sp_track track);
	void trackRelease(sp_track track);
	
	// Session methods
	int sessionCreate(sp_session_config config, PointerByReference sess);
	void sessionRelease(sp_session session);
	int sessionLogin(sp_session session, String username, String password);
	sp_user sp_session_user(sp_session session);
	void sp_session_logout(sp_session session);
	int sessionConnectionstate(sp_session session);
	Pointer sessionUserdata(sp_session session);
	void sessionSetCacheSize(sp_session session, int size);
	void sessionProcessEvents(sp_session session, IntByReference next_timeout);
	int sessionPlayerLoad(sp_session session, sp_track track);
	void sessionPlayerSeek(sp_session session, int offset);
	void sessionPlayerPlay(sp_session session, boolean play);
	void sessionPlayerUnload(sp_session session);
	int sessionPlayerPrefetch(sp_session session, sp_track track);
	sp_playlistcontainer sessionPublishedcontainerForUserCreate(sp_session session, String canonical_username);
	void sessionPreferredBitrate(sp_session session, int bitrate);
	int sessionNumFriends(sp_session session);
	sp_user sessionFriend(sp_session session, int index);
	
}