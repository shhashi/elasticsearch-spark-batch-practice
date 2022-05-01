import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    id("scala")
}

group = "shhashi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2021.0.1"

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")

    // Spring Framework
    implementation("org.springframework.cloud:spring-cloud-starter-task")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // guava
    implementation("com.google.guava:guava:31.1-jre")

    // Spark 関連
    implementation("org.apache.spark:spark-core_2.12:3.2.1") {
        exclude("org.slf4j", "slf4j-log4j12")
    }
    implementation("org.apache.spark:spark-sql_2.12:3.2.1") {
        exclude("org.codehaus.janino:janino")
        exclude("org.codehaus.janino:commons-compiler")
    }
    implementation("org.codehaus.janino:janino:3.0.8")
    implementation("org.codehaus.janino:commons-compiler:3.0.8")

    // ES-spark
    implementation("org.elasticsearch:elasticsearch-spark-30_2.12:8.1.2")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
