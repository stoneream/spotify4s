package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetMultipleShows200Response (
  shows: List[SimplifiedShowObject]
)

object GetMultipleShows200Response {
  implicit val format: Format[GetMultipleShows200Response] = Json.format[GetMultipleShows200Response]

}
