package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class AudiobookObjectAllOf (
  /* The chapters of the audiobook.  */
  chapters: PagingObject
)

object AudiobookObjectAllOf {
  implicit val format: Format[AudiobookObjectAllOf] = Json.format[AudiobookObjectAllOf]

}
