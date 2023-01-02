package spotify4s.v1.model

import java.time.OffsetDateTime

case class PlaylistTrackObject(
    /* The date and time the track or episode was added. _**Note**: some very old playlists may return `null` in this field._  */
    addedAt: Option[OffsetDateTime] = None,
    addedBy: Option[PlaylistTrackObjectAddedBy] = None,
    /* Whether this track or episode is a [local file](https://developer.spotify.com/web-api/local-files-spotify-playlists/) or not.  */
    isLocal: Option[Boolean] = None,
    track: Option[PlaylistTrackObjectTrack] = None
)
