package spotify4s.v1

import akka.actor.ActorSystem
import akka.stream.SystemMaterializer
import org.scalatest.funsuite.AnyFunSuite
import play.api.libs.ws.ahc.StandaloneAhcWSClient
import spotify4s.SpotifyClient
import spotify4s.SpotifyClientV1.SpotifyClientV1
import util.SpotifyClientTestSuiteMixin

import scala.concurrent.duration.DurationInt

class SpotifyClientV1Suite extends AnyFunSuite with SpotifyClientTestSuiteMixin {
  val accessToken = "accessTokenHere"
  val timeout = 30.seconds

  test("/me") {
    implicit val system = ActorSystem()
    implicit val materializer = SystemMaterializer(system).materializer

    val ws = StandaloneAhcWSClient()
    val client = new SpotifyClient(accessToken)(ws, timeout)
    val response = client.me

    println(response)

    system.terminate()

  }

}
