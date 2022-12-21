package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class ContextObjectExternalUrls (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object ContextObjectExternalUrls {
  implicit val format: Format[ContextObjectExternalUrls] = Json.format[ContextObjectExternalUrls]

}
