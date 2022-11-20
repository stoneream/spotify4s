package spotify4s.v1.model

import play.api.libs.json.{Json, JsonConfiguration, JsonNaming, OFormat}

// todo 定義するのが面倒なのでどうにかしたい

object Formatter {
  private val configuredJson = Json.configured(JsonConfiguration(naming = JsonNaming.SnakeCase))

  object MeFormatter {
    implicit lazy val me: OFormat[Me] = configuredJson.format[Me]
    implicit lazy val explicitContent: OFormat[ExplicitContent] = configuredJson.format[ExplicitContent]
    implicit lazy val externalUrls: OFormat[ExternalUrls] = configuredJson.format[ExternalUrls]
    implicit lazy val followers: OFormat[Followers] = configuredJson.format[Followers]
    implicit lazy val images: OFormat[Images] = configuredJson.format[Images]
  }
}
