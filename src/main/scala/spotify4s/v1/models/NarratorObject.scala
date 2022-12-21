package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class NarratorObject (
  /* The name of the Narrator.  */
  name: Option[String] = None
)

object NarratorObject {
  implicit val format: Format[NarratorObject] = Json.format[NarratorObject]

}
