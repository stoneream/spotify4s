package spotify4s.v1.model

case class SimplifiedAlbumObjectAllOf(
    /* The field is present when getting an artist's albums. Compare to album_type this field represents relationship between the artist and the album.  */
    albumGroup: Option[SimplifiedAlbumObjectAllOf.AlbumGroup] = None,
    /* The artists of the album. Each artist object includes a link in `href` to more detailed information about the artist.  */
    artists: List[SimplifiedArtistObject]
)

object SimplifiedAlbumObjectAllOf {

  sealed abstract class AlbumGroup(val value: String)

  object AlbumGroup {
    final case object Album extends AlbumGroup("album")
    final case object Single extends AlbumGroup("single")
    final case object Compilation extends AlbumGroup("compilation")
    final case object AppearsOn extends AlbumGroup("appears_on")
    final case object Unknown extends AlbumGroup("unknown")

    val values: Seq[AlbumGroup] = Seq(Album, Single, Compilation, AppearsOn)

    def fromString(s: String): AlbumGroup = values.find(p => p.value == s).getOrElse(Unknown)
  }

}
