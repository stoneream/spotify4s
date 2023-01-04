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
    `type`: Option[SimplifiedArtistObject.`Type`] = None,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the artist.  */
    uri: Option[String] = None
)

object SimplifiedArtistObject {

  sealed abstract class `Type`(val value: String)

  object `Type` {
    final case object Artist extends `Type`("artist")
    final case object Unknown extends `Type`("unknown")

    val values: Seq[Artist.type] = Seq(Artist)

    def fromString(s: String): `Type` = values.find(p => p.value == s).getOrElse(Unknown)
  }

}
