package spotify4s

import play.api.libs.json.{Format, JsValue}
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
   * Authorization Code Flow
   *
   * https://developer.spotify.com/documentation/general/guides/authorization/code-flow/
   */
  def accessTokenRequest(code: String, redirectUri: String)(implicit format: Format[AccessTokenRequestResponse]): Option[AccessTokenRequestResponse] = {
    val url = s"$protocol://$host$tokenEndpoint"
    val body = Map(
      "grant_type" -> Seq("authorization_code"),
      "code" -> Seq(code),
      "redirect_uri" -> Seq(redirectUri)
    )
    val request = ws.url(url).withAuth(clientId, clientSecret, WSAuthScheme.BASIC).post(body)

    val response = Await.result(request, timeout)

    response.body[JsValue].validateOpt.get
  }

  /**
   * Access token request
   * Client Credentials Flow
   *
   * https://developer.spotify.com/documentation/general/guides/authorization/client-credentials/
   */
  def accessTokenRequest(implicit format: Format[AccessTokenRequestResponse]): Option[AccessTokenRequestResponse] = {
    val url = s"$protocol://$host$tokenEndpoint"
    val body = Map(
      "grant_type" -> Seq("client_credentials")
    )
    val request = ws.url(url).withAuth(clientId, clientSecret, WSAuthScheme.BASIC).post(body)

    val response = Await.result(request, timeout)

    response.body[JsValue].validateOpt.get
  }

  /**
   * Access token request (PKCE)
   * Authorization Code Flow
   *
   * https://developer.spotify.com/documentation/general/guides/authorization/code-flow/
   */
  def accessTokenRequest(code: String, redirectUri: String, codeVerifier: String) = {
    ???
  }

  /**
   * Access token request by refresh token
   * Authorization Code Flow
   *
   * https://developer.spotify.com/documentation/general/guides/authorization/code-flow/
   */
  def accessTokenRequestByRefreshToken(refreshToken: String) = {
    ???
  }
}
