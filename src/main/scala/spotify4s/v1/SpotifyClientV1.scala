package spotify4s.v1

import play.api.libs.json.JsValue
import spotify4s.SpotifyClient

object SpotifyClientV1 {
  implicit class SpotifyClientOpt(client: SpotifyClient) {

    /**
     * Get Current User's Profile
     * https://developer.spotify.com/documentation/web-api/reference/#/operations/get-current-users-profile
     */
    def me: JsValue = {
      client.get("/v1/me")
    }

    /**
     * Get Track
     * https://developer.spotify.com/documentation/web-api/reference/#/operations/get-track
     */
    def track(id: String): JsValue = {
      client.get(s"/v1/tracks/$id")
    }
  }
}
