package spotify4s.v1.model

case class SimplifiedAlbumObjectAllOf(
    /* The field is present when getting an artist's albums. Compare to album_type this field represents relationship between the artist and the album.  */
    albumGroup: Option[SimplifiedAlbumObjectAllOfEnums.AlbumGroup] = None,
    /* The artists of the album. Each artist object includes a link in `href` to more detailed information about the artist.  */
    artists: List[SimplifiedArtistObject]
)

object SimplifiedAlbumObjectAllOfEnums {

  type AlbumGroup = AlbumGroup.Value
  object AlbumGroup extends Enumeration {
    val Album = Value("album")
    val Single = Value("single")
    val Compilation = Value("compilation")
    val AppearsOn = Value("appears_on")
  }

}
