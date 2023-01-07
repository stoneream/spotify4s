package spotify4s.v1.response

import spotify4s.v1.model.{ArtistObject, PagingObject, SimplifiedAlbumObject, SimplifiedAudiobookObject, SimplifiedPlaylistObject, SimplifiedShowObject, TrackObject}

case class Search200Response(
    tracks: Option[PagingObject[TrackObject]] = None,
    artists: Option[PagingObject[ArtistObject]] = None,
    albums: Option[PagingObject[SimplifiedAlbumObject]] = None,
    playlists: Option[PagingObject[SimplifiedPlaylistObject]] = None,
    shows: Option[PagingObject[SimplifiedShowObject]] = None,
    episodes: Option[PagingObject[SimplifiedShowObject]] = None,
    audiobooks: Option[PagingObject[SimplifiedAudiobookObject]] = None
)
