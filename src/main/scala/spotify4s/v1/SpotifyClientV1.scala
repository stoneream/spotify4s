package spotify4s

import spotify4s.v1.model.Me

object SpotifyClientV1 {
  implicit class SpotifyClientV1(client: SpotifyClient) {

    /**
     * Get Current User's Profile
     * https://developer.spotify.com/documentation/web-api/reference/#/operations/get-current-users-profile
     */
    def me: Option[Me] = {
      client.get("/me")(Me.format)
    }
  }
}
