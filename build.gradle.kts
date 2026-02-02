plugins {
    java
    jacoco
    id("info.solidsoft.pitest") version "1.19.0-rc.2"
    id("com.adarshr.test-logger") version "4.0.0"
}

pitest {
    pitestVersion.set("1.22.0")
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
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
    val mockitoVersion = "5.21.0"
    mockitoAgent("org.mockito:mockito-core:$mockitoVersion") { isTransitive = false }
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
}

jacoco {
    toolVersion = "0.8.14"
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
