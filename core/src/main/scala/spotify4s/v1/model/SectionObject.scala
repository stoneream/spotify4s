package spotify4s.v1.model

case class SectionObject(
    /* The starting point (in seconds) of the section. */
    start: Option[BigDecimal] = None,
    /* The duration (in seconds) of the section. */
    duration: Option[BigDecimal] = None,
    /* The confidence, from 0.0 to 1.0, of the reliability of the section's \"designation\". */
    confidence: Option[BigDecimal] = None,
    /* The overall loudness of the section in decibels (dB). Loudness values are useful for comparing relative loudness of sections within tracks. */
    loudness: Option[BigDecimal] = None,
    /* The overall estimated tempo of the section in beats per minute (BPM). In musical terminology, tempo is the speed or pace of a given piece and derives directly from the average beat duration. */
    tempo: Option[BigDecimal] = None,
    /* The confidence, from 0.0 to 1.0, of the reliability of the tempo. Some tracks contain tempo changes or sounds which don't contain tempo (like pure speech) which would correspond to a low value in this field. */
    tempoConfidence: Option[BigDecimal] = None,
    /* The estimated overall key of the section. The values in this field ranging from 0 to 11 mapping to pitches using standard Pitch Class notation (E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on). If no key was detected, the value is -1. */
    key: Option[Int] = None,
    /* The confidence, from 0.0 to 1.0, of the reliability of the key. Songs with many key changes may correspond to low values in this field. */
    keyConfidence: Option[BigDecimal] = None,
    /* Indicates the modality (major or minor) of a section, the type of scale from which its melodic content is derived. This field will contain a 0 for \"minor\", a 1 for \"major\", or a -1 for no result. Note that the major key (e.g. C major) could more likely be confused with the minor key at 3 semitones lower (e.g. A minor) as both keys carry the same pitches. */
    mode: Option[SectionObject.Mode] = None,
    /* The confidence, from 0.0 to 1.0, of the reliability of the `mode`. */
    modeConfidence: Option[BigDecimal] = None,
    /* An estimated time signature. The time signature (meter) is a notational convention to specify how many beats are in each bar (or measure). The time signature ranges from 3 to 7 indicating time signatures of \"3/4\", to \"7/4\". */
    timeSignature: Option[Int] = None,
    /* The confidence, from 0.0 to 1.0, of the reliability of the `time_signature`. Sections with time signature changes may correspond to low values in this field. */
    timeSignatureConfidence: Option[BigDecimal] = None
)

object SectionObject {

  sealed abstract class Mode(val value: String)

  object Mode {
    final case object `-1` extends Mode("-1")
    final case object `0` extends Mode("0")
    final case object `1` extends Mode("1")
    final case object Unknown extends Mode("unknown")

    val values: Seq[Mode] = Seq(`-1`, `0`, `1`)

    def fromString(s: String): Mode = values.find(p => p.value == s).getOrElse(Unknown)
  }

}
