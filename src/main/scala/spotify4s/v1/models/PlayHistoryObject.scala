package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

import java.time.OffsetDateTime

case class PlayHistoryObject (
  track: Option[PlayHistoryObjectTrack] = None,
  /* The date and time the track was played. */
  playedAt: Option[OffsetDateTime] = None,
  context: Option[PlayHistoryObjectContext] = None
)

object PlayHistoryObject {
  implicit val format: Format[PlayHistoryObject] = Json.format[PlayHistoryObject]

}
