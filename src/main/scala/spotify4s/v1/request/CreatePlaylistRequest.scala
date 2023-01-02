package spotify4s.v1.request


case class CreatePlaylistRequest (
  /* The name for the new playlist, for example `\"Your Coolest Playlist\"`. This name does not need to be unique; a user may have several playlists with the same name.  */
  name: String,
  /* Defaults to `true`. If `true` the playlist will be public, if `false` it will be private. To be able to create private playlists, the user must have granted the `playlist-modify-private` [scope](/documentation/general/guides/authorization-guide/#list-of-scopes)  */
  public: Option[Boolean] = None,
  /* Defaults to `false`. If `true` the playlist will be collaborative. _**Note**: to create a collaborative playlist you must also set `public` to `false`. To create collaborative playlists you must have granted `playlist-modify-private` and `playlist-modify-public` [scopes](/documentation/general/guides/authorization-guide/#list-of-scopes)._  */
  collaborative: Option[Boolean] = None,
  /* value for playlist description as displayed in Spotify Clients and in the Web API.  */
  description: Option[String] = None
)

