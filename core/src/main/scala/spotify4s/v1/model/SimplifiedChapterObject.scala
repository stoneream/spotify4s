package spotify4s.v1.model

case class SimplifiedChapterObject(
    /* A URL to a 30 second preview (MP3 format) of the episode. `null` if not available.  */
    audioPreviewUrl: String,
    /* The number of the chapter  */
    chapterNumber: Int,
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
    /* True if the episode is playable in the given market. Otherwise false.  */
    isPlayable: Boolean,
    /* A list of the languages used in the episode, identified by their [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639) code.  */
    languages: List[String],
    /* The name of the episode.  */
    name: String,
    /* The date the episode was first released, for example `\"1981-12-15\"`. Depending on the precision, it might be shown as `\"1981\"` or `\"1981-12\"`.  */
    releaseDate: String,
    /* The precision with which `release_date` value is known.  */
    releaseDatePrecision: SimplifiedChapterObject.ReleaseDatePrecision,
    resumePoint: EpisodeBaseResumePoint,
    /* The object type.  */
    `type`: SimplifiedChapterObject.`Type`,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the episode.  */
    uri: String,
    restrictions: Option[EpisodeBaseRestrictions] = None
)

object SimplifiedChapterObject {

  sealed abstract class ReleaseDatePrecision(val value: String)

  object ReleaseDatePrecision {
    final case object Year extends ReleaseDatePrecision("year")
    final case object Month extends ReleaseDatePrecision("month")
    final case object Day extends ReleaseDatePrecision("day")
    final case object Unknown extends ReleaseDatePrecision("unknown")

    val values: Seq[ReleaseDatePrecision] = Seq(Year, Month, Day)

    def fromString(s: String): ReleaseDatePrecision = values.find(p => p.value == s).getOrElse(Unknown)
  }

  sealed abstract class `Type`(val value: String)

  object `Type` {
    final case object Episode extends `Type`("episode")
    final case object Unknown extends `Type`("unknown")

    val values: Seq[Episode.type] = Seq(Episode)

    def fromString(s: String): `Type` = values.find(p => p.value == s).getOrElse(Unknown)
  }

}
