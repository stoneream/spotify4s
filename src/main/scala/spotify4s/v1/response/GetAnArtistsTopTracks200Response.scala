package spotify4s.v1.response

import spotify4s.v1.model.TrackObject


case class GetAnArtistsTopTracks200Response (
  tracks: List[TrackObject]
)

