package spotify4s.v1.model


case class RecommendationSeedObject (
  /* The number of tracks available after min\\_\\* and max\\_\\* filters have been applied.  */
  afterFilteringSize: Option[Int] = None,
  /* The number of tracks available after relinking for regional availability.  */
  afterRelinkingSize: Option[Int] = None,
  /* A link to the full track or artist data for this seed. For tracks this will be a link to a [Track Object](/documentation/web-api/reference/#object-trackobject). For artists a link to [an Artist Object](/documentation/web-api/reference/#object-artistobject). For genre seeds, this value will be `null`.  */
  href: Option[String] = None,
  /* The id used to select this seed. This will be the same as the string used in the `seed_artists`, `seed_tracks` or `seed_genres` parameter.  */
  id: Option[String] = None,
  /* The number of recommended tracks available for this seed.  */
  initialPoolSize: Option[Int] = None,
  /* The entity type of this seed. One of `artist`, `track` or `genre`.  */
  `type`: Option[String] = None
)

