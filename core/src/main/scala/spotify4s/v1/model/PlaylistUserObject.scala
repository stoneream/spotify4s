package spotify4s.v1.model

case class PlaylistUserObject(
    externalUrls: Option[PublicUserObjectExternalUrls] = None,
    followers: Option[PublicUserObjectFollowers] = None,
    /* A link to the Web API endpoint for this user.  */
    href: Option[String] = None,
    /* The [Spotify user ID](/documentation/web-api/#spotify-uris-and-ids) for this user.  */
    id: Option[String] = None,
    /* The object type.  */
    `type`: Option[PlaylistUserObject.`Type`] = None,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for this user.  */
    uri: Option[String] = None
)

object PlaylistUserObject {

  sealed abstract class `Type`(val value: String)

  object `Type` {
    final case object User extends `Type`("user")
    final case object Unknown extends `Type`("unknown")

    val values: Seq[User.type] = Seq(User)

    def fromString(s: String): `Type` = values.find(p => p.value == s).getOrElse(Unknown)
  }

}
