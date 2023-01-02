package spotify4s.v1.model

case class SimplifiedShowObject(
    /* A list of the countries in which the show can be played, identified by their [ISO 3166-1 alpha-2](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code.  */
    availableMarkets: List[String],
    /* The copyright statements of the show.  */
    copyrights: List[CopyrightObject],
    /* A description of the show. HTML tags are stripped away from this field, use `html_description` field in case HTML tags are needed.  */
    description: String,
    /* A description of the show. This field may contain HTML tags.  */
    htmlDescription: String,
    /* Whether or not the show has explicit content (true = yes it does; false = no it does not OR unknown).  */
    explicit: Boolean,
    externalUrls: ShowBaseExternalUrls,
    /* A link to the Web API endpoint providing full details of the show.  */
    href: String,
    /* The [Spotify ID](/documentation/web-api/#spotify-uris-and-ids) for the show.  */
    id: String,
    /* The cover art for the show in various sizes, widest first.  */
    images: List[ImageObject],
    /* True if all of the shows episodes are hosted outside of Spotify's CDN. This field might be `null` in some cases.  */
    isExternallyHosted: Boolean,
    /* A list of the languages used in the show, identified by their [ISO 639](https://en.wikipedia.org/wiki/ISO_639) code.  */
    languages: List[String],
    /* The media type of the show.  */
    mediaType: String,
    /* The name of the episode.  */
    name: String,
    /* The publisher of the show.  */
    publisher: String,
    /* The object type.  */
    `type`: SimplifiedShowObjectEnums.`Type`,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the show.  */
    uri: String
)

object SimplifiedShowObjectEnums {

  type `Type` = `Type`.Value
  object `Type` extends Enumeration {
    val Show = Value("show")
  }

}
