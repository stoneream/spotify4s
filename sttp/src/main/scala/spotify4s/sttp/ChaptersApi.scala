package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model.{ChapterObject, ErrorObject, PagingObject}
import spotify4s.v1.response.GetSeveralChapters200Response
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

case class ChaptersApi(baseUri: Uri = uri"https://api.spotify.com/v1") {

  /**
   * Get a Chapter
   * Get Spotify catalog information for a single chapter.<br /> **Note: Chapters are only available for the US, UK, Ireland, New Zealand and Australia markets.**
   */
  def getAChapter(id: String, market: Option[String])(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], ChapterObject] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _)

    val requestUrl = baseUri.addPath("/chapters").addPath(s"/$id").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, ChapterObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Audiobook Chapters
   * Get Spotify catalog information about an audiobook's chapters.<br /> **Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.**
   */
  def getAudiobookChapters(id: String, market: Option[String], limit: Option[Int], offset: Option[Int])(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingObject] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/audiobooks/chapters").addPath(s"/$id").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Several Chapters
   * Get Spotify catalog information for several chapters identified by their Spotify IDs.<br /> **Note: Chapters are only available for the US, UK, Ireland, New Zealand and Australia markets.**
   */
  def getSeveralChapters(ids: String, market: Option[String])(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], GetSeveralChapters200Response] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids) ++ market.map("market" -> _)

    val requestUrl = baseUri.addPath("/chapters").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetSeveralChapters200Response]).auth.bearer(accessToken).send(client).body
  }

}
