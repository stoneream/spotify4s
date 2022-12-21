package spotify4s.v1.models

import play.api.libs.json.{Format, Json}

case class AudioAnalysisObjectMeta (
  /* The version of the Analyzer used to analyze this track. */
  analyzerVersion: Option[String] = None,
  /* The platform used to read the track's audio data. */
  platform: Option[String] = None,
  /* A detailed status code for this track. If analysis data is missing, this code may explain why. */
  detailedStatus: Option[String] = None,
  /* The return code of the analyzer process. 0 if successful, 1 if any errors occurred. */
  statusCode: Option[Int] = None,
  /* The Unix timestamp (in seconds) at which this track was analyzed. */
  timestamp: Option[Int] = None,
  /* The amount of time taken to analyze this track. */
  analysisTime: Option[BigDecimal] = None,
  /* The method used to read the track's audio data. */
  inputProcess: Option[String] = None
)

object AudioAnalysisObjectMeta {
  implicit val format: Format[AudioAnalysisObjectMeta] = Json.format[AudioAnalysisObjectMeta]

}
