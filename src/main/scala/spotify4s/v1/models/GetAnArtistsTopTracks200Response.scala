package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetAnArtistsTopTracks200Response (
  tracks: List[TrackObject]
)

object GetAnArtistsTopTracks200Response {
  implicit val format: Format[GetAnArtistsTopTracks200Response] = Json.format[GetAnArtistsTopTracks200Response]

}
