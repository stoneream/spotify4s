package spotify4s.v1.response

import spotify4s.v1.model.ChapterObject

case class GetSeveralChapters200Response(
    chapters: List[ChapterObject]
)
