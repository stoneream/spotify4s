package spotify4s.v1.circe

import io.circe.generic.extras.Configuration

object CirceConfiguration {
  implicit val jsonConfig: Configuration = Configuration.default.withSnakeCaseMemberNames
}
