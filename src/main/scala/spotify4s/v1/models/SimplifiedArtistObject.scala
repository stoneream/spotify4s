package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class SimplifiedArtistObject (
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
  implicit val format: Format[SimplifiedArtistObject] = Json.format[SimplifiedArtistObject]

  type `Type` = `Type`.Value

  object `Type` extends Enumeration {
    val Artist = Value("artist")

  implicit val format: Format[`Type`] = Json.formatEnum(this)

  }

}
