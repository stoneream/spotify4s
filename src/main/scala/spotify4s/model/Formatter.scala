package spotify4s.model

import play.api.libs.json.{Json, JsonConfiguration, JsonNaming}

object Formatter {
  private val configuredJson = Json.configured(JsonConfiguration(naming = JsonNaming.SnakeCase))

  object AccessTokenRequestResponseFormatter {
    val accessTokenRequestResponse = configuredJson.format[AccessTokenRequestResponse]
  }
}
