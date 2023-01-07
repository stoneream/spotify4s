package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model.{ErrorObject, ImageObject, PagingObject, PagingPlaylistObject, PlaylistObject}
import spotify4s.v1.request.{AddTracksToPlaylistRequest, ChangePlaylistDetailsRequest, CreatePlaylistRequest, FollowPlaylistRequest, RemoveTracksPlaylistRequest}
import spotify4s.v1.response.ReorderOrReplacePlaylistsTracks200Response
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

case class PlaylistsApi(baseUri: Uri = uri"https://api.spotify.com/v1") {

  /**
   * Add Items to Playlist
   * Add one or more items to a user's playlist.
   */
  def addTracksToPlaylist(playlistId: String, position: Option[Int] = None, uris: Option[String] = None, requestBody: Option[AddTracksToPlaylistRequest])(
      accessToken: String
  )(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], ReorderOrReplacePlaylistsTracks200Response] = {

    val queryParams = Map.empty[String, String] ++ position.map("position" -> _.toString) ++ uris.map("uris" -> _)

    val requestUrl = baseUri.addPath("/playlists/tracks").addPath(s"/$playlistId").addParams(queryParams)

    basicRequest
      .post(requestUrl)
      .body(requestBody)
      .response(asJsonEither[ErrorObject, ReorderOrReplacePlaylistsTracks200Response])
      .auth
      .bearer(accessToken)
      .send(client)
      .body
  }

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
   * Check if Users Follow Playlist
   * Check to see if one or more Spotify users are following a specified playlist.
   */
  def checkIfUserFollowsPlaylist(playlistId: String, ids: String)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/playlists/followers/contains").addPath(s"/$playlistId").addParams(queryParams)

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
   * Follow Playlist
   * Add the current user as a follower of a playlist.
   */
  def followPlaylist(playlistId: String, requestBody: Option[FollowPlaylistRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val requestUrl = baseUri.addPath("/playlists/followers").addPath(s"/$playlistId")

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Category's Playlists
   * Get a list of Spotify playlists tagged with a particular category.
   */
  def getACategoriesPlaylists(categoryId: String, country: Option[String] = None, limit: Option[Int] = None, offset: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingPlaylistObject] = {

    val queryParams =
      Map.empty[String, String] ++ country.map("country" -> _) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/browse/categories/playlists").addPath(s"/$categoryId").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingPlaylistObject]).auth.bearer(accessToken).send(client).body
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
   * Get Featured Playlists
   * Get a list of Spotify featured playlists (shown, for example, on a Spotify player's 'Browse' tab).
   */
  def getFeaturedPlaylists(
      country: Option[String] = None,
      locale: Option[String] = None,
      timestamp: Option[String] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None
  )(
      accessToken: String
  )(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], PagingPlaylistObject] = {

    val queryParams = Map.empty[String, String] ++ country.map("country" -> _) ++ locale.map("locale" -> _) ++ timestamp.map(
      "timestamp" -> _
    ) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/browse/featured-playlists").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingPlaylistObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get User's Playlists
   * Get a list of the playlists owned or followed by a Spotify user.
   */
  def getListUsersPlaylists(userId: String, limit: Option[Int] = None, offset: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingPlaylistObject] = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/users/playlists").addPath(s"/$userId").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingPlaylistObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Playlist
   * Get a playlist owned by a Spotify user.
   */
  def getPlaylist(playlistId: String, market: Option[String] = None, fields: Option[String] = None, additionalTypes: Option[String] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PlaylistObject] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) ++ fields.map("fields" -> _) ++ additionalTypes.map(
      "additionalTypes" -> _
    )

    val requestUrl = baseUri.addPath("/playlists").addPath(s"/$playlistId").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PlaylistObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Playlist Cover Image
   * Get the current image associated with a specific playlist.
   */
  def getPlaylistCover(
      playlistId: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[ImageObject]] = {

    val requestUrl = baseUri.addPath("/playlists/images").addPath(s"/$playlistId")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[ImageObject]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Playlist Items
   * Get full details of the items of a playlist owned by a Spotify user.
   */
  def getPlaylistsTracks(
      playlistId: String,
      market: Option[String] = None,
      fields: Option[String] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None,
      additionalTypes: Option[String] = None
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingObject] = {

    val queryParams =
      Map.empty[String, String] ++ market.map("market" -> _) ++ fields.map("fields" -> _) ++ limit.map("limit" -> _.toString) ++ offset.map(
        "offset" -> _.toString
      ) ++ additionalTypes.map("additionalTypes" -> _)

    val requestUrl = baseUri.addPath("/playlists/tracks").addPath(s"/$playlistId").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Remove Playlist Items
   * Remove one or more items from a user's playlist.
   */
  def removeTracksPlaylist(playlistId: String, removeTracksPlaylistRequest: Option[RemoveTracksPlaylistRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], ReorderOrReplacePlaylistsTracks200Response] = {

    val requestUrl = baseUri.addPath("/playlists/tracks").addPath(s"/$playlistId")

    basicRequest
      .delete(requestUrl)
      .body(removeTracksPlaylistRequest)
      .response(asJsonEither[ErrorObject, ReorderOrReplacePlaylistsTracks200Response])
      .auth
      .bearer(accessToken)
      .send(client)
      .body
  }

  /**
   * Update Playlist Items
   * Either reorder or replace items in a playlist depending on the request's parameters.
   * To reorder items, include `range_start`, `insert_before`, `range_length` and `snapshot_id` in the request's body. To replace items, include `uris` as either a query parameter or in the request's body.
   * Replacing items in a playlist will overwrite its existing items.
   * This operation can be used for replacing or clearing items in a playlist.
   * Note** Replace and reorder are mutually exclusive operations which share the same endpoint, but have different parameters. These operations can't be applied together in a single request.
   * todo fix
   *  def reorderOrReplacePlaylistsTracks(playlistId: String, uris: Option[String] = None, requestBody: Option[Map[String, oas_any_type_not_mapped]])(
   *      client: SttpBackend[Identity, Any]
   *  ) = {
   *
   *    val queryParams = Map.empty[String, String] ++ uris.map("uris" -> _.toString)
   *
   *    val requestUrl = baseUri.addPath("/playlists/tracks").addPath(s"/${playlistId}").addParams(queryParams)
   *
   *    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, ReorderOrReplacePlaylistsTracks200Response]).auth.bearer(accessToken).send(client).body
   *  }
   */

  /**
   * Unfollow Playlist
   * Remove the current user as a follower of a playlist.
   */
  def unfollowPlaylist(
      playlistId: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val requestUrl = baseUri.addPath("/playlists/followers").addPath(s"/$playlistId")

    basicRequest.delete(requestUrl).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Add Custom Playlist Cover Image
   * Replace the image used to represent a specific playlist.
   */
  def uploadCustomPlaylistCover(
      playlistId: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val requestUrl = baseUri.addPath("/playlists/images").addPath(s"/$playlistId")

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

}
