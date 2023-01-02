package spotify4s.v1.response

import spotify4s.v1.model.ArtistObject


case class GetMultipleArtists200Response (
  artists: List[ArtistObject]
)

