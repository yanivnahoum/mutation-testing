plugins {
    java
    jacoco
    id("info.solidsoft.pitest") version "1.19.0-rc.1"
    id("com.adarshr.test-logger") version "4.0.0"
}

pitest {
    pitestVersion.set("1.20.2")
    junit5PluginVersion.set("1.2.3")
}

group = "com.att.training.demo"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

val mockitoAgent = configurations.create("mockitoAgent")
dependencies {
    implementation("org.slf4j:slf4j-simple:2.0.17")
    testImplementation("org.junit.jupiter:junit-jupiter:5.13.4")
    testImplementation("org.assertj:assertj-core:3.27.4")
    val mockitoVersion = "5.19.0"
    mockitoAgent("org.mockito:mockito-core:$mockitoVersion") { isTransitive = false }
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
}

jacoco {
    toolVersion = "0.8.13"
}
val jacocoTestReport = tasks.jacocoTestReport
tasks {
    test {
        useJUnitPlatform()
        jvmArgs("-javaagent:${mockitoAgent.asPath}")
        finalizedBy(jacocoTestReport)
        testlogger {
            showStandardStreams = true
        }
    }
}
