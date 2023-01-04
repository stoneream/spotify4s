package spotify4s.v1.model

case class CursorPagingObject(
    /* A link to the Web API endpoint returning the full result of the request. */
    href: Option[String] = None,
    /* The requested data. */
    // todo fix
    // items: Option[List[Object]] = None,
    /* The maximum number of items in the response (as set in the query or by default). */
    limit: Option[Int] = None,
    /* URL to the next page of items. ( `null` if none) */
    next: Option[String] = None,
    cursors: Option[CursorPagingObjectCursors] = None,
    /* The total number of items available to return. */
    total: Option[Int] = None
)
