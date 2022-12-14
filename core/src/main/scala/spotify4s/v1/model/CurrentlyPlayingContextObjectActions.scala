package spotify4s.v1.model

case class CurrentlyPlayingContextObjectActions(
    /* Interrupting playback. Optional field. */
    interruptingPlayback: Option[Boolean] = None,
    /* Pausing. Optional field. */
    pausing: Option[Boolean] = None,
    /* Resuming. Optional field. */
    resuming: Option[Boolean] = None,
    /* Seeking playback location. Optional field. */
    seeking: Option[Boolean] = None,
    /* Skipping to the next context. Optional field. */
    skippingNext: Option[Boolean] = None,
    /* Skipping to the previous context. Optional field. */
    skippingPrev: Option[Boolean] = None,
    /* Toggling repeat context flag. Optional field. */
    togglingRepeatContext: Option[Boolean] = None,
    /* Toggling shuffle flag. Optional field. */
    togglingShuffle: Option[Boolean] = None,
    /* Toggling repeat track flag. Optional field. */
    togglingRepeatTrack: Option[Boolean] = None,
    /* Transfering playback between devices. Optional field. */
    transferringPlayback: Option[Boolean] = None
)
