package spotify4s.v1.model

case class PlaylistObjectOwner(
    externalUrls: Option[PublicUserObjectExternalUrls] = None,
    followers: Option[PublicUserObjectFollowers] = None,
    /* A link to the Web API endpoint for this user.  */
    href: Option[String] = None,
    /* The [Spotify user ID](/documentation/web-api/#spotify-uris-and-ids) for this user.  */
    id: Option[String] = None,
    /* The object type.  */
    `type`: Option[String] = None,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for this user.  */
    uri: Option[String] = None,
    /* The name displayed on the user's profile. `null` if not available.  */
    displayName: Option[String] = None
)
