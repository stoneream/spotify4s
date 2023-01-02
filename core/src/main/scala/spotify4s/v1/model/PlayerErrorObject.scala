package spotify4s.v1.model

case class PlayerErrorObject(
    /* The HTTP status code. Either `404 NOT FOUND` or `403 FORBIDDEN`.  Also returned in the response header.  */
    status: Option[Int] = None,
    /* A short description of the cause of the error.  */
    message: Option[String] = None,
    reason: Option[PlayerErrorReasons] = None
)
