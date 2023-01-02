package spotify4s.v1.model


case class RecommendationsObject (
  /* An array of [recommendation seed objects](/documentation/web-api/reference/#object-recommendationseedobject).  */
  seeds: List[RecommendationSeedObject],
  /* An array of [track object (simplified)](/documentation/web-api/reference/#object-simplifiedtrackobject) ordered according to the parameters supplied.  */
  tracks: List[SimplifiedTrackObject]
)

