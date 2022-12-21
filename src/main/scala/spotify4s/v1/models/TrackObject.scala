package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class TrackObject (
  album: Option[TrackObjectAlbum] = None,
  /* The artists who performed the track. Each artist object includes a link in `href` to more detailed information about the artist.  */
  artists: Option[List[ArtistObject]] = None,
  /* A list of the countries in which the track can be played, identified by their [ISO 3166-1 alpha-2](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code.  */
  availableMarkets: Option[List[String]] = None,
  /* The disc number (usually `1` unless the album consists of more than one disc).  */
  discNumber: Option[Int] = None,
  /* The track length in milliseconds.  */
  durationMs: Option[Int] = None,
  /* Whether or not the track has explicit lyrics ( `true` = yes it does; `false` = no it does not OR unknown).  */
  explicit: Option[Boolean] = None,
  externalIds: Option[TrackObjectExternalIds] = None,
  externalUrls: Option[LinkedTrackObjectExternalUrls] = None,
  /* A link to the Web API endpoint providing full details of the track.  */
  href: Option[String] = None,
  /* The [Spotify ID](/documentation/web-api/#spotify-uris-and-ids) for the track.  */
  id: Option[String] = None,
  /* Part of the response when [Track Relinking](/documentation/general/guides/track-relinking-guide/) is applied. If `true`, the track is playable in the given market. Otherwise `false`.  */
  isPlayable: Option[Boolean] = None,
  linkedFrom: Option[TrackObjectLinkedFrom] = None,
  restrictions: Option[SimplifiedTrackObjectRestrictions] = None,
  /* The name of the track.  */
  name: Option[String] = None,
  /* The popularity of the track. The value will be between 0 and 100, with 100 being the most popular.<br>The popularity of a track is a value between 0 and 100, with 100 being the most popular. The popularity is calculated by algorithm and is based, in the most part, on the total number of plays the track has had and how recent those plays are.<br>Generally speaking, songs that are being played a lot now will have a higher popularity than songs that were played a lot in the past. Duplicate tracks (e.g. the same track from a single and an album) are rated independently. Artist and album popularity is derived mathematically from track popularity. _**Note**: the popularity value may lag actual popularity by a few days: the value is not updated in real time._  */
  popularity: Option[Int] = None,
  /* A link to a 30 second preview (MP3 format) of the track. Can be `null`  */
  previewUrl: Option[String] = None,
  /* The number of the track. If an album has several discs, the track number is the number on the specified disc.  */
  trackNumber: Option[Int] = None,
  /* The object type: \"track\".  */
  `type`: Option[String] = None,
  /* The [Spotify URI](/documentation/web-api/#spotify-uris-and-ids) for the track.  */
  uri: Option[String] = None,
  /* Whether or not the track is from a local file.  */
  isLocal: Option[Boolean] = None
)

object TrackObject {
  implicit val format: Format[TrackObject] = Json.format[TrackObject]

}
