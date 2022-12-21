package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetSeveralAudioFeatures200Response (
  audioFeatures: List[AudioFeaturesObject]
)

object GetSeveralAudioFeatures200Response {
  implicit val format: Format[GetSeveralAudioFeatures200Response] = Json.format[GetSeveralAudioFeatures200Response]

}
