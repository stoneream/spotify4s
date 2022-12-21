package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class PlaylistObjectExternalUrls (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object PlaylistObjectExternalUrls {
  implicit val format: Format[PlaylistObjectExternalUrls] = Json.format[PlaylistObjectExternalUrls]

}
