package shhashi.batch.management.application.usecase

import org.springframework.stereotype.Component
import shhashi.batch.management.application.query.CreateDocumentQueryRepository
import java.time.OffsetDateTime

@Component
class CreateDocumentsUsecase(
    private val createDocumentQueryRepository: CreateDocumentQueryRepository
) {

    fun extractAggregation(aggregateFrom: OffsetDateTime, aggregateTo: OffsetDateTime) {
        createDocumentQueryRepository.extractAggregation(aggregateFrom, aggregateTo)
    }
}