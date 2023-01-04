package spotify4s.v1.model

case class AudiobookBase(
    /* The author(s) for the audiobook.  */
    authors: List[AuthorObject],
    /* A list of the countries in which the audiobook can be played, identified by their [ISO 3166-1 alpha-2](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code.  */
    availableMarkets: List[String],
    /* The copyright statements of the audiobook.  */
    copyrights: List[CopyrightObject],
    /* A description of the audiobook. HTML tags are stripped away from this field, use `html_description` field in case HTML tags are needed.  */
    description: String,
    /* A description of the audiobook. This field may contain HTML tags.  */
    htmlDescription: String,
    /* Whether or not the audiobook has explicit content (true = yes it does; false = no it does not OR unknown).  */
    explicit: Boolean,
    externalUrls: AudiobookBaseExternalUrls,
    /* A link to the Web API endpoint providing full details of the audiobook.  */
    href: String,
    /* The [Spotify ID](/documentation/web-api/#spotify-uris-and-ids) for the audiobook.  */
    id: String,
    /* The cover art for the audiobook in various sizes, widest first.  */
    images: List[ImageObject],
    /* A list of the languages used in the audiobook, identified by their [ISO 639](https://en.wikipedia.org/wiki/ISO_639) code.  */
    languages: List[String],
    /* The media type of the audiobook.  */
    mediaType: String,
    /* The name of the audiobook.  */
    name: String,
    narrators: NarratorObject,
    /* The publisher of the audiobook.  */
    publisher: String,
    /* The object type.  */
    `type`: String,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the audiobook.  */
    uri: String,
    /* The number of chapters in this audiobook.  */
    totalChapters: Int
)
