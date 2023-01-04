package spotify4s.v1.model

case class SimplifiedAlbumObjectAllOf(
    /* The field is present when getting an artist's albums. Compare to album_type this field represents relationship between the artist and the album.  */
    albumGroup: Option[String] = None,
    /* The artists of the album. Each artist object includes a link in `href` to more detailed information about the artist.  */
    artists: List[SimplifiedArtistObject]
)
