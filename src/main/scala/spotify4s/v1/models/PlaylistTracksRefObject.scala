package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class PlaylistTracksRefObject (
  /* A link to the Web API endpoint where full details of the playlist's tracks can be retrieved.  */
  href: Option[String] = None,
  /* Number of tracks in the playlist.  */
  total: Option[Int] = None
)

object PlaylistTracksRefObject {
  implicit val format: Format[PlaylistTracksRefObject] = Json.format[PlaylistTracksRefObject]

}
