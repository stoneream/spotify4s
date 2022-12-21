package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

import java.time.OffsetDateTime

case class SavedEpisodeObject (
  /* The date and time the episode was saved. Timestamps are returned in ISO 8601 format as Coordinated Universal Time (UTC) with a zero offset: YYYY-MM-DDTHH:MM:SSZ.  */
  addedAt: Option[OffsetDateTime] = None,
  episode: Option[SavedEpisodeObjectEpisode] = None
)

object SavedEpisodeObject {
  implicit val format: Format[SavedEpisodeObject] = Json.format[SavedEpisodeObject]

}
