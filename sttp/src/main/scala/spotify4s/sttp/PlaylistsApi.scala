package spotify4s.sttp

import io.circe.generic.extras.auto._
import spotify4s.v1.model.{ErrorObject, ImageObject, PagingObject, PagingPlaylistObject, PlaylistObject}
import spotify4s.v1.request.{AddTracksToPlaylistRequest, ChangePlaylistDetailsRequest, CreatePlaylistRequest, FollowPlaylistRequest, RemoveTracksPlaylistRequest}
import spotify4s.v1.response.ReorderOrReplacePlaylistsTracks200Response
import sttp.client3._
import sttp.client3.circe._

object PlaylistsApi {

  private val baseUri = uri"https://api.spotify.com/v1"

  /**
   * Add Items to Playlist
   * Add one or more items to a user's playlist.
   */
  def addTracksToPlaylist(playlistId: String, position: Option[Int], uris: Option[String], requestBody: Option[AddTracksToPlaylistRequest])(
      client: SttpBackend[Identity, Any]
  ) = {

    val queryParams = Map.empty[String, String] ++ position.map("position" -> _.toString) ++ uris.map("uris" -> _.toString)

    val requestUrl = baseUri.addPath("/playlists/tracks").addPath(s"/${playlistId}").addParams(queryParams)

    basicRequest.post(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, ReorderOrReplacePlaylistsTracks200Response]).send(client).body
  }

  /**
   * Change Playlist Details
   * Change a playlist's name and public/private state. (The user must, of course, own the playlist.)
   */
  def changePlaylistDetails(playlistId: String, requestBody: Option[ChangePlaylistDetailsRequest])(client: SttpBackend[Identity, Any]) = {

    val requestUrl = baseUri.addPath("/playlists").addPath(s"/${playlistId}")

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Check if Users Follow Playlist
   * Check to see if one or more Spotify users are following a specified playlist.
   */
  def checkIfUserFollowsPlaylist(playlistId: String, ids: String)(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/playlists/followers/contains").addPath(s"/${playlistId}").addParams(queryParams)

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
   * Follow Playlist
   * Add the current user as a follower of a playlist.
   */
  def followPlaylist(playlistId: String, requestBody: Option[FollowPlaylistRequest])(client: SttpBackend[Identity, Any]) = {

    val requestUrl = baseUri.addPath("/playlists/followers").addPath(s"/${playlistId}")

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Get Category's Playlists
   * Get a list of Spotify playlists tagged with a particular category.
   */
  def getACategoriesPlaylists(categoryId: String, country: Option[String], limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams =
      Map.empty[String, String] ++ country.map("country" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/browse/categories/playlists").addPath(s"/${categoryId}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingPlaylistObject]).send(client).body
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
   * Get Featured Playlists
   * Get a list of Spotify featured playlists (shown, for example, on a Spotify player's 'Browse' tab).
   */
  def getFeaturedPlaylists(country: Option[String], locale: Option[String], timestamp: Option[String], limit: Option[Int], offset: Option[Int])(
      client: SttpBackend[Identity, Any]
  ) = {

    val queryParams = Map.empty[String, String] ++ country.map("country" -> _.toString) ++ locale.map("locale" -> _.toString) ++ timestamp.map(
      "timestamp" -> _.toString
    ) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/browse/featured-playlists").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingPlaylistObject]).send(client).body
  }

  /**
   * Get User's Playlists
   * Get a list of the playlists owned or followed by a Spotify user.
   */
  def getListUsersPlaylists(userId: String, limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/users/playlists").addPath(s"/${userId}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingPlaylistObject]).send(client).body
  }

  /**
   * Get Playlist
   * Get a playlist owned by a Spotify user.
   */
  def getPlaylist(playlistId: String, market: Option[String], fields: Option[String], additionalTypes: Option[String])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _.toString) ++ fields.map("fields" -> _.toString) ++ additionalTypes.map(
      "additionalTypes" -> _.toString
    )

    val requestUrl = baseUri.addPath("/playlists").addPath(s"/${playlistId}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PlaylistObject]).send(client).body
  }

  /**
   * Get Playlist Cover Image
   * Get the current image associated with a specific playlist.
   */
  def getPlaylistCover(playlistId: String)(client: SttpBackend[Identity, Any]) = {

    val requestUrl = baseUri.addPath("/playlists/images").addPath(s"/${playlistId}")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[ImageObject]]).send(client).body
  }

  /**
   * Get Playlist Items
   * Get full details of the items of a playlist owned by a Spotify user.
   */
  def getPlaylistsTracks(
      playlistId: String,
      market: Option[String],
      fields: Option[String],
      limit: Option[Int],
      offset: Option[Int],
      additionalTypes: Option[String]
  )(client: SttpBackend[Identity, Any]) = {

    val queryParams =
      Map.empty[String, String] ++ market.map("market" -> _.toString) ++ fields.map("fields" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map(
        "offset" -> _.toString
      ) ++ additionalTypes.map("additionalTypes" -> _.toString)

    val requestUrl = baseUri.addPath("/playlists/tracks").addPath(s"/${playlistId}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Remove Playlist Items
   * Remove one or more items from a user's playlist.
   */
  def removeTracksPlaylist(playlistId: String, removeTracksPlaylistRequest: Option[RemoveTracksPlaylistRequest])(client: SttpBackend[Identity, Any]) = {

    val requestUrl = baseUri.addPath("/playlists/tracks").addPath(s"/${playlistId}")

    basicRequest
      .delete(requestUrl)
      .body(removeTracksPlaylistRequest)
      .response(asJsonEither[ErrorObject, ReorderOrReplacePlaylistsTracks200Response])
      .send(client).body
  }

  /**
   * Update Playlist Items
   * Either reorder or replace items in a playlist depending on the request's parameters.
   * To reorder items, include `range_start`, `insert_before`, `range_length` and `snapshot_id` in the request's body. To replace items, include `uris` as either a query parameter or in the request's body.
   * Replacing items in a playlist will overwrite its existing items.
   * This operation can be used for replacing or clearing items in a playlist.
   * Note** Replace and reorder are mutually exclusive operations which share the same endpoint, but have different parameters. These operations can't be applied together in a single request.
   * todo fix
   *  def reorderOrReplacePlaylistsTracks(playlistId: String, uris: Option[String], requestBody: Option[Map[String, oas_any_type_not_mapped]])(
   *      client: SttpBackend[Identity, Any]
   *  ) = {
   *
   *    val queryParams = Map.empty[String, String] ++ uris.map("uris" -> _.toString)
   *
   *    val requestUrl = baseUri.addPath("/playlists/tracks").addPath(s"/${playlistId}").addParams(queryParams)
   *
   *    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, ReorderOrReplacePlaylistsTracks200Response]).send(client).body
   *  }
   */

  /**
   * Unfollow Playlist
   * Remove the current user as a follower of a playlist.
   */
  def unfollowPlaylist(playlistId: String)(client: SttpBackend[Identity, Any]) = {

    val requestUrl = baseUri.addPath("/playlists/followers").addPath(s"/${playlistId}")

    basicRequest.delete(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Add Custom Playlist Cover Image
   * Replace the image used to represent a specific playlist.
   */
  def uploadCustomPlaylistCover(playlistId: String)(client: SttpBackend[Identity, Any]) = {

    val requestUrl = baseUri.addPath("/playlists/images").addPath(s"/${playlistId}")

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

}
