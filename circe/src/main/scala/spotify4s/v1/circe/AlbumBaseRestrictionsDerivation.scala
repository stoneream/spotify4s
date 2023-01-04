package spotify4s.v1.circe

import io.circe._
import io.circe.syntax._
import spotify4s.v1.model.AlbumBaseRestrictions.Reason

object AlbumBaseRestrictionsDerivation {

  object ReasonDerivation {
    implicit val encoder: Encoder[Reason] = Encoder.instance(_.value.asJson)
    implicit val decoder: Decoder[Reason] = Decoder.instance(c => for { v <- c.as[String] } yield Reason.fromString(v))
  }

}
