package spotify4s.v1.response

import spotify4s.v1.model.EpisodeObject

case class GetMultipleEpisodes200Response(
    episodes: List[EpisodeObject]
)
