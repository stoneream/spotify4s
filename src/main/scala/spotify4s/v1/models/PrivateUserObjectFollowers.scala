package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class PrivateUserObjectFollowers (
  /* This will always be set to null, as the Web API does not support it at the moment.  */
  href: Option[String] = None,
  /* The total number of followers.  */
  total: Option[Int] = None
)

object PrivateUserObjectFollowers {
  implicit val format: Format[PrivateUserObjectFollowers] = Json.format[PrivateUserObjectFollowers]

}
