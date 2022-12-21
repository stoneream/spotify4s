package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class AlbumBaseRestrictions (
  /* The reason for the restriction. Albums may be restricted if the content is not available in a given market, to the user's subscription type, or when the user's account is set to not play explicit content. Additional reasons may be added in the future.  */
  reason: Option[AlbumBaseRestrictions.Reason] = None
)

object AlbumBaseRestrictions {
  implicit val format: Format[AlbumBaseRestrictions] = Json.format[AlbumBaseRestrictions]

  type Reason = Reason.Value

  object Reason extends Enumeration {
    val Market = Value("market")
    val Product = Value("product")
    val Explicit = Value("explicit")

  implicit val format: Format[Reason] = Json.formatEnum(this)

  }

}
