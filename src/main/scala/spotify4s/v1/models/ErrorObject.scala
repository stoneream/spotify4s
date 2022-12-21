package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class ErrorObject (
  /* The HTTP status code (also returned in the response header; see [Response Status Codes](/documentation/web-api/#response-status-codes) for more information).  */
  status: Int,
  /* A short description of the cause of the error.  */
  message: String
)

object ErrorObject {
  implicit val format: Format[ErrorObject] = Json.format[ErrorObject]

}
