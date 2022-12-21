package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class RemoveTracksPlaylistRequestTracksInner (
  /* Spotify URI */
  uri: Option[String] = None
)

object RemoveTracksPlaylistRequestTracksInner {
  implicit val format: Format[RemoveTracksPlaylistRequestTracksInner] = Json.format[RemoveTracksPlaylistRequestTracksInner]

}
