plugins {
    java
    id("info.solidsoft.pitest") version "1.7.4"
    id("com.adarshr.test-logger") version "3.2.0"
}

pitest {
    pitestVersion.set("1.9.0")
    junit5PluginVersion.set("1.0.0")
}

group = "com.att.training.demo"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-simple:1.7.36")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.assertj:assertj-core:3.23.1")
    val mockitoVersion = "4.6.1"
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
}

tasks {
    withType<JavaCompile>().configureEach {
        options.release.set(17)
    }

    test {
        useJUnitPlatform()
        testlogger {
            showStandardStreams = false
        }
    }
}