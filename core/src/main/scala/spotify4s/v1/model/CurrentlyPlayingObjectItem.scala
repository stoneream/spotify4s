package spotify4s.v1.model

case class CurrentlyPlayingObjectItem(
    album: Option[TrackObjectAlbum] = None,
    /* The artists who performed the track. Each artist object includes a link in `href` to more detailed information about the artist.  */
    artists: Option[List[ArtistObject]] = None,
    /* A list of the countries in which the track can be played, identified by their [ISO 3166-1 alpha-2](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code.  */
    availableMarkets: Option[List[String]] = None,
    /* The disc number (usually `1` unless the album consists of more than one disc).  */
    discNumber: Option[Int] = None,
    /* The episode length in milliseconds.  */
    durationMs: Int,
    /* Whether or not the episode has explicit content (true = yes it does; false = no it does not OR unknown).  */
    explicit: Boolean,
    externalIds: Option[TrackObjectExternalIds] = None,
    externalUrls: EpisodeBaseExternalUrls,
    /* A link to the Web API endpoint providing full details of the episode.  */
    href: String,
    /* The [Spotify ID](/documentation/web-api/#spotify-uris-and-ids) for the episode.  */
    id: String,
    /* True if the episode is playable in the given market. Otherwise false.  */
    isPlayable: Boolean,
    linkedFrom: Option[TrackObjectLinkedFrom] = None,
    restrictions: Option[EpisodeBaseRestrictions] = None,
    /* The name of the episode.  */
    name: String,
    /* The popularity of the track. The value will be between 0 and 100, with 100 being the most popular.<br>The popularity of a track is a value between 0 and 100, with 100 being the most popular. The popularity is calculated by algorithm and is based, in the most part, on the total number of plays the track has had and how recent those plays are.<br>Generally speaking, songs that are being played a lot now will have a higher popularity than songs that were played a lot in the past. Duplicate tracks (e.g. the same track from a single and an album) are rated independently. Artist and album popularity is derived mathematically from track popularity. _**Note**: the popularity value may lag actual popularity by a few days: the value is not updated in real time._  */
    popularity: Option[Int] = None,
    /* A link to a 30 second preview (MP3 format) of the track. Can be `null`  */
    previewUrl: Option[String] = None,
    /* The number of the track. If an album has several discs, the track number is the number on the specified disc.  */
    trackNumber: Option[Int] = None,
    /* The object type.  */
    `type`: CurrentlyPlayingObjectItem.`Type`,
    /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the episode.  */
    uri: String,
    /* Whether or not the track is from a local file.  */
    isLocal: Option[Boolean] = None,
    /* A URL to a 30 second preview (MP3 format) of the episode. `null` if not available.  */
    audioPreviewUrl: String,
    /* A description of the episode. HTML tags are stripped away from this field, use `html_description` field in case HTML tags are needed.  */
    description: String,
    /* A description of the episode. This field may contain HTML tags.  */
    htmlDescription: String,
    /* The cover art for the episode in various sizes, widest first.  */
    images: List[ImageObject],
    /* True if the episode is hosted outside of Spotify's CDN.  */
    isExternallyHosted: Boolean,
    /* The language used in the episode, identified by a [ISO 639](https://en.wikipedia.org/wiki/ISO_639) code. This field is deprecated and might be removed in the future. Please use the `languages` field instead.  */
    language: Option[String] = None,
    /* A list of the languages used in the episode, identified by their [ISO 639-1](https://en.wikipedia.org/wiki/ISO_639) code.  */
    languages: List[String],
    /* The date the episode was first released, for example `\"1981-12-15\"`. Depending on the precision, it might be shown as `\"1981\"` or `\"1981-12\"`.  */
    releaseDate: String,
    /* The precision with which `release_date` value is known.  */
    releaseDatePrecision: CurrentlyPlayingObjectItem.ReleaseDatePrecision,
    resumePoint: EpisodeBaseResumePoint,
    show: SimplifiedShowObject
)

object CurrentlyPlayingObjectItem {

  sealed abstract class `Type`(val value: String)

  object `Type` {
    final case object Episode extends `Type`("episode")
    final case object Unknown extends `Type`("unknown")

    val values: Seq[Episode.type] = Seq(Episode)

    def fromString(s: String): `Type` = values.find(p => p.value == s).getOrElse(Unknown)
  }

  sealed abstract class ReleaseDatePrecision(val value: String)

  object ReleaseDatePrecision {
    final case object Year extends ReleaseDatePrecision("year")
    final case object Month extends ReleaseDatePrecision("month")
    final case object Day extends ReleaseDatePrecision("day")
    final case object Unknown extends ReleaseDatePrecision("unknown")

    val values: Seq[ReleaseDatePrecision] = Seq(Year, Month, Day)

    def fromString(s: String): ReleaseDatePrecision = values.find(p => p.value == s).getOrElse(Unknown)
  }

}
