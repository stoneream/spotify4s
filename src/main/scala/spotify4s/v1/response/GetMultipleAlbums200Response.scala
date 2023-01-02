package spotify4s.v1.response

import spotify4s.v1.model.AlbumObject

case class GetMultipleAlbums200Response(
    albums: List[AlbumObject]
)
