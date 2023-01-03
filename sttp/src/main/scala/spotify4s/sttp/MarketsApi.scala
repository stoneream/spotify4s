package spotify4s.sttp

import io.circe.generic.extras.auto._
import spotify4s.v1.model.ErrorObject
import spotify4s.v1.response.GetAvailableMarkets200Response
import sttp.client3._
import sttp.client3.circe._

object MarketsApi {

  private val baseUri = uri"https://api.spotify.com/v1"

  /**
   * Get Available Markets
   * Get the list of markets where Spotify is available.
   */
  def getAvailableMarkets()(client: SttpBackend[Identity, Any]) = {

    val requestUrl = baseUri.addPath("/markets")

    basicRequest.get(requestUrl).response(asJsonEither[ErrorObject, GetAvailableMarkets200Response]).send(client).body
  }

}
