package spotify4s.v1.model

case class CopyrightObject(
    /* The copyright text for this content.  */
    text: Option[String] = None,
    /* The type of copyright: `C` = the copyright, `P` = the sound recording (performance) copyright.  */
    `type`: Option[String] = None
)
