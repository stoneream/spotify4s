package spotify4s.v1.response

import spotify4s.v1.model.AudiobookObject


case class GetMultipleAudiobooks200Response (
  audiobooks: List[AudiobookObject]
)

