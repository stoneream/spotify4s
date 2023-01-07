package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model.{ErrorObject, PagingObject, PagingPlaylistObject, PlaylistObject, SavedAlbumObject, SavedEpisodeObject, SavedShowObject, SavedTrackObject}
import spotify4s.v1.request._
import spotify4s.v1.response.GetFollowed200Response
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

case class LibraryApi(baseUri: Uri = uri"https://api.spotify.com/v1") {

  /**
   * Change Playlist Details
   * Change a playlist's name and public/private state. (The user must, of course, own the playlist.)
   */
  def changePlaylistDetails(playlistId: String, requestBody: Option[ChangePlaylistDetailsRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val requestUrl = baseUri.addPath("/playlists").addPath(s"/$playlistId")

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Check If User Follows Artists or Users
   * Check to see if the current user is following one or more artists or other Spotify users.
   */
  def checkCurrentUserFollows(`type`: String, ids: String)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`) + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/following/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Check User's Saved Albums
   * Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.
   */
  def checkUsersSavedAlbums(
      ids: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/albums/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Check User's Saved Audiobooks
   * Check if one or more audiobooks are already saved in the current Spotify user's library.
   */
  def checkUsersSavedAudiobooks(
      ids: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/audiobooks/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Check User's Saved Episodes
   * Check if one or more episodes is already saved in the current Spotify user's 'Your Episodes' library.<br> This API endpoint is in __beta__ and could change without warning. Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer)..
   */
  def checkUsersSavedEpisodes(
      ids: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/episodes/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Check User's Saved Shows
   * Check if one or more shows is already saved in the current Spotify user's library.
   */
  def checkUsersSavedShows(
      ids: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/shows/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Check User's Saved Tracks
   * Check if one or more tracks is already saved in the current Spotify user's 'Your Music' library.
   */
  def checkUsersSavedTracks(
      ids: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/tracks/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Create Playlist
   * Create a playlist for a Spotify user. (The playlist will be empty until you [add tracks](/documentation/web-api/reference/#/operations/add-tracks-to-playlist).)
   */
  def createPlaylist(userId: String, requestBody: Option[CreatePlaylistRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PlaylistObject] = {

    val requestUrl = baseUri.addPath("/users/playlists").addPath(s"/$userId")

    basicRequest.post(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, PlaylistObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Follow Artists or Users
   * Add the current user as a follower of one or more artists or other Spotify users.
   */
  def followArtistsUsers(`type`: String, ids: String, requestBody: Option[FollowArtistsUsersRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`) + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/following").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Current User's Playlists
   * Get a list of the playlists owned or followed by the current Spotify user.
   */
  def getAListOfCurrentUsersPlaylists(limit: Option[Int] = None, offset: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingPlaylistObject] = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/playlists").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingPlaylistObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Followed Artists
   * Get the current user's followed artists.
   */
  def getFollowed(`type`: String, after: Option[String] = None, limit: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], GetFollowed200Response] = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`) ++ after.map("after" -> _) ++ limit.map("limit" -> _.toString)

    val requestUrl = baseUri.addPath("/me/following").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetFollowed200Response]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get User's Saved Albums
   * Get a list of the albums saved in the current Spotify user's 'Your Music' library.
   */
  def getUsersSavedAlbums(limit: Option[Int] = None, offset: Option[Int] = None, market: Option[String] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingObject[SavedAlbumObject]] = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString) ++ market.map("market" -> _)

    val requestUrl = baseUri.addPath("/me/albums").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject[SavedAlbumObject]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get User's Saved Episodes
   * Get a list of the episodes saved in the current Spotify user's library.
   * This API endpoint is in __beta__ and could change without warning.
   * Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer).
   */
  def getUsersSavedEpisodes(market: Option[String] = None, limit: Option[Int] = None, offset: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingObject[SavedEpisodeObject]] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/episodes").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject[SavedEpisodeObject]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get User's Saved Shows
   * Get a list of shows saved in the current Spotify user's library. Optional parameters can be used to limit the number of shows returned.
   */
  def getUsersSavedShows(limit: Option[Int] = None, offset: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingObject[SavedShowObject]] = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/shows").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject[SavedShowObject]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get User's Saved Tracks
   * Get a list of the songs saved in the current Spotify user's 'Your Music' library.
   */
  def getUsersSavedTracks(market: Option[String] = None, limit: Option[Int] = None, offset: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingObject[SavedTrackObject]] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/tracks").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject[SavedTrackObject]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Remove Users' Saved Albums
   * Remove one or more albums from the current user's 'Your Music' library.
   */
  def removeAlbumsUser(ids: String, requestBody: Option[RemoveAlbumsUserRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/albums").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Remove User's Saved Audiobooks
   * Remove one or more audiobooks from the Spotify user's library.
   */
  def removeAudiobooksUser(ids: String)(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/audiobooks").addParams(queryParams)

    basicRequest.delete(requestUrl).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Remove User's Saved Episodes
   * Remove one or more episodes from the current user's library.<br> This API endpoint is in __beta__ and could change without warning. Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer).
   */
  def removeEpisodesUser(ids: String, requestBody: Option[RemoveEpisodesUserRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/episodes").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Remove User's Saved Shows
   * Delete one or more shows from current Spotify user's library.
   */
  def removeShowsUser(ids: String, market: Option[String] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids) ++ market.map("market" -> _)

    val requestUrl = baseUri.addPath("/me/shows").addParams(queryParams)

    basicRequest.delete(requestUrl).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Remove User's Saved Tracks
   * Remove one or more tracks from the current user's 'Your Music' library.
   */
  def removeTracksUser(ids: String, requestBody: Option[RemoveTracksUserRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/tracks").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Save Albums for Current User
   * Save one or more albums to the current user's 'Your Music' library.
   */
  def saveAlbumsUser(ids: String, requestBody: Option[RemoveAlbumsUserRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/albums").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Save Audiobooks for Current User
   * Save one or more audiobooks to the current Spotify user's library.
   */
  def saveAudiobooksUser(ids: String)(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/audiobooks").addParams(queryParams)

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Save Episodes for Current User
   * Save one or more episodes to the current user's library.
   * This API endpoint is in __beta__ and could change without warning. Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer).
   */
  def saveEpisodesUser(ids: String, requestBody: Option[SaveEpisodesUserRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/episodes").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Save Shows for Current User
   * Save one or more shows to current Spotify user's library.
   */
  def saveShowsUser(ids: String)(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/shows").addParams(queryParams)

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Save Tracks for Current User
   * Save one or more tracks to the current user's 'Your Music' library.
   */
  def saveTracksUser(ids: String, requestBody: Option[SaveTracksUserRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/tracks").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Unfollow Artists or Users
   * Remove the current user as a follower of one or more artists or other Spotify users.
   */
  def unfollowArtistsUsers(`type`: String, ids: String, requestBody: Option[UnfollowArtistsUsersRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`) + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/following").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

}
