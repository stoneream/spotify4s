package spotify4s.v1.model


case class SimplifiedAlbumObject (
  /* The type of the album.  */
  albumType: SimplifiedAlbumObjectEnums.AlbumType,
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
  releaseDatePrecision: SimplifiedAlbumObjectEnums.ReleaseDatePrecision,
  restrictions: Option[AlbumBaseRestrictions] = None,
  /* The object type.  */
  `type`: SimplifiedAlbumObjectEnums.`Type`,
  /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the album.  */
  uri: String,
  /* The field is present when getting an artist's albums. Compare to album_type this field represents relationship between the artist and the album.  */
  albumGroup: Option[SimplifiedAlbumObjectEnums.AlbumGroup] = None,
  /* The artists of the album. Each artist object includes a link in `href` to more detailed information about the artist.  */
  artists: List[SimplifiedArtistObject]
)

object SimplifiedAlbumObjectEnums {

  type AlbumType = AlbumType.Value
  type ReleaseDatePrecision = ReleaseDatePrecision.Value
  type `Type` = `Type`.Value
  type AlbumGroup = AlbumGroup.Value
  object AlbumType extends Enumeration {
    val Album = Value("album")
    val Single = Value("single")
    val Compilation = Value("compilation")
  }

  object ReleaseDatePrecision extends Enumeration {
    val Year = Value("year")
    val Month = Value("month")
    val Day = Value("day")
  }

  object `Type` extends Enumeration {
    val Album = Value("album")
  }

  object AlbumGroup extends Enumeration {
    val Album = Value("album")
    val Single = Value("single")
    val Compilation = Value("compilation")
    val AppearsOn = Value("appears_on")
  }

}
