package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class DevicesObject (
  /* A list of 0..n Device objects */
  devices: Option[List[DeviceObject]] = None
)

object DevicesObject {
  implicit val format: Format[DevicesObject] = Json.format[DevicesObject]

}
