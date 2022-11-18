package util

import akka.actor.ActorSystem
import akka.stream.SystemMaterializer
import org.scalatest.{Args, Outcome, Status, TestSuite, TestSuiteMixin}
import play.api.libs.ws.ahc.StandaloneAhcWSClient

trait SpotifyClientTestSuiteMixin extends TestSuiteMixin { self: TestSuite =>

  abstract override def run(testName: Option[String], args: Args): Status = {
    implicit val system = ActorSystem()
    implicit val materializer = SystemMaterializer(system).materializer
    val ws = StandaloneAhcWSClient()
    try {

      super.run(testName, args)
    } finally {
      system.terminate()
    }
  }
}
