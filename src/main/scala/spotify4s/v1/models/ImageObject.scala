package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class ImageObject (
  /* The source URL of the image.  */
  url: String,
  /* The image height in pixels.  */
  height: Int,
  /* The image width in pixels.  */
  width: Int
)

object ImageObject {
  implicit val format: Format[ImageObject] = Json.format[ImageObject]

}
