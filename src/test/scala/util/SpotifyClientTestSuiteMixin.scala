package util

import akka.actor.ActorSystem
import akka.stream.SystemMaterializer
import org.scalatest._
import play.api.libs.ws.ahc.StandaloneAhcWSClient

//trait SpotifyClientTestSuiteMixin { self: TestSuite =>
//
//  type FixtureParam = StandaloneAhcWSClient
//
//  protected[this] def settingsProvider: SettingsProvider =
//    SettingsProvider.default
//
//  def fixture(ws: StandaloneAhcWSClient): Unit = {}
//
//  override def withFixture(test: OneArgTest): Outcome = {
//    implicit val system = ActorSystem()
//    implicit val materializer = SystemMaterializer(system).materializer
//    val ws = StandaloneAhcWSClient()
//    try {
//      fixture(ws)
//
//      withFixture(test)
//    } finally {
//      system.terminate()
//    }
//  }
//}

trait SpotifyClientTestSuiteMixin extends SuiteMixin { this: Suite =>
  implicit val system = ActorSystem()
  implicit val materializer = SystemMaterializer(system).materializer
  val ws = StandaloneAhcWSClient()

  abstract override def withFixture(test: NoArgAsyncTest) = {
  }
}
