package spotify4s.v1.response

import spotify4s.v1.model.{PagingObject, SimplifiedAlbumObject}

case class GetNewReleases200Response(
    albums: PagingObject[SimplifiedAlbumObject]
)
