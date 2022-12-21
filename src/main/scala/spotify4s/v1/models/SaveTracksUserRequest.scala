package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class SaveTracksUserRequest (
  /* A JSON array of the [Spotify IDs](/documentation/web-api/#spotify-uris-and-ids). For example: `[\"4iV5W9uYEdYUVa79Axb7Rh\", \"1301WleyT98MSxVHPZCA6M\"]`<br>A maximum of 50 items can be specified in one request. _**Note**: if the `ids` parameter is present in the query string, any IDs listed here in the body will be ignored._  */
  ids: Option[List[String]] = None
)

object SaveTracksUserRequest {
  implicit val format: Format[SaveTracksUserRequest] = Json.format[SaveTracksUserRequest]

}
