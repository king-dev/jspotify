package com.nbarraille.jspotify.main;

import java.lang.reflect.Method;
import java.util.Locale;

import com.sun.jna.NativeLibrary;

/**
 * This is an implementation of FunctionMapper adapted for libspotify 0.0.7.
 * This takes care of the methods name conversion.
 * @author nbarraille
 *
 */
import com.sun.jna.win32.StdCallFunctionMapper;

public class SpotifyFunctionMapper extends StdCallFunctionMapper{

	/**
	 * Maps Java methods name to C++ methods name.
	 * @param library the NativeLibrary in which are the C++ methods.
	 * @param method the Java method.
	 * @return the name of the C++ method to call.
	 */
	public String getFunctionName(NativeLibrary library, Method method) {
		String suffix;
		if(method.getName().equals("albumbrowseCopyright") ||
		   method.getName().equals("albumbrowseTrack") ||
		   method.getName().equals("artistbrowseAlbum") ||
		   method.getName().equals("artistbrowsePortrait") ||
		   method.getName().equals("artistbrowseSimilarArtist") ||
		   method.getName().equals("artistbrowseTrack") ||
		   method.getName().equals("imageCreate") ||
		   method.getName().equals("imageData") ||
		   method.getName().equals("linkAsTrackAndOffset") ||
		   method.getName().equals("linkCreateFromTrack") ||
		   method.getName().equals("playlistCreate") ||
		   method.getName().equals("playlistGetImage") ||
		   method.getName().equals("playlistIsInRam") ||
		   method.getName().equals("playlistRename") ||
		   method.getName().equals("playlistSetCollaborative") ||
		   method.getName().equals("playlistTrack") ||
		   method.getName().equals("playlistTrackCreateTime") ||
		   method.getName().equals("playlistTrackCreator") ||
		   method.getName().equals("playlistTrackMessage") ||
		   method.getName().equals("playlistTrackSeen") ||
		   method.getName().equals("playlistUpdateSubscribers") ||
		   method.getName().equals("playlistcontainerAddNewPlaylist") ||
		   method.getName().equals("playlistcontainerAddPlaylist") ||
		   method.getName().equals("playlistcontainerPlaylist") ||
		   method.getName().equals("playlistcontainerPlaylistFolderId") ||
		   method.getName().equals("playlistcontainerPlaylistType") ||
		   method.getName().equals("playlistcontainerRemovePlaylist") ||
		   method.getName().equals("searchAlbum") ||
		   method.getName().equals("searchArtist") ||
		   method.getName().equals("searchTrack") ||
		   method.getName().equals("sessionCreate") ||
		   method.getName().equals("sessionFriend") ||
		   method.getName().equals("sessionPlayerLoad") ||
		   method.getName().equals("sessionPlayerPlay") ||
		   method.getName().equals("sessionPlayerPrefetch") ||
		   method.getName().equals("sessionPlayerSeek") ||
		   method.getName().equals("sessionPreferredBitrate") ||
		   method.getName().equals("sessionProcessEvents") ||
		   method.getName().equals("sessionPublishedcontainerForUserCreate") ||
		   method.getName().equals("sessionSetCacheSize") ||
		   method.getName().equals("sessionStarredForUserCreate") ||
		   method.getName().equals("toplistbrowseAlbum") ||
		   method.getName().equals("toplistbrowseArtist") ||
		   method.getName().equals("toplistbrowseTrack") ||
		   method.getName().equals("trackArtist") ||
		   method.getName().equals("trackIsAutolinked") ||
		   method.getName().equals("trackIsAvailable") ||
		   method.getName().equals("trackIsLocal") ||
		   method.getName().equals("trackIsStarred") ||
		   method.getName().equals("userRelationType"))
		   	suffix = "8";
		else if(method.getName().equals("albumbrowseCreate") ||
				method.getName().equals("artistbrowseCreate") ||
				method.getName().equals("localtrackCreate") ||
				method.getName().equals("playlistReorderTracks") ||
				method.getName().equals("playlistcontainerMovePlaylist") ||
				method.getName().equals("playlistcontainerPlaylistFolderName") ||
				method.getName().equals("trackSetStarred"))
			suffix = "16";
		else if(method.getName().equals("imageAddLoadCallback") ||
				method.getName().equals("imageRemoveLoadCallback") ||
				method.getName().equals("linkAsString") ||
				method.getName().equals("playlistAddCallbacks") ||
				method.getName().equals("playlistRemoveCallbacks") ||
				method.getName().equals("playlistRemoveTracks") ||
				method.getName().equals("playlistSetInRam") ||
				method.getName().equals("playlistTrackSetSeen") ||
				method.getName().equals("playlistcontainerAddCallbacks") ||
				method.getName().equals("playlistcontainerAddFolder") ||
				method.getName().equals("playlistcontainerRemoveCallbacks") ||
				method.getName().equals("sessionLogin"))
			suffix = "12";
		else if(method.getName().equals("inboxPostTracks"))
			suffix = "28";
		else if(method.getName().equals("playlistAddTracks"))
			suffix = "20";
		else if(method.getName().equals("radioSearchCreate") ||
				method.getName().equals("toplistbrowseCreate"))
			suffix = "24";
		else if(method.getName().equals("searchCreate"))
			suffix = "40";
		else{
			suffix = "4";
		}
		
		return "_sp_" + SpotifyFunctionMapper.underscore(method.getName()) + "@" + suffix;
	}
	
	/**
	 * Replaces all the upper case letters by underscore + lower case
	 * @param s the string to modify.
	 * @return the modified string
	 */
	public static String underscore(String s){
		// Adding underscore
		String res = s.replaceAll("(.)([A-Z])", "$1_$2");
		// Replacing upper cases by to lower cases
		res = res.toLowerCase(Locale.ENGLISH);
		return res;
	}

}
