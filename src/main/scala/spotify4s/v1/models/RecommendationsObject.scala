package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class RecommendationsObject (
  /* An array of [recommendation seed objects](/documentation/web-api/reference/#object-recommendationseedobject).  */
  seeds: List[RecommendationSeedObject],
  /* An array of [track object (simplified)](/documentation/web-api/reference/#object-simplifiedtrackobject) ordered according to the parameters supplied.  */
  tracks: List[SimplifiedTrackObject]
)

object RecommendationsObject {
  implicit val format: Format[RecommendationsObject] = Json.format[RecommendationsObject]

}
