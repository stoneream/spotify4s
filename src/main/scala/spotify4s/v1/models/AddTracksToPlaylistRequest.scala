package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class AddTracksToPlaylistRequest (
  /* A JSON array of the [Spotify URIs](/documentation/web-api/#spotify-uris-and-ids) to add. For example: `{\"uris\": [\"spotify:track:4iV5W9uYEdYUVa79Axb7Rh\",\"spotify:track:1301WleyT98MSxVHPZCA6M\", \"spotify:episode:512ojhOuo1ktJprKbVcKyQ\"]}`<br>A maximum of 100 items can be added in one request. _**Note**: if the `uris` parameter is present in the query string, any URIs listed here in the body will be ignored._  */
  uris: Option[List[String]] = None,
  /* The position to insert the items, a zero-based index. For example, to insert the items in the first position: `position=0` ; to insert the items in the third position: `position=2`. If omitted, the items will be appended to the playlist. Items are added in the order they appear in the uris array. For example: `{\"uris\": [\"spotify:track:4iV5W9uYEdYUVa79Axb7Rh\",\"spotify:track:1301WleyT98MSxVHPZCA6M\"], \"position\": 3}`  */
  position: Option[Int] = None
)

object AddTracksToPlaylistRequest {
  implicit val format: Format[AddTracksToPlaylistRequest] = Json.format[AddTracksToPlaylistRequest]

}
