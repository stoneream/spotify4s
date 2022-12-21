package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetMultipleAudiobooks200Response (
  audiobooks: List[AudiobookObject]
)

object GetMultipleAudiobooks200Response {
  implicit val format: Format[GetMultipleAudiobooks200Response] = Json.format[GetMultipleAudiobooks200Response]

}
