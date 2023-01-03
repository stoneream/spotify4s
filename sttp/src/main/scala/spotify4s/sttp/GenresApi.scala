package spotify4s.sttp

import io.circe.generic.extras.Configuration
import io.circe.generic.extras.auto._
import spotify4s.v1.model.ErrorObject
import spotify4s.v1.response.GetRecommendationGenres200Response
import sttp.client3._
import sttp.client3.circe._

object GenresApi {

  private implicit val jsonConfig: Configuration = Configuration.default.withSnakeCaseMemberNames

  private val baseUri = uri"https://api.spotify.com/v1"

  /**
   * Get Available Genre Seeds
   * Retrieve a list of available genres seed parameter values for [recommendations](/documentation/web-api/reference/#/operations/get-recommendations).
   */
  def getRecommendationGenres()(client: SttpBackend[Identity, Any]) = {

    val requestUrl = baseUri.addPath("/recommendations/available-genre-seeds")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetRecommendationGenres200Response]).send(client).body
  }

}
