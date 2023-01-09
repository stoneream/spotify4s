package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model._
import spotify4s.v1.request.{AddTracksToPlaylistRequest, RemoveTracksPlaylistRequest, RemoveTracksUserRequest, SaveTracksUserRequest}
import spotify4s.v1.response.{GetAnArtistsTopTracks200Response, GetSeveralAudioFeatures200Response, ReorderOrReplacePlaylistsTracks200Response}
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

case class TracksApi(baseUri: Uri = uri"https://api.spotify.com/v1") {

  /**
   * Add Items to Playlist
   * Add one or more items to a user's playlist.
   */
  def addTracksToPlaylist(playlistId: String, position: Option[Int] = None, uris: Option[String] = None, requestBody: Option[AddTracksToPlaylistRequest])(
      accessToken: String
  )(
      client: SttpBackend[Identity, Any]
  ): Either[ResponseException[ErrorObject, circe.Error], ReorderOrReplacePlaylistsTracks200Response] = {

    val queryParams = Map.empty[String, String] ++ position.map("position" -> _.toString) ++ uris.map("uris" -> _)

    val requestUrl = baseUri.addPath("playlists/tracks").addPath(s"/$playlistId").addParams(queryParams)

    basicRequest
      .post(requestUrl)
      .body(requestBody)
      .response(asJsonEither[ErrorObject, ReorderOrReplacePlaylistsTracks200Response])
      .auth
      .bearer(accessToken)
      .send(client)
      .body
  }

  /**
   * Check User's Saved Tracks
   * Check if one or more tracks is already saved in the current Spotify user's 'Your Music' library.
   */
  def checkUsersSavedTracks(
      ids: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], List[Boolean]] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("me/tracks/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Album Tracks
   * Get Spotify catalog information about an album’s tracks. Optional parameters can be used to limit the number of tracks returned.
   */
  def getAnAlbumsTracks(id: String, market: Option[String] = None, limit: Option[Int] = None, offset: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingObject[SimplifiedTrackObject]] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("albums").addPath(s"/$id").addPath("tracks").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject[SimplifiedTrackObject]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Track's Audio Analysis
   * Get a low-level audio analysis for a track in the Spotify catalog. The audio analysis describes the track’s structure and musical content, including rhythm, pitch, and timbre.
   */
  def getAudioAnalysis(
      id: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], AudioAnalysisObject] = {

    val requestUrl = baseUri.addPath("audio-analysis").addPath(s"/$id")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, AudioAnalysisObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Track's Audio Features
   * Get audio feature information for a single track identified by its unique Spotify ID.
   */
  def getAudioFeatures(
      id: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], AudioFeaturesObject] = {

    val requestUrl = baseUri.addPath("audio-features").addPath(s"/$id")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, AudioFeaturesObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Playlist Items
   * Get full details of the items of a playlist owned by a Spotify user.
   */
  def getPlaylistsTracks(
      playlistId: String,
      market: Option[String] = None,
      fields: Option[String] = None,
      limit: Option[Int] = None,
      offset: Option[Int] = None,
      additionalTypes: Option[String] = None
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingObject[PlaylistTrackObject]] = {

    val queryParams =
      Map.empty[String, String] ++ market.map("market" -> _) ++ fields.map("fields" -> _) ++ limit.map("limit" -> _.toString) ++ offset.map(
        "offset" -> _.toString
      ) ++ additionalTypes.map("additionalTypes" -> _)

    val requestUrl = baseUri.addPath("playlists").addPath(s"/$playlistId").addPath("tracks").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject[PlaylistTrackObject]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Recommendations
   * Recommendations are generated based on the available information for a given seed entity and matched against similar artists and tracks. If there is sufficient information about the provided seeds, a list of tracks will be returned together with pool size details.  For artists and tracks that are very new or obscure there might not be enough data to generate a list of tracks.
   */
  def getRecommendations(
      seedArtists: String,
      seedGenres: String,
      seedTracks: String,
      limit: Option[Int] = None,
      market: Option[String] = None,
      minAcousticness: Option[BigDecimal] = None,
      maxAcousticness: Option[BigDecimal] = None,
      targetAcousticness: Option[BigDecimal] = None,
      minDanceability: Option[BigDecimal] = None,
      maxDanceability: Option[BigDecimal] = None,
      targetDanceability: Option[BigDecimal] = None,
      minDurationMs: Option[Int] = None,
      maxDurationMs: Option[Int] = None,
      targetDurationMs: Option[Int] = None,
      minEnergy: Option[BigDecimal] = None,
      maxEnergy: Option[BigDecimal] = None,
      targetEnergy: Option[BigDecimal] = None,
      minInstrumentalness: Option[BigDecimal] = None,
      maxInstrumentalness: Option[BigDecimal] = None,
      targetInstrumentalness: Option[BigDecimal] = None,
      minKey: Option[Int] = None,
      maxKey: Option[Int] = None,
      targetKey: Option[Int] = None,
      minLiveness: Option[BigDecimal] = None,
      maxLiveness: Option[BigDecimal] = None,
      targetLiveness: Option[BigDecimal] = None,
      minLoudness: Option[BigDecimal] = None,
      maxLoudness: Option[BigDecimal] = None,
      targetLoudness: Option[BigDecimal] = None,
      minMode: Option[Int] = None,
      maxMode: Option[Int] = None,
      targetMode: Option[Int] = None,
      minPopularity: Option[Int] = None,
      maxPopularity: Option[Int] = None,
      targetPopularity: Option[Int] = None,
      minSpeechiness: Option[BigDecimal] = None,
      maxSpeechiness: Option[BigDecimal] = None,
      targetSpeechiness: Option[BigDecimal] = None,
      minTempo: Option[BigDecimal] = None,
      maxTempo: Option[BigDecimal] = None,
      targetTempo: Option[BigDecimal] = None,
      minTimeSignature: Option[Int] = None,
      maxTimeSignature: Option[Int] = None,
      targetTimeSignature: Option[Int] = None,
      minValence: Option[BigDecimal] = None,
      maxValence: Option[BigDecimal] = None,
      targetValence: Option[BigDecimal] = None
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], RecommendationsObject] = {

    val queryParams = Map.empty[String, String] ++ limit.map("limit" -> _.toString) ++ market.map(
      "market" -> _
    ) + ("seedArtists" -> seedArtists) + ("seedGenres" -> seedGenres) + ("seedTracks" -> seedTracks) ++ minAcousticness.map(
      "minAcousticness" -> _.toString
    ) ++ maxAcousticness.map("maxAcousticness" -> _.toString) ++ targetAcousticness.map("targetAcousticness" -> _.toString) ++ minDanceability.map(
      "minDanceability" -> _.toString
    ) ++ maxDanceability.map("maxDanceability" -> _.toString) ++ targetDanceability.map("targetDanceability" -> _.toString) ++ minDurationMs.map(
      "minDurationMs" -> _.toString
    ) ++ maxDurationMs.map("maxDurationMs" -> _.toString) ++ targetDurationMs.map("targetDurationMs" -> _.toString) ++ minEnergy.map(
      "minEnergy" -> _.toString
    ) ++ maxEnergy.map("maxEnergy" -> _.toString) ++ targetEnergy.map("targetEnergy" -> _.toString) ++ minInstrumentalness.map(
      "minInstrumentalness" -> _.toString
    ) ++ maxInstrumentalness.map("maxInstrumentalness" -> _.toString) ++ targetInstrumentalness.map("targetInstrumentalness" -> _.toString) ++ minKey.map(
      "minKey" -> _.toString
    ) ++ maxKey.map("maxKey" -> _.toString) ++ targetKey.map("targetKey" -> _.toString) ++ minLiveness.map("minLiveness" -> _.toString) ++ maxLiveness.map(
      "maxLiveness" -> _.toString
    ) ++ targetLiveness.map("targetLiveness" -> _.toString) ++ minLoudness.map("minLoudness" -> _.toString) ++ maxLoudness.map(
      "maxLoudness" -> _.toString
    ) ++ targetLoudness.map("targetLoudness" -> _.toString) ++ minMode.map("minMode" -> _.toString) ++ maxMode.map("maxMode" -> _.toString) ++ targetMode.map(
      "targetMode" -> _.toString
    ) ++ minPopularity.map("minPopularity" -> _.toString) ++ maxPopularity.map("maxPopularity" -> _.toString) ++ targetPopularity.map(
      "targetPopularity" -> _.toString
    ) ++ minSpeechiness.map("minSpeechiness" -> _.toString) ++ maxSpeechiness.map("maxSpeechiness" -> _.toString) ++ targetSpeechiness.map(
      "targetSpeechiness" -> _.toString
    ) ++ minTempo.map("minTempo" -> _.toString) ++ maxTempo.map("maxTempo" -> _.toString) ++ targetTempo.map("targetTempo" -> _.toString) ++ minTimeSignature
      .map("minTimeSignature" -> _.toString) ++ maxTimeSignature.map("maxTimeSignature" -> _.toString) ++ targetTimeSignature.map(
      "targetTimeSignature" -> _.toString
    ) ++ minValence.map("minValence" -> _.toString) ++ maxValence.map("maxValence" -> _.toString) ++ targetValence.map("targetValence" -> _.toString)

    val requestUrl = baseUri.addPath("recommendations").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, RecommendationsObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Tracks' Audio Features
   * Get audio features for multiple tracks based on their Spotify IDs.
   */
  def getSeveralAudioFeatures(
      ids: String
  )(accessToken: String)(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], GetSeveralAudioFeatures200Response] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("audio-features").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetSeveralAudioFeatures200Response]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Several Tracks
   * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
   */
  def getSeveralTracks(ids: String, market: Option[String] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], GetAnArtistsTopTracks200Response] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) + ("ids" -> ids)

    val requestUrl = baseUri.addPath("tracks").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetAnArtistsTopTracks200Response]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get Track
   * Get Spotify catalog information for a single track identified by its unique Spotify ID.
   */
  def getTrack(id: String, market: Option[String] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], TrackObject] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _)

    val requestUrl = baseUri.addPath("tracks").addPath(s"/$id").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, TrackObject]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Get User's Saved Tracks
   * Get a list of the songs saved in the current Spotify user's 'Your Music' library.
   */
  def getUsersSavedTracks(market: Option[String] = None, limit: Option[Int] = None, offset: Option[Int] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], PagingObject[SavedTrackObject]] = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("me/tracks").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject[SavedTrackObject]]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Remove Playlist Items
   * Remove one or more items from a user's playlist.
   */
  def removeTracksPlaylist(playlistId: String, removeTracksPlaylistRequest: Option[RemoveTracksPlaylistRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], ReorderOrReplacePlaylistsTracks200Response] = {

    val requestUrl = baseUri.addPath("playlists/tracks").addPath(s"/$playlistId")

    basicRequest
      .delete(requestUrl)
      .body(removeTracksPlaylistRequest)
      .response(asJsonEither[ErrorObject, ReorderOrReplacePlaylistsTracks200Response])
      .auth
      .bearer(accessToken)
      .send(client)
      .body
  }

  /**
   * Remove User's Saved Tracks
   * Remove one or more tracks from the current user's 'Your Music' library.
   */
  def removeTracksUser(ids: String, requestBody: Option[RemoveTracksUserRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("me/tracks").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

  /**
   * Update Playlist Items
   * Either reorder or replace items in a playlist depending on the request's parameters. To reorder items, include `range_start`, `insert_before`, `range_length` and `snapshot_id` in the request's body. To replace items, include `uris` as either a query parameter or in the request's body. Replacing items in a playlist will overwrite its existing items. This operation can be used for replacing or clearing items in a playlist. <br> **Note**: Replace and reorder are mutually exclusive operations which share the same endpoint, but have different parameters. These operations can't be applied together in a single request.
   * todo fix
   *  def reorderOrReplacePlaylistsTracks(playlistId: String, uris: Option[String] = None, requestBody: Option[Map[String, oas_any_type_not_mapped]])(
   *      client: SttpBackend[Identity, Any]
   *  ) = {
   *
   *    val queryParams = Map.empty[String, String] ++ uris.map("uris" -> _.toString)
   *
   *    val requestUrl = baseUri.addPath("playlists/tracks").addPath(s"/${playlistId}").addParams(queryParams)
   *
   *    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, ReorderOrReplacePlaylistsTracks200Response]).auth.bearer(accessToken).send(client).body
   *  }
   */

  /**
   * Save Tracks for Current User
   * Save one or more tracks to the current user's 'Your Music' library.
   */
  def saveTracksUser(ids: String, requestBody: Option[SaveTracksUserRequest] = None)(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], Unit] = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids)

    val requestUrl = baseUri.addPath("me/tracks").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).auth.bearer(accessToken).send(client).body
  }

}
