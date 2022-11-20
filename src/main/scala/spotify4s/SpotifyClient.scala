package spotify4s

import play.api.libs.json.JsValue
import play.api.libs.ws.JsonBodyReadables._
import play.api.libs.ws.StandaloneWSClient

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class SpotifyClient(accessToken: String)(ws: StandaloneWSClient, timeout: Duration) {
  val protocol = "https"
  val host = "api.spotify.com"

  def get(endpoint: String): JsValue = {
    // todo query parameter

    val headers = (
      "Authorization",
      s"Bearer $accessToken"
    )

    val request = ws.url(s"$protocol://$host$endpoint").addHttpHeaders(headers).get()

    val response = Await.result(request, timeout)

    // todo 200以外が帰ってきたときのハンドリング
    response.body[JsValue]
  }
}
