package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class CursorObject (
  /* The cursor to use as key to find the next page of items. */
  after: Option[String] = None
)

object CursorObject {
  implicit val format: Format[CursorObject] = Json.format[CursorObject]

}
