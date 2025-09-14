plugins {
    java
    id("info.solidsoft.pitest") version "1.7.0"
    id("com.adarshr.test-logger") version "3.1.0"
}

pitest {
    pitestVersion.set("1.7.3")
    junit5PluginVersion.set("0.15")
}

group = "com.att.training.demo"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-simple:1.7.32")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.assertj:assertj-core:3.21.0")
    val mockitoVersion = "4.1.0"
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
}

tasks {
    withType<JavaCompile>().configureEach {
        options.release.set(11)
    }

    test {
        useJUnitPlatform()
        testlogger {
            showStandardStreams = false
        }
    }
}