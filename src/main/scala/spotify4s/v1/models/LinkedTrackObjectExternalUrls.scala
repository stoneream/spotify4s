package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class LinkedTrackObjectExternalUrls (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object LinkedTrackObjectExternalUrls {
  implicit val format: Format[LinkedTrackObjectExternalUrls] = Json.format[LinkedTrackObjectExternalUrls]

}
