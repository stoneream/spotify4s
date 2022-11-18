package spotify4s.v1.model

import com.github.tototoshi.play.json.JsonNaming
import play.api.libs.json.Json

case class Me(
    country: String,
    display_name: String,
    email: String,
    explicit_content: ExplicitContent,
    external_urls: ExternalUrls,
    followers: Followers,
    href: String,
    id: String,
    images: Seq[Images],
    product: String,
    uri: String
)

object Me {
  val format = JsonNaming.snakecase(Json.format[Me])
}

sealed case class ExplicitContent(
    filter_enabled: Boolean,
    filter_locked: Boolean
)

sealed case class ExternalUrls(
    spotify: String
)

sealed case class Followers(
    href: String,
    total: Int
)

sealed case class Images(
    url: String,
    height: Int,
    width: Int
)
