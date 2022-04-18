package shhashi.batch.management.command

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import shhashi.batch.management.application.usecase.AggregationExtractorUsecase
import shhashi.batch.management.command.args.AggregationExtractorArguments

/**
 * イベントログを集計し、保存するコマンド。
 */
@Component
@ConditionalOnProperty(value = ["app.task"], havingValue = "AggregationExtractor")
class AggregationExtractorCommand(
    private val aggregationExtractorUsecase: AggregationExtractorUsecase,
    private val aggregationExtractorArguments: AggregationExtractorArguments
): CommandLineRunner {

    override fun run(vararg args: String?) {
        aggregationExtractorUsecase.extractAggregation(
            aggregationExtractorArguments.aggregateFrom,
            aggregationExtractorArguments.aggregateTo
        )
    }
}
