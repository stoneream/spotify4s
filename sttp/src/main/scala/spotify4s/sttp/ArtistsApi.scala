package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model.{ArtistObject, ErrorObject, PagingObject, SimplifiedAlbumObject}
import spotify4s.v1.request.{FollowArtistsUsersRequest, UnfollowArtistsUsersRequest}
import spotify4s.v1.response.{GetAnArtistsTopTracks200Response, GetFollowed200Response, GetMultipleArtists200Response}
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

case class ArtistsApi(baseUri: Uri = uri"https://api.spotify.com/v1") {

  /**
   * Check If User Follows Artists or Users
   * Check to see if the current user is following one or more artists or other Spotify users.
   */
  def checkCurrentUserFollows(`type`: String, ids: String)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`) + ("ids" -> ids)

    val requestUrl = baseUri.addPath("me", "following", "contains").addParams(queryParams)

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

    val requestUrl = baseUri.addPath("me", "following").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Artist
   * Get Spotify catalog information for a single artist identified by their unique Spotify ID.
   */
  def getAnArtist(id: String)(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], ArtistObject] = {

    val requestUrl = baseUri.addPath("artists", s"$id")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, ArtistObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Artist's Albums
   * Get Spotify catalog information about an artist's albums.
   */
  def getAnArtistsAlbums(
      id: String,
      includeGroups: Option[String] = None,
      market: Option[String] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None
  )(accessToken: String)(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], PagingObject[SimplifiedAlbumObject]] = {

    val queryParams = Map.empty[String, String] ++ includeGroups.map("includeGroups" -> _) ++ market.map("market" -> _) ++ limit.map(
      "limit" -> _.toString
    ) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("artists", s"$id", "albums").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject[SimplifiedAlbumObject]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Followed Artists
   * Get the current user's followed artists.
   */
  def getFollowed(`type`: String, after: Option[String] = None, limit: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], GetFollowed200Response] = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`) ++ after.map("after" -> _) ++ limit.map("limit" -> _.toString)

    val requestUrl = baseUri.addPath("me", "following").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetFollowed200Response]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Several Artists
   * Get Spotify catalog information for several artists based on their Spotify IDs.
   */
  def getMultipleArtists(
      ids: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], GetMultipleArtists200Response] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("artists").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetMultipleArtists200Response]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Unfollow Artists or Users
   * Remove the current user as a follower of one or more artists or other Spotify users.
   */
  def unfollowArtistsUsers(`type`: String, ids: String, requestBody: Option[UnfollowArtistsUsersRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("type" -> `type`) + ("ids" -> ids)

    val requestUrl = baseUri.addPath("me", "following").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

}
