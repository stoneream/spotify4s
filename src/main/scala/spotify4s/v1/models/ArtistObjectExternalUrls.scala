package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class ArtistObjectExternalUrls (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object ArtistObjectExternalUrls {
  implicit val format: Format[ArtistObjectExternalUrls] = Json.format[ArtistObjectExternalUrls]

}
