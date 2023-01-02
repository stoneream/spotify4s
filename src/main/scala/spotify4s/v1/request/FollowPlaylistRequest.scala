package spotify4s.v1.request

case class FollowPlaylistRequest (
  /* Defaults to `true`. If `true` the playlist will be included in user's public playlists, if `false` it will remain private.  */
  public: Option[Boolean] = None
)

