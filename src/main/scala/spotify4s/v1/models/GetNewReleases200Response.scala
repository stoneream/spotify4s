package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetNewReleases200Response (
  albums: PagingObject
)

object GetNewReleases200Response {
  implicit val format: Format[GetNewReleases200Response] = Json.format[GetNewReleases200Response]

}
