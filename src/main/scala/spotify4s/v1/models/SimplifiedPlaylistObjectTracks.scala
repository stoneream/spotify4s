package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class SimplifiedPlaylistObjectTracks (
  /* A link to the Web API endpoint where full details of the playlist's tracks can be retrieved.  */
  href: Option[String] = None,
  /* Number of tracks in the playlist.  */
  total: Option[Int] = None
)

object SimplifiedPlaylistObjectTracks {
  implicit val format: Format[SimplifiedPlaylistObjectTracks] = Json.format[SimplifiedPlaylistObjectTracks]

}
