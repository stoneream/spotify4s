package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class PrivateUserObject (
  /* The country of the user, as set in the user's account profile. An [ISO 3166-1 alpha-2 country code](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). _This field is only available when the current user has granted access to the [user-read-private](/documentation/general/guides/authorization-guide/#list-of-scopes) scope._  */
  country: Option[String] = None,
  /* The name displayed on the user's profile. `null` if not available.  */
  displayName: Option[String] = None,
  /* The user's email address, as entered by the user when creating their account. _**Important!** This email address is unverified; there is no proof that it actually belongs to the user._ _This field is only available when the current user has granted access to the [user-read-email](/documentation/general/guides/authorization-guide/#list-of-scopes) scope._  */
  email: Option[String] = None,
  explicitContent: Option[PrivateUserObjectExplicitContent] = None,
  externalUrls: Option[PrivateUserObjectExternalUrls] = None,
  followers: Option[PrivateUserObjectFollowers] = None,
  /* A link to the Web API endpoint for this user.  */
  href: Option[String] = None,
  /* The [Spotify user ID](/documentation/web-api/#spotify-uris-and-ids) for the user.  */
  id: Option[String] = None,
  /* The user's profile image. */
  images: Option[List[ImageObject]] = None,
  /* The user's Spotify subscription level: \"premium\", \"free\", etc. (The subscription level \"open\" can be considered the same as \"free\".) _This field is only available when the current user has granted access to the [user-read-private](/documentation/general/guides/authorization-guide/#list-of-scopes) scope._  */
  product: Option[String] = None,
  /* The object type: \"user\"  */
  `type`: Option[String] = None,
  /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the user.  */
  uri: Option[String] = None
)

object PrivateUserObject {
  implicit val format: Format[PrivateUserObject] = Json.format[PrivateUserObject]

}
