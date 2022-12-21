package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class PrivateUserObjectExternalUrls (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object PrivateUserObjectExternalUrls {
  implicit val format: Format[PrivateUserObjectExternalUrls] = Json.format[PrivateUserObjectExternalUrls]

}
