package spotify4s.v1.model


case class SimplifiedTrackObjectLinkedFrom (
  externalUrls: Option[LinkedTrackObjectExternalUrls] = None,
  /* A link to the Web API endpoint providing full details of the track.  */
  href: Option[String] = None,
  /* The [Spotify ID](/documentation/web-api/#spotify-uris-and-ids) for the track.  */
  id: Option[String] = None,
  /* The object type: \"track\".  */
  `type`: Option[String] = None,
  /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the track.  */
  uri: Option[String] = None
)

