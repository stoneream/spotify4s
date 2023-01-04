package spotify4s.v1.request

case class TransferAUsersPlaybackRequest(
    /* todo fix
  /* A JSON array containing the ID of the device on which playback should be started/transferred.<br>For example:`{device_ids:[\"74ASZWbe4lXaubB36ztrGX\"]}`<br>_**Note**: Although an array is accepted, only a single device_id is currently supported. Supplying more than one will return `400 Bad Request`_  */
  deviceIds: List[String],
  /* **true**: ensure playback happens on new device.<br>**false** or not provided: keep the current playback state.  */
  play: Option[Map[String, oas_any_type_not_mapped]] = None
     */
)
