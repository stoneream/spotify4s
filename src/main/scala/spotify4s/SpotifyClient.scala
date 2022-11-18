package spotify4s

import play.api.libs.json.{JsValue, Reads}
import play.api.libs.ws.JsonBodyReadables._
import play.api.libs.ws.StandaloneWSClient

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class SpotifyClient(accessToken: String)(ws: StandaloneWSClient, timeout: Duration) {
  val protocol = "https"
  val host = "api.spotify.com"

  def get[R](path: String)(reads: Reads[R]): Option[R] = {

    // todo query parameter
    val request = ws.url(s"$protocol://$host$path").get()

    val response = Await.result(request, timeout)

    response.body[JsValue].validateOpt(reads).get
  }
}

