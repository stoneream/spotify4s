package spotify4s.v1.model


case class ExplicitContentSettingsObject (
  /* When `true`, indicates that explicit content should not be played.  */
  filterEnabled: Option[Boolean] = None,
  /* When `true`, indicates that the explicit content setting is locked and can't be changed by the user.  */
  filterLocked: Option[Boolean] = None
)

