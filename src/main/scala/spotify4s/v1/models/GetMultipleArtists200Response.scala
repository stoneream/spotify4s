package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetMultipleArtists200Response (
  artists: List[ArtistObject]
)

object GetMultipleArtists200Response {
  implicit val format: Format[GetMultipleArtists200Response] = Json.format[GetMultipleArtists200Response]

}
