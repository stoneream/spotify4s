package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class PlayHistoryObjectContext (
  /* The object type, e.g. \"artist\", \"playlist\", \"album\", \"show\".  */
  `type`: Option[String] = None,
  /* A link to the Web API endpoint providing full details of the track. */
  href: Option[String] = None,
  externalUrls: Option[ContextObjectExternalUrls] = None,
  /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the context.  */
  uri: Option[String] = None
)

object PlayHistoryObjectContext {
  implicit val format: Format[PlayHistoryObjectContext] = Json.format[PlayHistoryObjectContext]

}
