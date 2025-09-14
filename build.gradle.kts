import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    java
    id("info.solidsoft.pitest") version "1.5.1"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

pitest {
    junit5PluginVersion.set("0.12")
}

group = "com.att.training.demo"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-simple:1.7.30")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
    testImplementation("org.assertj:assertj-core:3.16.1")
    val mockitoVersion = "3.3.3"
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
        exceptionFormat = TestExceptionFormat.SHORT
    }
}