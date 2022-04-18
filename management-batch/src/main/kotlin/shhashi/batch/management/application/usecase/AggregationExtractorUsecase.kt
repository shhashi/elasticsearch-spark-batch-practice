package shhashi.batch.management.application.usecase

import org.springframework.stereotype.Component
import java.time.OffsetDateTime

/**
 * イベントログを集計するためのユースケース
 */
@Component
class AggregationExtractorUsecase {

    fun extractAggregation(aggregateFrom: OffsetDateTime, aggregateTo: OffsetDateTime) {
        TODO("Not Implemented.")
    }
}