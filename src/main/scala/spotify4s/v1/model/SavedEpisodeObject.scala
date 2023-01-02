package spotify4s.v1.model

import java.time.OffsetDateTime

case class SavedEpisodeObject (
  /* The date and time the episode was saved. Timestamps are returned in ISO 8601 format as Coordinated Universal Time (UTC) with a zero offset: YYYY-MM-DDTHH:MM:SSZ.  */
  addedAt: Option[OffsetDateTime] = None,
  episode: Option[SavedEpisodeObjectEpisode] = None
)

