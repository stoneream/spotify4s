package spotify4s.v1.response

import spotify4s.v1.model.DeviceObject

case class GetAUsersAvailableDevices200Response(
    devices: List[DeviceObject]
)
