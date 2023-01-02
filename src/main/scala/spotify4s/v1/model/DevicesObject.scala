package spotify4s.v1.model

case class DevicesObject(
    /* A list of 0..n Device objects */
    devices: Option[List[DeviceObject]] = None
)
