package spotify4s.v1.model


case class PublicUserObjectFollowers (
  /* This will always be set to null, as the Web API does not support it at the moment.  */
  href: Option[String] = None,
  /* The total number of followers.  */
  total: Option[Int] = None
)

