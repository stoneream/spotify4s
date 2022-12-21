package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class Search200Response (
  tracks: Option[PagingObject] = None,
  artists: Option[PagingObject] = None,
  albums: Option[PagingObject] = None,
  playlists: Option[PagingObject] = None,
  shows: Option[PagingObject] = None,
  episodes: Option[PagingObject] = None,
  audiobooks: Option[PagingObject] = None
)

object Search200Response {
  implicit val format: Format[Search200Response] = Json.format[Search200Response]

}
