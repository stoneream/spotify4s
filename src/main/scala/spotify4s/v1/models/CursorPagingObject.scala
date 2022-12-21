package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class CursorPagingObject (
  /* A link to the Web API endpoint returning the full result of the request. */
  href: Option[String] = None,
  /* The requested data. */
//  items: Option[List[Any]] = None,
  /* The maximum number of items in the response (as set in the query or by default). */
  limit: Option[Int] = None,
  /* URL to the next page of items. ( `null` if none) */
  next: Option[String] = None,
  cursors: Option[CursorPagingObjectCursors] = None,
  /* The total number of items available to return. */
  total: Option[Int] = None
)

object CursorPagingObject {
  implicit val format: Format[CursorPagingObject] = Json.format[CursorPagingObject]

}
