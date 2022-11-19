package spotify4s.v1.model

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

case class ExplicitContent(
    filterEnabled: Boolean,
    filterLocked: Boolean
)

case class ExternalUrls(
    spotify: String
)

case class Followers(
    href: String,
    total: Int
)

case class Images(
    url: String,
    height: Int,
    width: Int
)
