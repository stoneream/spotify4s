package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class CurrentlyPlayingContextObject (
  device: Option[CurrentlyPlayingContextObjectDevice] = None,
  /* off, track, context */
  repeatState: Option[String] = None,
  /* If shuffle is on or off. */
  shuffleState: Option[String] = None,
  context: Option[CurrentlyPlayingObjectContext] = None,
  /* Unix Millisecond Timestamp when data was fetched. */
  timestamp: Option[Int] = None,
  /* Progress into the currently playing track or episode. Can be `null`. */
  progressMs: Option[Int] = None,
  /* If something is currently playing, return `true`. */
  isPlaying: Option[Boolean] = None,
  item: Option[CurrentlyPlayingObjectItem] = None,
  /* The object type of the currently playing item. Can be one of `track`, `episode`, `ad` or `unknown`.  */
  currentlyPlayingType: Option[String] = None,
  actions: Option[CurrentlyPlayingContextObjectActions] = None
)

object CurrentlyPlayingContextObject {
  implicit val format: Format[CurrentlyPlayingContextObject] = Json.format[CurrentlyPlayingContextObject]

}
