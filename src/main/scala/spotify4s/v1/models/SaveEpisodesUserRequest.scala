package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class SaveEpisodesUserRequest (
  /* A JSON array of the [Spotify IDs](/documentation/web-api/#spotify-uris-and-ids). <br>A maximum of 50 items can be specified in one request. _**Note**: if the `ids` parameter is present in the query string, any IDs listed here in the body will be ignored._  */
  ids: Option[List[String]] = None
)

object SaveEpisodesUserRequest {
  implicit val format: Format[SaveEpisodesUserRequest] = Json.format[SaveEpisodesUserRequest]

}
