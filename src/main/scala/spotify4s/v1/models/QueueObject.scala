package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class QueueObject (
  currentlyPlaying: Option[CurrentlyPlayingObjectItem] = None,
  /* The tracks or episodes in the queue. Can be empty. */
  queue: Option[List[QueueObjectQueueInner]] = None
)

object QueueObject {
  implicit val format: Format[QueueObject] = Json.format[QueueObject]

}
