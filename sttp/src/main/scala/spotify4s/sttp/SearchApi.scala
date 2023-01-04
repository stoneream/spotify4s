package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model.ErrorObject
import spotify4s.v1.response.Search200Response
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

case class SearchApi(baseUri: Uri = uri"https://api.spotify.com/v1") {
  /**
   * Search for Item
   * Get Spotify catalog information about albums, artists, playlists, tracks, shows, episodes or audiobooks that match a keyword string.
   * **Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.**
   */
  def search(q: String, `type`: List[String], market: Option[String], limit: Option[Int], offset: Option[Int], includeExternal: Option[String])(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Search200Response] = {

    val queryParams = Map.empty[String, String] + ("q" -> q) + ("type" -> `type`.toString) ++ market.map("market" -> _) ++ limit.map(
      "limit" -> _.toString
    ) ++ offset.map("offset" -> _.toString) ++ includeExternal.map("includeExternal" -> _)

    val requestUrl = baseUri.addPath("/search").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, Search200Response]).auth.bearer(accessToken).send(client).body
  }

}
