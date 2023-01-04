package spotify4s.v1.circe

import io.circe._
import io.circe.syntax._
import spotify4s.v1.model.SimplifiedAlbumObject.{AlbumGroup, AlbumType, ReleaseDatePrecision, `Type`}

object SimplifiedAlbumObjectDerivation {

  object AlbumTypeDerivation {
    implicit val encoder: Encoder[AlbumType] = Encoder.instance(_.value.asJson)
    implicit val decoder: Decoder[AlbumType] = Decoder.instance(c => for { v <- c.as[String] } yield AlbumType.fromString(v))
  }

  object ReleaseDatePrecisionDerivation {
    implicit val encoder: Encoder[ReleaseDatePrecision] = Encoder.instance(_.value.asJson)
    implicit val decoder: Decoder[ReleaseDatePrecision] = Decoder.instance(c => for { v <- c.as[String] } yield ReleaseDatePrecision.fromString(v))
  }

  object TypeDerivation {
    implicit val encoder: Encoder[`Type`] = Encoder.instance(_.value.asJson)
    implicit val decoder: Decoder[`Type`] = Decoder.instance(c => for { v <- c.as[String] } yield `Type`.fromString(v))
  }

  object AlbumGroupDerivation {
    implicit val encoder: Encoder[AlbumGroup] = Encoder.instance(_.value.asJson)
    implicit val decoder: Decoder[AlbumGroup] = Decoder.instance(c => for { v <- c.as[String] } yield AlbumGroup.fromString(v))
  }

}
