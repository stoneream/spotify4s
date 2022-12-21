package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetAnAlbum401Response (
  error: ErrorObject
)

object GetAnAlbum401Response {
  implicit val format: Format[GetAnAlbum401Response] = Json.format[GetAnAlbum401Response]

}
