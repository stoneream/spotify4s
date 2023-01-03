package spotify4s.sttp

import io.circe.generic.extras.auto._
import spotify4s.v1.model.{ChapterObject, ErrorObject, PagingObject}
import spotify4s.v1.response.GetSeveralChapters200Response
import sttp.client3._
import sttp.client3.circe._

object ChaptersApi {

  private val baseUri = uri"https://api.spotify.com/v1"

  /**
   * Get a Chapter
   * Get Spotify catalog information for a single chapter.<br /> **Note: Chapters are only available for the US, UK, Ireland, New Zealand and Australia markets.**
   */
  def getAChapter(id: String, market: Option[String])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _.toString)

    val requestUrl = baseUri.addPath("/chapters").addPath(s"/${id}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, ChapterObject]).send(client).body
  }

  /**
   * Get Audiobook Chapters
   * Get Spotify catalog information about an audiobook's chapters.<br /> **Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.**
   */
  def getAudiobookChapters(id: String, market: Option[String], limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/audiobooks/chapters").addPath(s"/${id}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Get Several Chapters
   * Get Spotify catalog information for several chapters identified by their Spotify IDs.<br /> **Note: Chapters are only available for the US, UK, Ireland, New Zealand and Australia markets.**
   */
  def getSeveralChapters(ids: String, market: Option[String])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString) ++ market.map("market" -> _.toString)

    val requestUrl = baseUri.addPath("/chapters").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetSeveralChapters200Response]).send(client).body
  }

}
