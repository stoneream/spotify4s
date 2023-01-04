package spotify4s.v1.request

case class StartAUsersPlaybackRequest(
    /* todo fix
  /* Optional. Spotify URI of the context to play. Valid contexts are albums, artists & playlists. {context_uri:\"spotify:album:1Je1IMUlBXcx1Fz0WE7oPT\"}  */
  contextUri: Option[Map[String, oas_any_type_not_mapped]] = None,
  /* Optional. A JSON array of the Spotify track URIs to play. For example: {\"uris\": [\"spotify:track:4iV5W9uYEdYUVa79Axb7Rh\", \"spotify:track:1301WleyT98MSxVHPZCA6M\"]}  */
  uris: Option[List[String]] = None,
  /* Optional. Indicates from where in the context playback should start. Only available when context_uri corresponds to an album or playlist object \"position\" is zero based and can’t be negative. Example: \"offset\": {\"position\": 5} \"uri\" is a string representing the uri of the item to start at. Example: \"offset\": {\"uri\": \"spotify:track:1301WleyT98MSxVHPZCA6M\"}  */
  offset: Option[Map[String, oas_any_type_not_mapped]] = None,
  /* integer */
  positionMs: Option[Map[String, oas_any_type_not_mapped]] = None
     */
)
