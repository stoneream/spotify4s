package spotify4s.v1.model


case class ResumePointObject (
  /* Whether or not the episode has been fully played by the user.  */
  fullyPlayed: Option[Boolean] = None,
  /* The user's most recent position in the episode in milliseconds.  */
  resumePositionMs: Option[Int] = None
)

