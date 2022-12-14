package spotify4s.v1.request

case class UnfollowArtistsUsersRequest(
    /* A JSON array of the artist or user [Spotify IDs](/documentation/web-api/#spotify-uris-and-ids). For example: `{ids:[\"74ASZWbe4lXaubB36ztrGX\", \"08td7MxkoHQkXnWAYD8d6Q\"]}`. A maximum of 50 IDs can be sent in one request. _**Note**: if the `ids` parameter is present in the query string, any IDs listed here in the body will be ignored._  */
    ids: Option[List[String]] = None
)
