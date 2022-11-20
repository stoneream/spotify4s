package spotify4s.model

case class AccessTokenRequestResponse(
    accessToken: String,
    tokenType: String,
    scope: String,
    expiresIn: Int,
    refreshToken: Option[String]
)
