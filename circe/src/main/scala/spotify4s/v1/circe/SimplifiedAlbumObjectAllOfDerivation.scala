package spotify4s.v1.circe

import io.circe._
import io.circe.syntax._
import spotify4s.v1.model.SimplifiedAlbumObjectAllOf.AlbumGroup

object SimplifiedAlbumObjectAllOfDerivation {

  object AlbumGroupDerivation {
    implicit val encoder: Encoder[AlbumGroup] = Encoder.instance(_.value.asJson)
    implicit val decoder: Decoder[AlbumGroup] = Decoder.instance(c => for { v <- c.as[String] } yield AlbumGroup.fromString(v))
  }

}
