package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class FollowArtistsUsersRequest (
  /* A JSON array of the artist or user [Spotify IDs](/documentation/web-api/#spotify-uris-and-ids). For example: `{ids:[\"74ASZWbe4lXaubB36ztrGX\", \"08td7MxkoHQkXnWAYD8d6Q\"]}`. A maximum of 50 IDs can be sent in one request. _**Note**: if the `ids` parameter is present in the query string, any IDs listed here in the body will be ignored._  */
  ids: List[String]
)

object FollowArtistsUsersRequest {
  implicit val format: Format[FollowArtistsUsersRequest] = Json.format[FollowArtistsUsersRequest]

}
