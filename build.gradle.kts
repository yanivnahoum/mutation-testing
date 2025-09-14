import info.solidsoft.gradle.pitest.PitestPluginExtension
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

buildscript {
    val pitest = configurations.maybeCreate("pitest")
    dependencies {
        classpath("info.solidsoft.gradle.pitest:gradle-pitest-plugin:1.4.5")
        pitest("org.pitest:pitest-junit5-plugin:0.10")
    }
}

apply(plugin = "info.solidsoft.pitest")
configure<PitestPluginExtension> {
    testPlugin.set("junit5")
}

group = "com.att.training.demo"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    val mockitoVersion = "3.1.0"
    implementation("org.slf4j:slf4j-simple:1.7.29")
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
    testImplementation("org.assertj:assertj-core:3.13.2")
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