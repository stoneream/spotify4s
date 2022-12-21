package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class ShowBaseExternalUrls (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object ShowBaseExternalUrls {
  implicit val format: Format[ShowBaseExternalUrls] = Json.format[ShowBaseExternalUrls]

}
