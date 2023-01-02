package spotify4s.v1.model

case class ErrorObject(
    /* The HTTP status code (also returned in the response header; see [Response Status Codes](/documentation/web-api/#response-status-codes) for more information).  */
    status: Int,
    /* A short description of the cause of the error.  */
    message: String
)
