package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model.ErrorObject
import spotify4s.v1.response.GetRecommendationGenres200Response
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

case class GenresApi(baseUri: Uri = uri"https://api.spotify.com/v1") {

  /**
   * Get Available Genre Seeds
   * Retrieve a list of available genres seed parameter values for [recommendations](/documentation/web-api/reference/#/operations/get-recommendations).
   */
  def getRecommendationGenres()(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], GetRecommendationGenres200Response] = {

    val requestUrl = baseUri.addPath("recommendations", "available-genre-seeds")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetRecommendationGenres200Response]).auth.bearer(accessToken).send(client).body
  }

}
