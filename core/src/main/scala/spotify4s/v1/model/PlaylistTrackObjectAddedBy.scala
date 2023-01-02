package spotify4s.v1.model

case class PlaylistTrackObjectAddedBy(
    externalUrls: Option[PublicUserObjectExternalUrls] = None,
    followers: Option[PublicUserObjectFollowers] = None,
    /* A link to the Web API endpoint for this user.  */
    href: Option[String] = None,
    /* The [Spotify user ID](/documentation/web-api/#spotify-uris-and-ids) for this user.  */
    id: Option[String] = None,
    /* The object type.  */
    `type`: Option[PlaylistTrackObjectAddedByEnums.`Type`] = None,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for this user.  */
    uri: Option[String] = None
)

object PlaylistTrackObjectAddedByEnums {

  type `Type` = `Type`.Value
  object `Type` extends Enumeration {
    val User = Value("user")
  }

}