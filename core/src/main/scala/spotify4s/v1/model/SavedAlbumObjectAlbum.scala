package spotify4s.v1.model

case class SavedAlbumObjectAlbum(
    /* The type of the album.  */
    albumType: SavedAlbumObjectAlbum.AlbumType,
    /* The number of tracks in the album. */
    totalTracks: Int,
    /* The markets in which the album is available: [ISO 3166-1 alpha-2 country codes](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2). _**NOTE**: an album is considered available in a market when at least 1 of its tracks is available in that market._  */
    availableMarkets: List[String],
    externalUrls: AlbumBaseExternalUrls,
    /* A link to the Web API endpoint providing full details of the album.  */
    href: String,
    /* The [Spotify ID](/documentation/web-api/#spotify-uris-and-ids) for the album.  */
    id: String,
    /* The cover art for the album in various sizes, widest first.  */
    images: List[ImageObject],
    /* The name of the album. In case of an album takedown, the value may be an empty string.  */
    name: String,
    /* The date the album was first released.  */
    releaseDate: String,
    /* The precision with which `release_date` value is known.  */
    releaseDatePrecision: SavedAlbumObjectAlbum.ReleaseDatePrecision,
    restrictions: Option[AlbumBaseRestrictions] = None,
    /* The object type.  */
    `type`: SavedAlbumObjectAlbum.`Type`,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the album.  */
    uri: String,
    /* The artists of the album. Each artist object includes a link in `href` to more detailed information about the artist.  */
    artists: Option[List[ArtistObject]] = None,
    /* The tracks of the album.  */
    tracks: Option[PagingObject] = None
)

object SavedAlbumObjectAlbum {

  sealed abstract class AlbumType(val value: String)

  object AlbumType {
    final case object Album extends AlbumType("album")
    final case object Single extends AlbumType("single")
    final case object Compilation extends AlbumType("compilation")
    final case object Unknown extends AlbumType("unknown")

    val values: Seq[AlbumType] = Seq(Album, Single, Compilation)

    def fromString(s: String): AlbumType = values.find(p => p.value == s).getOrElse(Unknown)
  }

  sealed abstract class ReleaseDatePrecision(val value: String)

  object ReleaseDatePrecision {
    final case object Year extends ReleaseDatePrecision("year")
    final case object Month extends ReleaseDatePrecision("month")
    final case object Day extends ReleaseDatePrecision("day")
    final case object Unknown extends ReleaseDatePrecision("unknown")

    val values: Seq[ReleaseDatePrecision] = Seq(Year, Month, Day)

    def fromString(s: String): ReleaseDatePrecision = values.find(p => p.value == s).getOrElse(Unknown)
  }

  sealed abstract class `Type`(val value: String)

  object `Type` {
    final case object Album extends `Type`("album")
    final case object Unknown extends `Type`("unknown")

    val values: Seq[Album.type] = Seq(Album)

    def fromString(s: String): `Type` = values.find(p => p.value == s).getOrElse(Unknown)
  }

}
