package spotify4s.v1.model

case class AudioAnalysisObject(
    meta: Option[AudioAnalysisObjectMeta] = None,
    track: Option[AudioAnalysisObjectTrack] = None,
    /* The time intervals of the bars throughout the track. A bar (or measure) is a segment of time defined as a given number of beats. */
    bars: Option[List[TimeIntervalObject]] = None,
    /* The time intervals of beats throughout the track. A beat is the basic time unit of a piece of music; for example, each tick of a metronome. Beats are typically multiples of tatums. */
    beats: Option[List[TimeIntervalObject]] = None,
    /* Sections are defined by large variations in rhythm or timbre, e.g. chorus, verse, bridge, guitar solo, etc. Each section contains its own descriptions of tempo, key, mode, time_signature, and loudness. */
    sections: Option[List[SectionObject]] = None,
    /* Each segment contains a roughly conisistent sound throughout its duration. */
    segments: Option[List[SegmentObject]] = None,
    /* A tatum represents the lowest regular pulse train that a listener intuitively infers from the timing of perceived musical events (segments). */
    tatums: Option[List[TimeIntervalObject]] = None
)
