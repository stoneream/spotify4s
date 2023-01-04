package spotify4s.v1.model

case class AlbumBaseRestrictions(
    /* The reason for the restriction. Albums may be restricted if the content is not available in a given market, to the user's subscription type, or when the user's account is set to not play explicit content. Additional reasons may be added in the future.  */
    reason: Option[AlbumBaseRestrictions.Reason] = None
)

object AlbumBaseRestrictions {

  sealed abstract class Reason(val value: String)

  object Reason {
    final case object Market extends Reason("market")
    final case object Product extends Reason("product")
    final case object Explicit extends Reason("explicit")
    final case object Unknown extends Reason("unknown")

    val values: Seq[Reason] = Seq(Market, Product, Explicit)

    def fromString(s: String): Reason = values.find(p => p.value == s).getOrElse(Unknown)
  }

}
