package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetMultipleAlbums200Response (
  albums: List[AlbumObject]
)

object GetMultipleAlbums200Response {
  implicit val format: Format[GetMultipleAlbums200Response] = Json.format[GetMultipleAlbums200Response]

}
