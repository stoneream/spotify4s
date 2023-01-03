package spotify4s.sttp

import io.circe.generic.extras.auto._
import spotify4s.v1.model.{CategoryObject, ErrorObject, PagingPlaylistObject}
import spotify4s.v1.response.GetCategories200Response
import sttp.client3._
import sttp.client3.circe._

object CategoriesApi {

  private val baseUri = uri"https://api.spotify.com/v1"

  /**
   * Get Category's Playlists
   * Get a list of Spotify playlists tagged with a particular category.
   */
  def getACategoriesPlaylists(categoryId: String, country: Option[String], limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams =
      Map.empty[String, String] ++ country.map("country" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map("offset" -> _.toString)

    val requestUrl = baseUri.addPath("/browse/categories/playlists").addPath(s"/${categoryId}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, PagingPlaylistObject]).send(client).body
  }

  /**
   * Get Single Browse Category
   * Get a single category used to tag items in Spotify (on, for example, the Spotify player’s “Browse” tab).
   */
  def getACategory(categoryId: String, country: Option[String], locale: Option[String])(client: SttpBackend[Identity, Any]) = {

    val queryParams = Map.empty[String, String] ++ country.map("country" -> _.toString) ++ locale.map("locale" -> _.toString)

    val requestUrl = baseUri.addPath("/browse/categories").addPath(s"/${categoryId}").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, CategoryObject]).send(client).body
  }

  /**
   * Get Several Browse Categories
   * Get a list of categories used to tag items in Spotify (on, for example, the Spotify player’s “Browse” tab).
   */
  def getCategories(country: Option[String], locale: Option[String], limit: Option[Int], offset: Option[Int])(client: SttpBackend[Identity, Any]) = {

    val queryParams =
      Map.empty[String, String] ++ country.map("country" -> _.toString) ++ locale.map("locale" -> _.toString) ++ limit.map("limit" -> _.toString) ++ offset.map(
        "offset" -> _.toString
      )

    val requestUrl = baseUri.addPath("/browse/categories").addParams(queryParams)

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetCategories200Response]).send(client).body
  }

}
