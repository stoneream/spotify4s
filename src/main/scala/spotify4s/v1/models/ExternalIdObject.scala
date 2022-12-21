package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class ExternalIdObject (
  /* [International Standard Recording Code](http://en.wikipedia.org/wiki/International_Standard_Recording_Code)  */
  isrc: Option[String] = None,
  /* [International Article Number](http://en.wikipedia.org/wiki/International_Article_Number_%28EAN%29)  */
  ean: Option[String] = None,
  /* [Universal Product Code](http://en.wikipedia.org/wiki/Universal_Product_Code)  */
  upc: Option[String] = None
)

object ExternalIdObject {
  implicit val format: Format[ExternalIdObject] = Json.format[ExternalIdObject]

}
