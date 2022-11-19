package spotify4s

import play.api.libs.json.{JsValue, Json, JsonConfiguration, JsonNaming}
import play.api.libs.ws.JsonBodyReadables._
import play.api.libs.ws.StandaloneWSClient

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class SpotifyClient(accessToken: String)(ws: StandaloneWSClient, timeout: Duration) {
  val protocol = "https"
  val host = "api.spotify.com"

  def get[T](path: String): Option[T] = {
    // todo query parameter
    val request = ws.url(s"$protocol://$host$path").get()

    val response = Await.result(request, timeout)

    val config = JsonConfiguration(naming = JsonNaming.SnakeCase)
    val formatter = Json.configured(config).reads[T]

    response.body[JsValue].validateOpt(formatter).get
  }
}
