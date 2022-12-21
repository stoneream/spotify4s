package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class EpisodeObjectAllOf (
  show: SimplifiedShowObject
)

object EpisodeObjectAllOf {
  implicit val format: Format[EpisodeObjectAllOf] = Json.format[EpisodeObjectAllOf]

}
