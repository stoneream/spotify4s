package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class GetAUsersAvailableDevices200Response (
  devices: List[DeviceObject]
)

object GetAUsersAvailableDevices200Response {
  implicit val format: Format[GetAUsersAvailableDevices200Response] = Json.format[GetAUsersAvailableDevices200Response]

}
