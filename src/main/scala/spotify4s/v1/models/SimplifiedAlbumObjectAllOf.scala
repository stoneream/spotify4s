package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class SimplifiedAlbumObjectAllOf (
  /* The field is present when getting an artist's albums. Compare to album_type this field represents relationship between the artist and the album.  */
  albumGroup: Option[SimplifiedAlbumObjectAllOf.AlbumGroup] = None,
  /* The artists of the album. Each artist object includes a link in `href` to more detailed information about the artist.  */
  artists: List[SimplifiedArtistObject]
)

object SimplifiedAlbumObjectAllOf {
  implicit val format: Format[SimplifiedAlbumObjectAllOf] = Json.format[SimplifiedAlbumObjectAllOf]

  type AlbumGroup = AlbumGroup.Value

  object AlbumGroup extends Enumeration {
    val Album = Value("album")
    val Single = Value("single")
    val Compilation = Value("compilation")
    val AppearsOn = Value("appears_on")

  implicit val format: Format[AlbumGroup] = Json.formatEnum(this)

  }

}
