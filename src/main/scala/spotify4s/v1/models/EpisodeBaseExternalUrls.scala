package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class EpisodeBaseExternalUrls (
  /* The [Spotify URL](/documentation/web-api/#spotify-uris-and-ids) for the object.  */
  spotify: Option[String] = None
)

object EpisodeBaseExternalUrls {
  implicit val format: Format[EpisodeBaseExternalUrls] = Json.format[EpisodeBaseExternalUrls]

}
