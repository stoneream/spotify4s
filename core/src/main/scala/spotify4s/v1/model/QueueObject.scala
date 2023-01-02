package spotify4s.v1.model

case class QueueObject(
    currentlyPlaying: Option[CurrentlyPlayingObjectItem] = None,
    /* The tracks or episodes in the queue. Can be empty. */
    queue: Option[List[QueueObjectQueueInner]] = None
)
