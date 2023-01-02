package spotify4s.v1.model

case class CursorPagingObjectCursors(
    /* The cursor to use as key to find the next page of items. */
    after: Option[String] = None
)
