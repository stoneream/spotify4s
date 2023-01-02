package spotify4s.v1.model

import java.time.OffsetDateTime

case class PlayHistoryObject(
    track: Option[PlayHistoryObjectTrack] = None,
    /* The date and time the track was played. */
    playedAt: Option[OffsetDateTime] = None,
    context: Option[PlayHistoryObjectContext] = None
)
