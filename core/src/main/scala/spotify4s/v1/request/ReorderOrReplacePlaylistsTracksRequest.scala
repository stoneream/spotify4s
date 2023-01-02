package spotify4s.v1.request

case class ReorderOrReplacePlaylistsTracksRequest(
    uris: Option[List[String]] = None,
    /* The position of the first item to be reordered.  */
    rangeStart: Option[Int] = None,
    /* The position where the items should be inserted.<br>To reorder the items to the end of the playlist, simply set _insert_before_ to the position after the last item.<br>Examples:<br>To reorder the first item to the last position in a playlist with 10 items, set _range_start_ to 0, and _insert_before_ to 10.<br>To reorder the last item in a playlist with 10 items to the start of the playlist, set _range_start_ to 9, and _insert_before_ to 0.  */
    insertBefore: Option[Int] = None,
    /* The amount of items to be reordered. Defaults to 1 if not set.<br>The range of items to be reordered begins from the _range_start_ position, and includes the _range_length_ subsequent items.<br>Example:<br>To move the items at index 9-10 to the start of the playlist, _range_start_ is set to 9, and _range_length_ is set to 2.  */
    rangeLength: Option[Int] = None,
    /* The playlist's snapshot ID against which you want to make the changes.  */
    snapshotId: Option[String] = None
)
