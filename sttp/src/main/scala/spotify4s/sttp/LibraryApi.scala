package spotify4s.sttp

import io.circe.generic.extras.Configuration
import io.circe.generic.extras.auto._
import spotify4s.v1.model.{ErrorObject, PagingObject, PagingPlaylistObject, PlaylistObject}
import spotify4s.v1.request._
import spotify4s.v1.response.GetFollowed200Response
import sttp.client3._
import sttp.client3.circe._

object LibraryApi {

  private implicit val jsonConfig: Configuration = Configuration.default.withSnakeCaseMemberNames

  private val baseUri = uri"https://api.spotify.com/v1"

  /**
   * Change Playlist Details
   * Change a playlist's name and public/private state. (The user must, of course, own the playlist.)
   */
  def changePlaylistDetails(playlistId: String, requestBody: Option[ChangePlaylistDetailsRequest])(client: SttpBackend[Identity, Any]) = {

    val requestUrl = baseUri.addPath("/playlists").addPath(s"/${playlistId}")

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Check If User Follows Artists or Users
   * Check to see if the current user is following one or more artists or other Spotify users.
   */
  def checkCurrentUserFollows(`type`: String, ids: String)(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`.toString) + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/following/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).send(client).body
  }

  /**
   * Check User's Saved Albums
   * Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.
   */
  def checkUsersSavedAlbums(ids: String)(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/albums/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).send(client).body
  }

  /**
   * Check User's Saved Audiobooks
   * Check if one or more audiobooks are already saved in the current Spotify user's library.
   */
  def checkUsersSavedAudiobooks(ids: String)(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/audiobooks/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).send(client).body
  }

  /**
   * Check User's Saved Episodes
   * Check if one or more episodes is already saved in the current Spotify user's 'Your Episodes' library.<br> This API endpoint is in __beta__ and could change without warning. Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer)..
   */
  def checkUsersSavedEpisodes(ids: String)(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/episodes/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).send(client).body
  }

  /**
   * Check User's Saved Shows
   * Check if one or more shows is already saved in the current Spotify user's library.
   */
  def checkUsersSavedShows(ids: String)(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/shows/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).send(client).body
  }

  /**
   * Check User's Saved Tracks
   * Check if one or more tracks is already saved in the current Spotify user's 'Your Music' library.
   */
  def checkUsersSavedTracks(ids: String)(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/tracks/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).send(client).body
  }

  /**
   * Create Playlist
   * Create a playlist for a Spotify user. (The playlist will be empty until you [add tracks](/documentation/web-api/reference/#/operations/add-tracks-to-playlist).)
   */
  def createPlaylist(userId: String, requestBody: Option[CreatePlaylistRequest])(client: SttpBackend[Identity, Any]) = {

    val requestUrl = baseUri.addPath("/users/playlists").addPath(s"/${userId}")

    basicRequest.post(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, PlaylistObject]).send(client).body
  }

  /**
   * Follow Artists or Users
   * Add the current user as a follower of one or more artists or other Spotify users.
   */
  def followArtistsUsers(`type`: String, ids: String, requestBody: Option[FollowArtistsUsersRequest])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`.toString) + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/following").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Get Current User's Playlists
   * Get a list of the playlists owned or followed by the current Spotify user.
   */
  def getAListOfCurrentUsersPlaylists(limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/playlists").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingPlaylistObject]).send(client).body
  }

  /**
   * Get Followed Artists
   * Get the current user's followed artists.
   */
  def getFollowed(`type`: String, after: Option[String], limit: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`.toString) ++ after.map("after" -> _.toString) ++ limit.map("limit" -> _.toString)

    val requestUrl = baseUri.addPath("/me/following").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetFollowed200Response]).send(client).body
  }

  /**
   * Get User's Saved Albums
   * Get a list of the albums saved in the current Spotify user's 'Your Music' library.
   */
  def getUsersSavedAlbums(limit: Option[Int], offset: Option[Int], market: Option[String])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString) ++ market.map("market" -> _.toString)

    val requestUrl = baseUri.addPath("/me/albums").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Get User's Saved Audiobooks
   * Get a list of the audiobooks saved in the current Spotify user's 'Your Music' library.
   */
  def getUsersSavedAudiobooks(limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/audiobooks").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Get User's Saved Episodes
   * Get a list of the episodes saved in the current Spotify user's library.
   * This API endpoint is in __beta__ and could change without warning.
   * Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer).
   */
  def getUsersSavedEpisodes(market: Option[String], limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/episodes").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Get User's Saved Shows
   * Get a list of shows saved in the current Spotify user's library. Optional parameters can be used to limit the number of shows returned.
   */
  def getUsersSavedShows(limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/shows").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Get User's Saved Tracks
   * Get a list of the songs saved in the current Spotify user's 'Your Music' library.
   */
  def getUsersSavedTracks(market: Option[String], limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/tracks").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Get User's Top Items
   * Get the current user's top artists or tracks based on calculated affinity.
   */
  def getUsersTopArtistsAndTracks(`type`: String, timeRange: Option[String], limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams =
      Map.empty[String, String] ++ timeRange.map("timeRange" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/top").addPath(s"/${`type`}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Remove Users' Saved Albums
   * Remove one or more albums from the current user's 'Your Music' library.
   */
  def removeAlbumsUser(ids: String, requestBody: Option[RemoveAlbumsUserRequest])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/albums").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Remove User's Saved Audiobooks
   * Remove one or more audiobooks from the Spotify user's library.
   */
  def removeAudiobooksUser(ids: String)(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/audiobooks").addParams(queryParams)

    basicRequest.delete(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Remove User's Saved Episodes
   * Remove one or more episodes from the current user's library.<br> This API endpoint is in __beta__ and could change without warning. Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer).
   */
  def removeEpisodesUser(ids: String, requestBody: Option[RemoveEpisodesUserRequest])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/episodes").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Remove User's Saved Shows
   * Delete one or more shows from current Spotify user's library.
   */
  def removeShowsUser(ids: String, market: Option[String])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString) ++ market.map("market" -> _.toString)

    val requestUrl = baseUri.addPath("/me/shows").addParams(queryParams)

    basicRequest.delete(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Remove User's Saved Tracks
   * Remove one or more tracks from the current user's 'Your Music' library.
   */
  def removeTracksUser(ids: String, requestBody: Option[RemoveTracksUserRequest])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/tracks").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Save Albums for Current User
   * Save one or more albums to the current user's 'Your Music' library.
   */
  def saveAlbumsUser(ids: String, requestBody: Option[RemoveAlbumsUserRequest])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/albums").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Save Audiobooks for Current User
   * Save one or more audiobooks to the current Spotify user's library.
   */
  def saveAudiobooksUser(ids: String)(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/audiobooks").addParams(queryParams)

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Save Episodes for Current User
   * Save one or more episodes to the current user's library.
   * This API endpoint is in __beta__ and could change without warning. Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer).
   */
  def saveEpisodesUser(ids: String, requestBody: Option[SaveEpisodesUserRequest])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/episodes").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Save Shows for Current User
   * Save one or more shows to current Spotify user's library.
   */
  def saveShowsUser(ids: String)(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/shows").addParams(queryParams)

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Save Tracks for Current User
   * Save one or more tracks to the current user's 'Your Music' library.
   */
  def saveTracksUser(ids: String, requestBody: Option[SaveTracksUserRequest])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/tracks").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Unfollow Artists or Users
   * Remove the current user as a follower of one or more artists or other Spotify users.
   */
  def unfollowArtistsUsers(`type`: String, ids: String, requestBody: Option[UnfollowArtistsUsersRequest])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`.toString) + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/following").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

}
