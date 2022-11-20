package spotify4s

import play.api.libs.json.{Format, JsValue}
import play.api.libs.ws.JsonBodyReadables._
import play.api.libs.ws.StandaloneWSClient

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class SpotifyClient(accessToken: String)(ws: StandaloneWSClient, timeout: Duration) {
  val protocol = "https"
  val host = "api.spotify.com"

  def get[T](endpoint: String)(implicit format: Format[T]): Option[T] = {
    // todo query parameter
    val request = ws.url(s"$protocol://$host$endpoint").get()

    val response = Await.result(request, timeout)

    response.body[JsValue].validateOpt.get
  }
}
