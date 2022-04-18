package shhashi.batch.management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.task.configuration.EnableTask

@SpringBootApplication
@EnableTask
@ConfigurationPropertiesScan
class ManagementBatchApplication

fun main(args: Array<String>) {
    runApplication<ManagementBatchApplication>(*args)
}
