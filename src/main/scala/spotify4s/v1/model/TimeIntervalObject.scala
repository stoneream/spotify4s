package spotify4s.v1.model

case class TimeIntervalObject(
    /* The starting point (in seconds) of the time interval. */
    start: Option[BigDecimal] = None,
    /* The duration (in seconds) of the time interval. */
    duration: Option[BigDecimal] = None,
    /* The confidence, from 0.0 to 1.0, of the reliability of the interval. */
    confidence: Option[BigDecimal] = None
)
