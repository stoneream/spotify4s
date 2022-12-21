package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class PlaylistTrackObjectAddedBy (
  externalUrls: Option[PublicUserObjectExternalUrls] = None,
  followers: Option[PublicUserObjectFollowers] = None,
  /* A link to the Web API endpoint for this user.  */
  href: Option[String] = None,
  /* The [Spotify user ID](/documentation/web-api/#spotify-uris-and-ids) for this user.  */
  id: Option[String] = None,
  /* The object type.  */
  `type`: Option[PlaylistTrackObjectAddedBy.`Type`] = None,
  /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for this user.  */
  uri: Option[String] = None
)

object PlaylistTrackObjectAddedBy {
  implicit val format: Format[PlaylistTrackObjectAddedBy] = Json.format[PlaylistTrackObjectAddedBy]

  type `Type` = `Type`.Value

  object `Type` extends Enumeration {
    val User = Value("user")

  implicit val format: Format[`Type`] = Json.formatEnum(this)

  }

}
