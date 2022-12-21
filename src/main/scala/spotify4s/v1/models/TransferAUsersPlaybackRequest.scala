package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class TransferAUsersPlaybackRequest (
  /* A JSON array containing the ID of the device on which playback should be started/transferred.<br>For example:`{device_ids:[\"74ASZWbe4lXaubB36ztrGX\"]}`<br>_**Note**: Although an array is accepted, only a single device_id is currently supported. Supplying more than one will return `400 Bad Request`_  */
  deviceIds: List[String],
  /* **true**: ensure playback happens on new device.<br>**false** or not provided: keep the current playback state.  */
//  play: Option[Map[String, AnyType]] = None
)

object TransferAUsersPlaybackRequest {
  implicit val format: Format[TransferAUsersPlaybackRequest] = Json.format[TransferAUsersPlaybackRequest]

}
