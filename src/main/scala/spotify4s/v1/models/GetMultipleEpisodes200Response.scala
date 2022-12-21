package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetMultipleEpisodes200Response (
  episodes: List[EpisodeObject]
)

object GetMultipleEpisodes200Response {
  implicit val format: Format[GetMultipleEpisodes200Response] = Json.format[GetMultipleEpisodes200Response]

}
