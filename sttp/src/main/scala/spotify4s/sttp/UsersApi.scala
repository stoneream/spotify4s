package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model._
import spotify4s.v1.request.{FollowArtistsUsersRequest, FollowPlaylistRequest, UnfollowArtistsUsersRequest}
import spotify4s.v1.response.GetFollowed200Response
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

case class UsersApi(baseUri: Uri = uri"https://api.spotify.com/v1") {

  /**
   * Check If User Follows Artists or Users
   * Check to see if the current user is following one or more artists or other Spotify users.
   */
  def checkCurrentUserFollows(`type`: String, ids: String)(accessToken: String)(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`) + ("ids" -> ids)

    val requestUrl = baseUri.addPath("me/following/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Check if Users Follow Playlist
   * Check to see if one or more Spotify users are following a specified playlist.
   */
  def checkIfUserFollowsPlaylist(playlistId: String, ids: String)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("playlists/followers/contains").addPath(s"/$playlistId").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Follow Artists or Users
   * Add the current user as a follower of one or more artists or other Spotify users.
   */
  def followArtistsUsers(`type`: String, ids: String, requestBody: Option[FollowArtistsUsersRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`) + ("ids" -> ids)

    val requestUrl = baseUri.addPath("me/following").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Follow Playlist
   * Add the current user as a follower of a playlist.
   */
  def followPlaylist(playlistId: String, requestBody: Option[FollowPlaylistRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val requestUrl = baseUri.addPath("playlists/followers").addPath(s"/$playlistId")

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Current User's Profile
   * Get detailed profile information about the current user (including the current user's username).
   */
  def getCurrentUsersProfile()(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PrivateUserObject] = {

    val requestUrl = baseUri.addPath("me")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PrivateUserObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Followed Artists
   * Get the current user's followed artists.
   */
  def getFollowed(`type`: String, after: Option[String] = None, limit: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], GetFollowed200Response] = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`) ++ after.map("after" -> _) ++ limit.map("limit" -> _.toString)

    val requestUrl = baseUri.addPath("me/following").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetFollowed200Response]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get User's Playlists
   * Get a list of the playlists owned or followed by a Spotify user.
   */
  def getListUsersPlaylists(userId: String, limit: Option[Int] = None, offset: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingPlaylistObject] = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("users/playlists").addPath(s"/$userId").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingPlaylistObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get User's Profile
   * Get public profile information about a Spotify user.
   */
  def getUsersProfile(
      userId: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PublicUserObject] = {

    val requestUrl = baseUri.addPath("users").addPath(s"/$userId")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PublicUserObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Unfollow Artists or Users
   * Remove the current user as a follower of one or more artists or other Spotify users.
   */
  def unfollowArtistsUsers(`type`: String, ids: String, requestBody: Option[UnfollowArtistsUsersRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`) + ("ids" -> ids)

    val requestUrl = baseUri.addPath("me/following").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Unfollow Playlist
   * Remove the current user as a follower of a playlist.
   */
  def unfollowPlaylist(
      playlistId: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val requestUrl = baseUri.addPath("playlists/followers").addPath(s"/$playlistId")

    basicRequest.delete(requestUrl).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

}
