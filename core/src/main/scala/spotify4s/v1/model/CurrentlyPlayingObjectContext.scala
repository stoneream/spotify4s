package spotify4s.v1.model

case class CurrentlyPlayingObjectContext(
    /* The object type, e.g. \"artist\", \"playlist\", \"album\", \"show\".  */
    `type`: Option[String] = None,
    /* A link to the Web API endpoint providing full details of the track. */
    href: Option[String] = None,
    externalUrls: Option[ContextObjectExternalUrls] = None,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the context.  */
    uri: Option[String] = None
)
