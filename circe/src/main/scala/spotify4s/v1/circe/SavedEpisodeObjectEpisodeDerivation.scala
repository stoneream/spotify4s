package spotify4s.v1.circe

import io.circe._
import io.circe.syntax._
import spotify4s.v1.model.SavedEpisodeObjectEpisode.{ReleaseDatePrecision, `Type`}

object SavedEpisodeObjectEpisodeDerivation {

  object ReleaseDatePrecisionDerivation {
    implicit val encoder: Encoder[ReleaseDatePrecision] = Encoder.instance(_.value.asJson)
    implicit val decoder: Decoder[ReleaseDatePrecision] = Decoder.instance(c => for { v <- c.as[String] } yield ReleaseDatePrecision.fromString(v))
  }

  object TypeDerivation {
    implicit val encoder: Encoder[`Type`] = Encoder.instance(_.value.asJson)
    implicit val decoder: Decoder[`Type`] = Decoder.instance(c => for { v <- c.as[String] } yield `Type`.fromString(v))
  }

}
