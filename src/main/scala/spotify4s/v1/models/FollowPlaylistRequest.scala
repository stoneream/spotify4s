package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class FollowPlaylistRequest (
  /* Defaults to `true`. If `true` the playlist will be included in user's public playlists, if `false` it will remain private.  */
  public: Option[Boolean] = None
)

object FollowPlaylistRequest {
  implicit val format: Format[FollowPlaylistRequest] = Json.format[FollowPlaylistRequest]

}
