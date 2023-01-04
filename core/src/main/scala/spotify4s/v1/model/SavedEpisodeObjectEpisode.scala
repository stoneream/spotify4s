package spotify4s.v1.model

case class SavedEpisodeObjectEpisode(
    /* A URL to a 30 second preview (MP3 format) of the episode. `null` if not available.  */
    audioPreviewUrl: String,
    /* A description of the episode. HTML tags are stripped away from this field, use `html_description` field in case HTML tags are needed.  */
    description: String,
    /* A description of the episode. This field may contain HTML tags.  */
    htmlDescription: String,
    /* The episode length in milliseconds.  */
    durationMs: Int,
    /* Whether or not the episode has explicit content (true = yes it does; false = no it does not OR unknown).  */
    explicit: Boolean,
    externalUrls: EpisodeBaseExternalUrls,
    /* A link to the Web API endpoint providing full details of the episode.  */
    href: String,
    /* The [Spotify ID](/documentation/web-api/#spotify-uris-and-ids) for the episode.  */
    id: String,
    /* The cover art for the episode in various sizes, widest first.  */
    images: List[ImageObject],
    /* True if the episode is hosted outside of Spotify's CDN.  */
    isExternallyHosted: Boolean,
    /* True if the episode is playable in the given market. Otherwise false.  */
    isPlayable: Boolean,
    /* The language used in the episode, identified by a [ISO 639](https://en.wikipedia.org/wiki/ISO_639) code. This field is deprecated and might be removed in the future. Please use the `languages` field instead.  */
    language: Option[String] = None,
    /* A list of the languages used in the episode, identified by their [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639) code.  */
    languages: List[String],
    /* The name of the episode.  */
    name: String,
    /* The date the episode was first released, for example `\"1981-12-15\"`. Depending on the precision, it might be shown as `\"1981\"` or `\"1981-12\"`.  */
    releaseDate: String,
    /* The precision with which `release_date` value is known.  */
    releaseDatePrecision: String,
    resumePoint: EpisodeBaseResumePoint,
    /* The object type.  */
    `type`: String,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the episode.  */
    uri: String,
    restrictions: Option[EpisodeBaseRestrictions] = None,
    show: SimplifiedShowObject
)
