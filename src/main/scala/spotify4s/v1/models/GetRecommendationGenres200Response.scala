package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetRecommendationGenres200Response (
  genres: List[String]
)

object GetRecommendationGenres200Response {
  implicit val format: Format[GetRecommendationGenres200Response] = Json.format[GetRecommendationGenres200Response]

}
