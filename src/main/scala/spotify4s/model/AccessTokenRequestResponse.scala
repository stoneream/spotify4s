package spotify4s.model

import com.github.tototoshi.play.json.JsonNaming
import play.api.libs.json.{Format, Json}

case class AccessTokenRequestResponse(
    accessToken: String,
    tokenType: String,
    scope: String,
    expiresIn: Int,
    refreshToken: Option[String]
)

object AccessTokenRequestResponse {
  val format: Format[AccessTokenRequestResponse] = JsonNaming.snakecase(Json.format[AccessTokenRequestResponse])
}
