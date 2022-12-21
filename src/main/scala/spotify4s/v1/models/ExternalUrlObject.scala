package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class ExternalUrlObject (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object ExternalUrlObject {
  implicit val format: Format[ExternalUrlObject] = Json.format[ExternalUrlObject]

}
