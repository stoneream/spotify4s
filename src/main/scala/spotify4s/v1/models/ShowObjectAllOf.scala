package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class ShowObjectAllOf (
  /* The episodes of the show.  */
  episodes: PagingObject
)

object ShowObjectAllOf {
  implicit val format: Format[ShowObjectAllOf] = Json.format[ShowObjectAllOf]

}
