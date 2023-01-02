package spotify4s.v1.model

case class PagingPlaylistObject(
    items: Option[List[SimplifiedPlaylistObject]] = None,
    /* A link to the Web API endpoint returning the full result of the request  */
    href: String,
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
