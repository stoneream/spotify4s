package spotify4s.v1

import akka.actor.ActorSystem
import akka.stream.SystemMaterializer
import org.scalatest.funsuite.AnyFunSuite
import play.api.libs.ws.ahc.StandaloneAhcWSClient
import spotify4s.v1.SpotifyClientV1.SpotifyClientOpt
import spotify4s.{SpotifyClient, SpotifyOAuth2Client}

import scala.concurrent.duration.DurationInt

class SpotifyClientV1Suite extends AnyFunSuite {
  val timeout = 30.seconds

  test("/track") {
    implicit val system = ActorSystem()
    implicit val materializer = SystemMaterializer(system).materializer

    val ws = StandaloneAhcWSClient()

    val oauthClient = new SpotifyOAuth2Client("client-id-here", "client-secret-here")(ws, timeout)

    // client credential flow
    val accessTokenRequestResponse = oauthClient.accessTokenRequest
    val accessToken = (accessTokenRequestResponse \ "access_token").asOpt[String].getOrElse(fail())

    val client = new SpotifyClient(accessToken)(ws, timeout)
    val track = client.track("3doNZXJKsQpIj3RaatDwpS")

    val trackName = (track \ "name").asOpt[String].getOrElse(fail)
    val artistNames = (track \ "artists" \\ "name").flatMap(_.asOpt[String])

    assert(trackName == "エイリアンズ - 2018 Remaster")
    assert(artistNames.contains("KIRINJI"))
    system.terminate()
  }

}
