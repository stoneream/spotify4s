package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class EpisodeBaseResumePoint (
  /* Whether or not the episode has been fully played by the user.  */
  fullyPlayed: Option[Boolean] = None,
  /* The user's most recent position in the episode in milliseconds.  */
  resumePositionMs: Option[Int] = None
)

object EpisodeBaseResumePoint {
  implicit val format: Format[EpisodeBaseResumePoint] = Json.format[EpisodeBaseResumePoint]

}
