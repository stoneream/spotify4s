package spotify4s.v1.model

case class CategoryObject(
    /* A link to the Web API endpoint returning full details of the category.  */
    href: String,
    /* The category icon, in various sizes.  */
    icons: List[ImageObject],
    /* The [Spotify category ID](/documentation/web-api/#spotify-uris-and-ids) of the category.  */
    id: String,
    /* The name of the category.  */
    name: String
)
