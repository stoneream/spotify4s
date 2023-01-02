package spotify4s.v1.model

case class AudioAnalysisObjectTrack(
    /* The exact number of audio samples analyzed from this track. See also `analysis_sample_rate`. */
    numSamples: Option[Int] = None,
    /* Length of the track in seconds. */
    duration: Option[BigDecimal] = None,
    /* This field will always contain the empty string. */
    sampleMd5: Option[String] = None,
    /* An offset to the start of the region of the track that was analyzed. (As the entire track is analyzed, this should always be 0.) */
    offsetSeconds: Option[Int] = None,
    /* The length of the region of the track was analyzed, if a subset of the track was analyzed. (As the entire track is analyzed, this should always be 0.) */
    windowSeconds: Option[Int] = None,
    /* The sample rate used to decode and analyze this track. May differ from the actual sample rate of this track available on Spotify. */
    analysisSampleRate: Option[Int] = None,
    /* The number of channels used for analysis. If 1, all channels are summed together to mono before analysis. */
    analysisChannels: Option[Int] = None,
    /* The time, in seconds, at which the track's fade-in period ends. If the track has no fade-in, this will be 0.0. */
    endOfFadeIn: Option[BigDecimal] = None,
    /* The time, in seconds, at which the track's fade-out period starts. If the track has no fade-out, this should match the track's length. */
    startOfFadeOut: Option[BigDecimal] = None,
    /* The overall loudness of a track in decibels (dB). Loudness values are averaged across the entire track and are useful for comparing relative loudness of tracks. Loudness is the quality of a sound that is the primary psychological correlate of physical strength (amplitude). Values typically range between -60 and 0 db.  */
    loudness: Option[Float] = None,
    /* The overall estimated tempo of a track in beats per minute (BPM). In musical terminology, tempo is the speed or pace of a given piece and derives directly from the average beat duration.  */
    tempo: Option[Float] = None,
    /* The confidence, from 0.0 to 1.0, of the reliability of the `tempo`. */
    tempoConfidence: Option[BigDecimal] = None,
    /* An estimated time signature. The time signature (meter) is a notational convention to specify how many beats are in each bar (or measure). The time signature ranges from 3 to 7 indicating time signatures of \"3/4\", to \"7/4\". */
    timeSignature: Option[Int] = None,
    /* The confidence, from 0.0 to 1.0, of the reliability of the `time_signature`. */
    timeSignatureConfidence: Option[BigDecimal] = None,
    /* The key the track is in. Integers map to pitches using standard [Pitch Class notation](https://en.wikipedia.org/wiki/Pitch_class). E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on. If no key was detected, the value is -1.  */
    key: Option[Int] = None,
    /* The confidence, from 0.0 to 1.0, of the reliability of the `key`. */
    keyConfidence: Option[BigDecimal] = None,
    /* Mode indicates the modality (major or minor) of a track, the type of scale from which its melodic content is derived. Major is represented by 1 and minor is 0.  */
    mode: Option[Int] = None,
    /* The confidence, from 0.0 to 1.0, of the reliability of the `mode`. */
    modeConfidence: Option[BigDecimal] = None,
    /* An [Echo Nest Musical Fingerprint (ENMFP)](https://academiccommons.columbia.edu/doi/10.7916/D8Q248M4) codestring for this track. */
    codestring: Option[String] = None,
    /* A version number for the Echo Nest Musical Fingerprint format used in the codestring field. */
    codeVersion: Option[BigDecimal] = None,
    /* An [EchoPrint](https://github.com/spotify/echoprint-codegen) codestring for this track. */
    echoprintstring: Option[String] = None,
    /* A version number for the EchoPrint format used in the echoprintstring field. */
    echoprintVersion: Option[BigDecimal] = None,
    /* A [Synchstring](https://github.com/echonest/synchdata) for this track. */
    synchstring: Option[String] = None,
    /* A version number for the Synchstring used in the synchstring field. */
    synchVersion: Option[BigDecimal] = None,
    /* A Rhythmstring for this track. The format of this string is similar to the Synchstring. */
    rhythmstring: Option[String] = None,
    /* A version number for the Rhythmstring used in the rhythmstring field. */
    rhythmVersion: Option[BigDecimal] = None
)
