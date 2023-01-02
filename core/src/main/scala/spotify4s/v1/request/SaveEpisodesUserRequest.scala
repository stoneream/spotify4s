package spotify4s.v1.request

case class SaveEpisodesUserRequest(
    /* A JSON array of the [Spotify IDs](/documentation/web-api/#spotify-uris-and-ids). <br>A maximum of 50 items can be specified in one request. _**Note**: if the `ids` parameter is present in the query string, any IDs listed here in the body will be ignored._  */
    ids: Option[List[String]] = None
)
