package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class CursorPagingObjectCursors (
  /* The cursor to use as key to find the next page of items. */
  after: Option[String] = None
)

object CursorPagingObjectCursors {
  implicit val format: Format[CursorPagingObjectCursors] = Json.format[CursorPagingObjectCursors]

}
