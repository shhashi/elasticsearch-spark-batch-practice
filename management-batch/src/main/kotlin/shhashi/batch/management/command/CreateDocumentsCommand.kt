package shhashi.batch.management.command

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import shhashi.batch.management.application.usecase.CreateDocumentsUsecase
import shhashi.batch.management.command.args.CreateDocumentsArguments

@Component
@ConditionalOnProperty(value = ["app.task"], havingValue = "AggregationExtractor")
class CreateDocumentsCommand(
    private val createDocumentsUsecase: CreateDocumentsUsecase,
    private val createDocumentsArguments: CreateDocumentsArguments
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        println(createDocumentsArguments.from)

        createDocumentsUsecase.extractAggregation(
            createDocumentsArguments.aggregateFrom,
            createDocumentsArguments.aggregateTo
        )
    }
}
