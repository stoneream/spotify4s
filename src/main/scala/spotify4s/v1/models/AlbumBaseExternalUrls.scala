package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class AlbumBaseExternalUrls (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object AlbumBaseExternalUrls {
  implicit val format: Format[AlbumBaseExternalUrls] = Json.format[AlbumBaseExternalUrls]

}
