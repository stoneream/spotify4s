package spotify4s.v1.circe

import io.circe._
import io.circe.syntax._
import spotify4s.v1.model.SectionObject.Mode

object SectionObjectDerivation {

  object ModeDerivation {
    implicit val encoder: Encoder[Mode] = Encoder.instance(_.value.asJson)
    implicit val decoder: Decoder[Mode] = Decoder.instance(c => for { v <- c.as[String] } yield Mode.fromString(v))
  }

}
