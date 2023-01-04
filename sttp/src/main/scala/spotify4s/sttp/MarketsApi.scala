package spotify4s.sttp

import io.circe
import io.circe.generic.extras.auto._
import spotify4s.v1.circe.CirceConfiguration.jsonConfig
import spotify4s.v1.model.ErrorObject
import spotify4s.v1.response.GetAvailableMarkets200Response
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Uri

case class MarketsApi(baseUri: Uri = uri"https://api.spotify.com/v1") {

  /**
   * Get Available Markets
   * Get the list of markets where Spotify is available.
   */
  def getAvailableMarkets()(
      accessToken: String
  )(client: SttpBackend[Identity, Any]): Either[ResponseException[ErrorObject, circe.Error], GetAvailableMarkets200Response] = {

    val requestUrl = baseUri.addPath("/markets")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetAvailableMarkets200Response]).auth.bearer(accessToken).send(client).body
  }

}
