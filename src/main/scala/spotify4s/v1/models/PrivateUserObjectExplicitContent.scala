package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class PrivateUserObjectExplicitContent (
  /* When `true`, indicates that explicit content should not be played.  */
  filterEnabled: Option[Boolean] = None,
  /* When `true`, indicates that the explicit content setting is locked and can't be changed by the user.  */
  filterLocked: Option[Boolean] = None
)

object PrivateUserObjectExplicitContent {
  implicit val format: Format[PrivateUserObjectExplicitContent] = Json.format[PrivateUserObjectExplicitContent]

}
