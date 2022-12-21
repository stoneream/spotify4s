package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class AlbumObjectAllOf (
  /* The artists of the album. Each artist object includes a link in `href` to more detailed information about the artist.  */
  artists: Option[List[ArtistObject]] = None,
  /* The tracks of the album.  */
  tracks: Option[PagingObject] = None
)

object AlbumObjectAllOf {
  implicit val format: Format[AlbumObjectAllOf] = Json.format[AlbumObjectAllOf]

}
