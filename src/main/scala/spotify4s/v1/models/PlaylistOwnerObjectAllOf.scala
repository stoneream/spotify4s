package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class PlaylistOwnerObjectAllOf (
  /* The name displayed on the user's profile. `null` if not available.  */
  displayName: Option[String] = None
)

object PlaylistOwnerObjectAllOf {
  implicit val format: Format[PlaylistOwnerObjectAllOf] = Json.format[PlaylistOwnerObjectAllOf]

}
