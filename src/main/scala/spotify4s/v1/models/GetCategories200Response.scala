package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetCategories200Response (
  categories: PagingObject
)

object GetCategories200Response {
  implicit val format: Format[GetCategories200Response] = Json.format[GetCategories200Response]

}
