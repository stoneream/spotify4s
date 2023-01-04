package spotify4s.v1.circe

import io.circe._
import io.circe.syntax._
import spotify4s.v1.model.PlaylistObjectOwner.`Type`

object PlaylistObjectOwnerDerivation {

  object TypeDerivation {
    implicit val encoder: Encoder[`Type`] = Encoder.instance(_.value.asJson)
    implicit val decoder: Decoder[`Type`] = Decoder.instance(c => for { v <- c.as[String] } yield `Type`.fromString(v))
  }

}
