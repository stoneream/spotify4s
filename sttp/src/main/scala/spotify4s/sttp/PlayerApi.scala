package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model.{CurrentlyPlayingContextObject, CursorPagingObject, ErrorObject, QueueObject}
import spotify4s.v1.response.GetAUsersAvailableDevices200Response
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

object PlayerApi {

  private val baseUri: Uri = uri"https://api.spotify.com/v1"

  /**
   * Add Item to Playback Queue
   * Add an item to the end of the user's current playback queue.
   */
  def addToQueue(uri: String, deviceId: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],Unit] = {

    val queryParams = Map.empty[String, String] + ("uri" -> uri) ++ deviceId.map("deviceId" -> _)

    val requestUrl = baseUri.addPath("/me/player/queue").addParams(queryParams)

    basicRequest.post(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Get Available Devices
   * Get information about a user’s available devices.
   */
  def getAUsersAvailableDevices()(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],GetAUsersAvailableDevices200Response] = {

    val requestUrl = baseUri.addPath("/me/player/devices")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetAUsersAvailableDevices200Response]).send(client).body
  }

  /**
   * Get Playback State
   * Get information about the user’s current playback state, including track or episode, progress, and active device.
   */
  def getInformationAboutTheUsersCurrentPlayback(market: Option[String], additionalTypes: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],CurrentlyPlayingContextObject] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) ++ additionalTypes.map("additionalTypes" -> _)

    val requestUrl = baseUri.addPath("/me/player").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, CurrentlyPlayingContextObject]).send(client).body
  }

  /**
   * Get the User's Queue
   * Get the list of objects that make up the user's queue.
   */
  def getQueue()(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],QueueObject] = {

    val requestUrl = baseUri.addPath("/me/player/queue")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, QueueObject]).send(client).body
  }

  /**
   * Get Recently Played Tracks
   * Get tracks from the current user's recently played tracks. _**Note**: Currently doesn't support podcast episodes._
   */
  def getRecentlyPlayed(limit: Option[Int], after: Option[Int], before: Option[Int])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],CursorPagingObject] = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ after.map("after" -> _.toString) ++ before.map("before" -> _.toString)

    val requestUrl = baseUri.addPath("/me/player/recently-played").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, CursorPagingObject]).send(client).body
  }

  /**
   * Get Currently Playing Track
   * Get the object currently being played on the user's Spotify account.
   */
  def getTheUsersCurrentlyPlayingTrack(market: Option[String], additionalTypes: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],CurrentlyPlayingContextObject] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) ++ additionalTypes.map("additionalTypes" -> _)

    val requestUrl = baseUri.addPath("/me/player/currently-playing").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, CurrentlyPlayingContextObject]).send(client).body
  }

  /**
   * Pause Playback
   * Pause playback on the user's account.
   */
  def pauseAUsersPlayback(deviceId: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],Unit] = {

    val queryParams = Map.empty[String, String] ++ deviceId.map("deviceId" -> _)

    val requestUrl = baseUri.addPath("/me/player/pause").addParams(queryParams)

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Seek To Position
   * Seeks to the given position in the user’s currently playing track.
   */
  def seekToPositionInCurrentlyPlayingTrack(positionMs: Int, deviceId: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],Unit] = {

    val queryParams = Map.empty[String, String] + ("positionMs" -> positionMs.toString) ++ deviceId.map("deviceId" -> _)

    val requestUrl = baseUri.addPath("/me/player/seek").addParams(queryParams)

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Set Repeat Mode
   * Set the repeat mode for the user's playback. Options are repeat-track, repeat-context, and off.
   */
  def setRepeatModeOnUsersPlayback(state: String, deviceId: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],Unit] = {

    val queryParams = Map.empty[String, String] + ("state" -> state) ++ deviceId.map("deviceId" -> _)

    val requestUrl = baseUri.addPath("/me/player/repeat").addParams(queryParams)

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Set Playback Volume
   * Set the volume for the user’s current playback device.
   */
  def setVolumeForUsersPlayback(volumePercent: Int, deviceId: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],Unit] = {

    val queryParams = Map.empty[String, String] + ("volumePercent" -> volumePercent.toString) ++ deviceId.map("deviceId" -> _)

    val requestUrl = baseUri.addPath("/me/player/volume").addParams(queryParams)

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Skip To Next
   * Skips to next track in the user’s queue.
   */
  def skipUsersPlaybackToNextTrack(deviceId: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],Unit] = {

    val queryParams = Map.empty[String, String] ++ deviceId.map("deviceId" -> _)

    val requestUrl = baseUri.addPath("/me/player/next").addParams(queryParams)

    basicRequest.post(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Skip To Previous
   * Skips to previous track in the user’s queue.
   */
  def skipUsersPlaybackToPreviousTrack(deviceId: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],Unit] = {

    val queryParams = Map.empty[String, String] ++ deviceId.map("deviceId" -> _)

    val requestUrl = baseUri.addPath("/me/player/previous").addParams(queryParams)

    basicRequest.post(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Start/Resume Playback
   * Start a new context or resume current playback on the user's active device.
   * todo fix
   *
   *    def startAUsersPlayback(deviceId: Option[String], requestBody: Option[Map[String, oas_any_type_not_mapped]])(client: SttpBackend[Identity, Any]) = {
   *
   *        val queryParams = Map.empty[String, String] ++ deviceId.map("deviceId" -> _.toString)
   *
   *        val requestUrl = baseUri.addPath("/me/player/play").addParams(queryParams)
   *
   *        basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
   *    }
   */

  /**
   * Toggle Playback Shuffle
   * Toggle shuffle on or off for user’s playback.
   */
  def toggleShuffleForUsersPlayback(state: Boolean, deviceId: Option[String])(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject,circe.Error],Unit] = {

    val queryParams = Map.empty[String, String] + ("state" -> state.toString) ++ deviceId.map("deviceId" -> _)

    val requestUrl = baseUri.addPath("/me/player/shuffle").addParams(queryParams)

    basicRequest.put(requestUrl).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Transfer Playback
   * Transfer playback to a new device and determine if it should start playing.
   * todo fix
   *
   *    def transferAUsersPlayback(requestBody: Option[Map[String, oas_any_type_not_mapped]])(client: SttpBackend[Identity, Any]) = {
   *
   *        val requestUrl = baseUri.addPath("/me/player")
   *
   *        basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
   *    }
   */

}
