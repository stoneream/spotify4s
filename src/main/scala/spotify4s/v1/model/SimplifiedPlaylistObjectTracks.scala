package spotify4s.v1.model


case class SimplifiedPlaylistObjectTracks (
  /* A link to the Web API endpoint where full details of the playlist's tracks can be retrieved.  */
  href: Option[String] = None,
  /* Number of tracks in the playlist.  */
  total: Option[Int] = None
)

