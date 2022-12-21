package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetAvailableMarkets200Response (
  markets: Option[List[String]] = None
)

object GetAvailableMarkets200Response {
  implicit val format: Format[GetAvailableMarkets200Response] = Json.format[GetAvailableMarkets200Response]

}
