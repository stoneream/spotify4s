package spotify4s.v1.response

import spotify4s.v1.model.AudioFeaturesObject

case class GetSeveralAudioFeatures200Response(
    audioFeatures: List[AudioFeaturesObject]
)
