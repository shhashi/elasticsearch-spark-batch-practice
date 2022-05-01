package shhashi.batch.management.infrastructure.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "app.elasticsearch")
class ElasticsearchConfiguration(
    var authorization: Authorization? = null
) {

    class Authorization(
        var user: String? = null,
        var password: String? = null
    )
}