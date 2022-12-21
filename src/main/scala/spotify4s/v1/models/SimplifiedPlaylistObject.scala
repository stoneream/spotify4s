package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class SimplifiedPlaylistObject (
  /* `true` if the owner allows other users to modify the playlist.  */
  collaborative: Option[Boolean] = None,
  /* The playlist description. _Only returned for modified, verified playlists, otherwise_ `null`.  */
  description: Option[String] = None,
  externalUrls: Option[PlaylistObjectExternalUrls] = None,
  /* A link to the Web API endpoint providing full details of the playlist.  */
  href: Option[String] = None,
  /* The [Spotify ID](/documentation/web-api/#spotify-uris-and-ids) for the playlist.  */
  id: Option[String] = None,
  /* Images for the playlist. The array may be empty or contain up to three images. The images are returned by size in descending order. See [Working with Playlists](/documentation/general/guides/working-with-playlists/). _**Note**: If returned, the source URL for the image (`url`) is temporary and will expire in less than a day._  */
  images: Option[List[ImageObject]] = None,
  /* The name of the playlist.  */
  name: Option[String] = None,
  owner: Option[PlaylistObjectOwner] = None,
  /* The playlist's public/private status: `true` the playlist is public, `false` the playlist is private, `null` the playlist status is not relevant. For more about public/private status, see [Working with Playlists](/documentation/general/guides/working-with-playlists/)  */
  public: Option[Boolean] = None,
  /* The version identifier for the current playlist. Can be supplied in other requests to target a specific playlist version  */
  snapshotId: Option[String] = None,
  tracks: Option[SimplifiedPlaylistObjectTracks] = None,
  /* The object type: \"playlist\"  */
  `type`: Option[String] = None,
  /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the playlist.  */
  uri: Option[String] = None
)

object SimplifiedPlaylistObject {
  implicit val format: Format[SimplifiedPlaylistObject] = Json.format[SimplifiedPlaylistObject]

}
