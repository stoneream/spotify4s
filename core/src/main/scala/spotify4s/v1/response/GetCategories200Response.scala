package spotify4s.v1.response

import spotify4s.v1.model.{CategoryObject, PagingObject}

case class GetCategories200Response(
    categories: PagingObject[CategoryObject]
)
