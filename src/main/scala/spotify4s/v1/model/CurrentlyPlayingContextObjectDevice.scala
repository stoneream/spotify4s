package spotify4s.v1.model


case class CurrentlyPlayingContextObjectDevice (
  /* The device ID. */
  id: Option[String] = None,
  /* If this device is the currently active device. */
  isActive: Option[Boolean] = None,
  /* If this device is currently in a private session. */
  isPrivateSession: Option[Boolean] = None,
  /* Whether controlling this device is restricted. At present if this is \"true\" then no Web API commands will be accepted by this device. */
  isRestricted: Option[Boolean] = None,
  /* A human-readable name for the device. Some devices have a name that the user can configure (e.g. \\\"Loudest speaker\\\") and some devices have a generic name associated with the manufacturer or device model. */
  name: Option[String] = None,
  /* Device type, such as \"computer\", \"smartphone\" or \"speaker\". */
  `type`: Option[String] = None,
  /* The current volume in percent. */
  volumePercent: Option[Int] = None
)

