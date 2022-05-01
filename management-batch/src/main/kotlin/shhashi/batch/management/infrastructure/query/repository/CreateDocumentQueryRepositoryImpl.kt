package shhashi.batch.management.infrastructure.query.repository

import org.apache.spark.sql.SparkSession
import org.elasticsearch.spark.sql.api.java.JavaEsSparkSQL
import org.springframework.stereotype.Repository
import shhashi.batch.management.application.query.CreateDocumentQueryRepository
import shhashi.batch.management.infrastructure.config.ElasticsearchConfiguration
import java.time.OffsetDateTime

@Repository
class CreateDocumentQueryRepositoryImpl(
    private val elasticsearchConfiguration: ElasticsearchConfiguration
) : CreateDocumentQueryRepository {

    override fun extractAggregation(aggregateFrom: OffsetDateTime, aggregateTo: OffsetDateTime) {

        val sparkSqlContext = SparkSession.builder()
            .appName("Event Aggregate Application")
            .master("spark://es-spark:7077")
            .config("spark.es.index.auto.create", "true")
            .config("spark.es.nodes", "elasticsearch")
            .config("spark.es.port", "9200")
            .config("spark.es.scroll.size", "5000")
            .also {
                // Basic認証
                elasticsearchConfiguration.authorization?.let { authorization ->
                    it.config("spark.es.net.http.auth.user", authorization.user)
                    it.config("spark.es.net.http.auth.pass", authorization.password)
                }
            }
            .orCreate
            .sqlContext()

        data class Member(
            val name: String,
            val id: Int
        )

        // insert
        val data1 = listOf(
            Member(name = "test1", id = 1),
            Member(name = "test2", id = 2)
        )
        val ds = sparkSqlContext.createDataFrame(data1, Member::class.java)
        JavaEsSparkSQL.saveToEs(ds, "sample-new-index")
    }
}
