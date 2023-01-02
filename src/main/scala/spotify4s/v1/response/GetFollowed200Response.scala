package spotify4s.v1.response

import spotify4s.v1.model.CursorPagingObject

case class GetFollowed200Response(
    artists: CursorPagingObject
)
