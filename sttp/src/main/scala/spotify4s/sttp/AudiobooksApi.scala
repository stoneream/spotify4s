package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model.{AudiobookObject, ErrorObject, PagingObject}
import spotify4s.v1.response.GetMultipleAudiobooks200Response
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

case class AudiobooksApi(baseUri: Uri = uri"https://api.spotify.com/v1") {

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
   * Get an Audiobook
   * Get Spotify catalog information for a single audiobook.
   * Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.
   */
  def getAnAudiobook(id: String, market: Option[String])(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], AudiobookObject] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _)

    val requestUrl = baseUri.addPath("/audiobooks").addPath(s"/$id").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, AudiobookObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Audiobook Chapters
   * Get Spotify catalog information about an audiobook's chapters.
   * Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.
   */
  def getAudiobookChapters(id: String, market: Option[String], limit: Option[Int], offset: Option[Int])(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingObject] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/audiobooks/chapters").addPath(s"/$id").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Several Audiobooks
   * Get Spotify catalog information for several audiobooks identified by their Spotify IDs.
   * Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.
   */
  def getMultipleAudiobooks(ids: String, market: Option[String])(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], GetMultipleAudiobooks200Response] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids) ++ market.map("market" -> _)

    val requestUrl = baseUri.addPath("/audiobooks").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetMultipleAudiobooks200Response]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get User's Saved Audiobooks
   * Get a list of the audiobooks saved in the current Spotify user's 'Your Music' library.
   */
  def getUsersSavedAudiobooks(limit: Option[Int], offset: Option[Int])(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingObject] = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/audiobooks").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).auth.bearer(accessToken).send(client).body
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
   * Save Audiobooks for Current User
   * Save one or more audiobooks to the current Spotify user's library.
   */
  def saveAudiobooksUser(ids: String)(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("/me/audiobooks").addParams(queryParams)

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

}
