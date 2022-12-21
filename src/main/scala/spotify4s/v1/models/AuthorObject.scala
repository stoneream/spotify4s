package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class AuthorObject (
  /* The name of the author.  */
  name: Option[String] = None
)

object AuthorObject {
  implicit val format: Format[AuthorObject] = Json.format[AuthorObject]

}
