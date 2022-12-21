package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class AudiobookBaseExternalUrls (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object AudiobookBaseExternalUrls {
  implicit val format: Format[AudiobookBaseExternalUrls] = Json.format[AudiobookBaseExternalUrls]

}
