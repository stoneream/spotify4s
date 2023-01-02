package spotify4s.v1.response

case class Search200Response(
    tracks: Option[PagingObject] = None,
    artists: Option[PagingObject] = None,
    albums: Option[PagingObject] = None,
    playlists: Option[PagingObject] = None,
    shows: Option[PagingObject] = None,
    episodes: Option[PagingObject] = None,
    audiobooks: Option[PagingObject] = None
)
