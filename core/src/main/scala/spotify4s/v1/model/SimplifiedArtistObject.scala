package spotify4s.v1.model

case class SimplifiedArtistObject(
    externalUrls: Option[ArtistObjectExternalUrls] = None,
    /* A link to the Web API endpoint providing full details of the artist.  */
    href: Option[String] = None,
    /* The [Spotify ID](/documentation/web-api/#spotify-uris-and-ids) for the artist.  */
    id: Option[String] = None,
    /* The name of the artist.  */
    name: Option[String] = None,
    /* The object type.  */
    `type`: Option[String] = None,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the artist.  */
    uri: Option[String] = None
)
