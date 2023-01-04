package spotify4s.v1.model

case class ArtistObject(
    externalUrls: Option[ArtistObjectExternalUrls] = None,
    followers: Option[ArtistObjectFollowers] = None,
    /* A list of the genres the artist is associated with. If not yet classified, the array is empty.  */
    genres: Option[List[String]] = None,
    /* A link to the Web API endpoint providing full details of the artist.  */
    href: Option[String] = None,
    /* The [Spotify ID](/documentation/web-api/#spotify-uris-and-ids) for the artist.  */
    id: Option[String] = None,
    /* Images of the artist in various sizes, widest first.  */
    images: Option[List[ImageObject]] = None,
    /* The name of the artist.  */
    name: Option[String] = None,
    /* The popularity of the artist. The value will be between 0 and 100, with 100 being the most popular. The artist's popularity is calculated from the popularity of all the artist's tracks.  */
    popularity: Option[Int] = None,
    /* The object type.  */
    `type`: Option[ArtistObject.`Type`] = None,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the artist.  */
    uri: Option[String] = None
)

object ArtistObject {

  sealed abstract class `Type`(val value: String)

  object `Type` {
    final case object Artist extends `Type`("artist")
    final case object Unknown extends `Type`("unknown")

    val values: Seq[Artist.type] = Seq(Artist)

    def fromString(s: String): `Type` = values.find(p => p.value == s).getOrElse(Unknown)
  }

}
