package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class SimplifiedTrackObjectExternalUrls (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object SimplifiedTrackObjectExternalUrls {
  implicit val format: Format[SimplifiedTrackObjectExternalUrls] = Json.format[SimplifiedTrackObjectExternalUrls]

}
