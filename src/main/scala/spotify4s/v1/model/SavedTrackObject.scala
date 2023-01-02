package spotify4s.v1.model

import java.time.OffsetDateTime

case class SavedTrackObject (
  /* The date and time the track was saved. Timestamps are returned in ISO 8601 format as Coordinated Universal Time (UTC) with a zero offset: YYYY-MM-DDTHH:MM:SSZ. If the time is imprecise (for example, the date/time of an album release), an additional field indicates the precision; see for example, release_date in an album object.  */
  addedAt: Option[OffsetDateTime] = None,
  track: Option[SavedTrackObjectTrack] = None
)

