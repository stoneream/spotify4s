package spotify4s.v1.model

case class ContextObjectExternalUrls(
    /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
    spotify: Option[String] = None
)