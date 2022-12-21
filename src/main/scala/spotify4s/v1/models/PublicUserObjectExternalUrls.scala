package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class PublicUserObjectExternalUrls (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object PublicUserObjectExternalUrls {
  implicit val format: Format[PublicUserObjectExternalUrls] = Json.format[PublicUserObjectExternalUrls]

}
