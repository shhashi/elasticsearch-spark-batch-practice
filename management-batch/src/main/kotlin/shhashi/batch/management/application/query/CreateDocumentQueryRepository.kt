package shhashi.batch.management.application.query

import java.time.OffsetDateTime

interface CreateDocumentQueryRepository {

    fun extractAggregation(aggregateFrom: OffsetDateTime, aggregateTo: OffsetDateTime)
}