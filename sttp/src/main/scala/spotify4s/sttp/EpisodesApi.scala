package spotify4s.sttp

import io.circe.generic.extras.Configuration
import io.circe.generic.extras.auto._
import spotify4s.v1.model.{EpisodeObject, ErrorObject, PagingObject}
import spotify4s.v1.request.{RemoveEpisodesUserRequest, SaveEpisodesUserRequest}
import spotify4s.v1.response.GetMultipleEpisodes200Response
import sttp.client3._
import sttp.client3.circe._

object EpisodesApi {
  private implicit val jsonConfig: Configuration = Configuration.default.withSnakeCaseMemberNames

  private val baseUri = uri"https://api.spotify.com/v1"

  /**
   * Check User's Saved Episodes
   * Check if one or more episodes is already saved in the current Spotify user's 'Your Episodes' library.
   * This API endpoint is in __beta__ and could change without warning.
   * Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer)..
   */
  def checkUsersSavedEpisodes(ids: String)(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/episodes/contains").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, List[Boolean]]).send(client).body
  }

  /**
   * Get Show Episodes
   * Get Spotify catalog information about an show’s episodes.
   * Optional parameters can be used to limit the number of episodes returned.
   */
  def getAShowsEpisodes(id: String, market: Option[String], limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/shows/episodes").addPath(s"/${id}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Get Episode
   * Get Spotify catalog information for a single episode identified by its unique Spotify ID.
   */
  def getAnEpisode(id: String, market: Option[String])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _.toString)

    val requestUrl = baseUri.addPath("/episodes").addPath(s"/${id}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, EpisodeObject]).send(client).body
  }

  /**
   * Get Several Episodes
   * Get Spotify catalog information for several episodes based on their Spotify IDs.
   */
  def getMultipleEpisodes(ids: String, market: Option[String])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString) ++ market.map("market" -> _.toString)

    val requestUrl = baseUri.addPath("/episodes").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetMultipleEpisodes200Response]).send(client).body
  }

  /**
   * Get User's Saved Episodes
   * Get a list of the episodes saved in the current Spotify user's library.
   * This API endpoint is in __beta__ and could change without warning.
   * Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer).
   */
  def getUsersSavedEpisodes(market: Option[String], limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ market.map("market" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/me/episodes").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingObject]).send(client).body
  }

  /**
   * Remove User's Saved Episodes
   * Remove one or more episodes from the current user's library.
   * This API endpoint is in __beta__ and could change without warning.
   * Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer).
   */
  def removeEpisodesUser(ids: String, requestBody: Option[RemoveEpisodesUserRequest])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/episodes").addParams(queryParams)

    basicRequest.delete(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

  /**
   * Save Episodes for Current User
   * Save one or more episodes to the current user's library.
   * This API endpoint is in __beta__ and could change without warning.
   * Please share any feedback that you have, or issues that you discover, in our [developer community forum](https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer).
   */
  def saveEpisodesUser(ids: String, requestBody: Option[SaveEpisodesUserRequest])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] + ("ids" -> ids.toString)

    val requestUrl = baseUri.addPath("/me/episodes").addParams(queryParams)

    basicRequest.put(requestUrl).body(requestBody).response(asJsonEither[ErrorObject, Unit]).send(client).body
  }

}