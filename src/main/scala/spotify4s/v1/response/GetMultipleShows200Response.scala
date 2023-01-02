package spotify4s.v1.response

import spotify4s.v1.model.SimplifiedShowObject

case class GetMultipleShows200Response(
    shows: List[SimplifiedShowObject]
)
