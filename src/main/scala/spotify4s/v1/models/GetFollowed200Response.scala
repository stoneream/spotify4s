package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetFollowed200Response (
  artists: CursorPagingObject
)

object GetFollowed200Response {
  implicit val format: Format[GetFollowed200Response] = Json.format[GetFollowed200Response]

}
