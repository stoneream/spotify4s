package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model.{ErrorObject, PagingObject, ShowObject}
import spotify4s.v1.response.GetMultipleShows200Response
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

object ShowsApi {
  private val baseUri: Uri = uri"https://api.spotify.com/v1"

  /**
   * Check User's Saved Shows
   * Check if one or more shows is already saved in the current Spotify user's library.
   */
  def checkUsersSavedShows(ids: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/shows/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).send(client).body
  }

  /**
   * Get Show
   * Get Spotify catalog information for a single show identified by its unique Spotify ID.
   */
  def getAShow(id: String, market: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],ShowObject] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _)

    val requestUrl = baseUri.addPath("/shows").addPath(s"/$id").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, ShowObject]).send(client).body
  }

  /**
   * Get Show Episodes
   * Get Spotify catalog information about an show’s episodes. Optional parameters can be used to limit the number of episodes returned.
   */
  def getAShowsEpisodes(id: String, market: Option[String], limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],PagingObject] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/shows/episodes").addPath(s"/$id").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Get Several Shows
   * Get Spotify catalog information for several shows based on their Spotify IDs.
   */
  def getMultipleShows(ids: String, market: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],GetMultipleShows200Response] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/shows").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetMultipleShows200Response]).send(client).body
  }

  /**
   * Get User's Saved Shows
   * Get a list of shows saved in the current Spotify user's library. Optional parameters can be used to limit the number of shows returned.
   */
  def getUsersSavedShows(limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],PagingObject] = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/shows").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Remove User's Saved Shows
   * Delete one or more shows from current Spotify user's library.
   */
  def removeShowsUser(ids: String, market: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids) ++ market.map("market" -> _)

    val requestUrl = baseUri.addPath("/me/shows").addParams(queryParams)

    basicRequest.delete(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Save Shows for Current User
   * Save one or more shows to current Spotify user's library.
   */
  def saveShowsUser(ids: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/shows").addParams(queryParams)

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

}
