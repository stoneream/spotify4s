package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class PagingObject (
  /* A link to the Web API endpoint returning the full result of the request  */
  href: String,
  /* The requested content  */
//  items: List[Any],
  /* The maximum number of items in the response (as set in the query or by default).  */
  limit: Int,
  /* URL to the next page of items. ( `null` if none)  */
  next: String,
  /* The offset of the items returned (as set in the query or by default)  */
  offset: Int,
  /* URL to the previous page of items. ( `null` if none)  */
  previous: String,
  /* The total number of items available to return.  */
  total: Int
)

object PagingObject {
  implicit val format: Format[PagingObject] = Json.format[PagingObject]

}
