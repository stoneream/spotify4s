package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class ReorderOrReplacePlaylistsTracks200Response (
  snapshotId: Option[String] = None
)

object ReorderOrReplacePlaylistsTracks200Response {
  implicit val format: Format[ReorderOrReplacePlaylistsTracks200Response] = Json.format[ReorderOrReplacePlaylistsTracks200Response]

}
