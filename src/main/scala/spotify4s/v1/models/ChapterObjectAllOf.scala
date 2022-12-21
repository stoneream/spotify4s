package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class ChapterObjectAllOf (
  audiobook: SimplifiedAudiobookObject
)

object ChapterObjectAllOf {
  implicit val format: Format[ChapterObjectAllOf] = Json.format[ChapterObjectAllOf]

}
