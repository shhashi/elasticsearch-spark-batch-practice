package shhashi.batch.management.command.args

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.time.OffsetDateTime

@ConstructorBinding
@ConfigurationProperties(prefix = "app.aggregate")
class CreateDocumentsArguments(
    var from: OffsetDateTime? = null,
    var to: OffsetDateTime? = null
) {

    val aggregateFrom: OffsetDateTime
        get() = from ?: throw IllegalArgumentException("from must not be null.")

    val aggregateTo: OffsetDateTime
        get() = to ?: throw IllegalArgumentException("to must not be null.")
}