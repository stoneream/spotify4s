package spotify4s.v1.request

case class ChangePlaylistDetailsRequest(
    /* The new name for the playlist, for example `\"My New Playlist Title\"`  */
    name: Option[String] = None,
    /* If `true` the playlist will be public, if `false` it will be private.  */
    public: Option[Boolean] = None,
    /* If `true`, the playlist will become collaborative and other users will be able to modify the playlist in their Spotify client. <br> _**Note**: You can only set `collaborative` to `true` on non-public playlists._  */
    collaborative: Option[Boolean] = None,
    /* Value for playlist description as displayed in Spotify Clients and in the Web API.  */
    description: Option[String] = None
)
