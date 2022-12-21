package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetSeveralChapters200Response (
  chapters: List[ChapterObject]
)

object GetSeveralChapters200Response {
  implicit val format: Format[GetSeveralChapters200Response] = Json.format[GetSeveralChapters200Response]

}
