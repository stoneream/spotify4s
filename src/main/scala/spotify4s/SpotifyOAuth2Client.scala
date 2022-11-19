package spotify4s

import play.api.libs.json.JsValue
import play.api.libs.ws.DefaultBodyWritables.writeableOf_urlEncodedForm
import play.api.libs.ws.JsonBodyReadables.readableAsJson
import play.api.libs.ws.{StandaloneWSClient, WSAuthScheme}
import spotify4s.model.AccessTokenRequestResponse

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class SpotifyOAuth2Client(clientId: String, clientSecret: String)(ws: StandaloneWSClient, timeout: Duration) {
  val protocol = "https"
  val host = "accounts.spotify.com"
  val tokenEndpoint = "/api/token"

  /**
   * Access token request
   * https://developer.spotify.com/documentation/general/guides/authorization/code-flow/
   */
  def accessTokenRequest(code: String, redirectUri: String): Option[AccessTokenRequestResponse] = {
    val url = s"$protocol://$host$tokenEndpoint"
    val body = Map(
      "grant_type" -> Seq("authorization_code"),
      "code" -> Seq(code),
      "redirect_uri" -> Seq(redirectUri)
    )
    val request = ws.url(url).withAuth(clientId, clientSecret, WSAuthScheme.BASIC).post(body)

    val response = Await.result(request, timeout)

    response.body[JsValue].validateOpt(AccessTokenRequestResponse.format).get
  }

  /**
   * Access token request (PKCE)
   * https://developer.spotify.com/documentation/general/guides/authorization/code-flow/
   */
  def accessTokenRequest(code: String, redirectUri: String, codeVerifier: String) = {
    ???
  }

  /**
   * Access token request by refresh token
   * https://developer.spotify.com/documentation/general/guides/authorization/code-flow/
   */
  def accessTokenRequestByRefreshToken(refreshToken: String) = {
    ???
  }
}
