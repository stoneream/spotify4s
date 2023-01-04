package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.circe.Derivation._
import spotify4s.v1.model.{AlbumObject, ErrorObject, PagingObject}
import spotify4s.v1.request.{RemoveAlbumsUserRequest, SaveAlbumsUserRequest}
import spotify4s.v1.response.{GetMultipleAlbums200Response, GetNewReleases200Response}
import sttp.client3._
import sttp.client3.circe._

object AlbumsApi {

  private val baseUri = uri"https://api.spotify.com/v1"

  /**
   * Check User's Saved Albums
   * Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.
   */
  def checkUsersSavedAlbums(ids: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/albums/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).send(client).body
  }

  /**
   * Get Album
   * Get Spotify catalog information for a single album.
   */
  def getAnAlbum(id: String, market: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], AlbumObject] = {
    val queryParams = Map.empty[String, String] ++ market.map("market" -> _.toString)

    val requestUrl = baseUri.addPath("/albums").addPath(s"/${id}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, AlbumObject]).send(client).body
  }

  /**
   * Get Album Tracks
   * Get Spotify catalog information about an album’s tracks. Optional parameters can be used to limit the number of tracks returned.
   */
  def getAnAlbumsTracks(id: String, market: Option[String], limit: Option[Int], offset: Option[Int])(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], PagingObject] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/albums/tracks").addPath(s"/${id}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Get Artist's Albums
   * Get Spotify catalog information about an artist's albums.
   */
  def getAnArtistsAlbums(id: String, includeGroups: Option[String], market: Option[String], limit: Option[Int], offset: Option[Int])(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], PagingObject] = {

    val queryParams = Map.empty[String, String] ++ includeGroups.map("includeGroups" -> _.toString) ++ market.map("market" -> _.toString) ++ limit.map(
      "limit" -> _.toString
    ) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/artists/albums").addPath(s"/${id}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Get Several Albums
   * Get Spotify catalog information for multiple albums identified by their Spotify IDs.
   */
  def getMultipleAlbums(ids: String, market: Option[String])(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], GetMultipleAlbums200Response] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString) ++ market.map("market" -> _.toString)

    val requestUrl = baseUri.addPath("/albums").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetMultipleAlbums200Response]).send(client).body
  }

  /**
   * Get New Releases
   * Get a list of new album releases featured in Spotify (shown, for example, on a Spotify player’s “Browse” tab).
   */
  def getNewReleases(country: Option[String], limit: Option[Int], offset: Option[Int])(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], GetNewReleases200Response] = {

    val queryParams =
      Map.empty[String, String] ++ country.map("country" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/browse/new-releases").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetNewReleases200Response]).send(client).body
  }

  /**
   * Get User's Saved Albums
   * Get a list of the albums saved in the current Spotify user's 'Your Music' library.
   */
  def getUsersSavedAlbums(limit: Option[Int], offset: Option[Int], market: Option[String])(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], PagingObject] = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString) ++ market.map("market" -> _.toString)

    val requestUrl = baseUri.addPath("/me/albums").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Remove Users' Saved Albums
   * Remove one or more albums from the current user's 'Your Music' library.
   */
  def removeAlbumsUser(ids: String, requestBody: Option[RemoveAlbumsUserRequest])(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/albums").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Save Albums for Current User
   * Save one or more albums to the current user's 'Your Music' library.
   */
  def saveAlbumsUser(ids: String, requestBody: Option[SaveAlbumsUserRequest])(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/albums").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

}
