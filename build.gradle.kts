plugins {
    java
    id("info.solidsoft.pitest") version "1.9.11"
    id("com.adarshr.test-logger") version "3.2.0"
}

pitest {
    pitestVersion.set("1.12.0")
    junit5PluginVersion.set("1.1.2")
}

group = "com.att.training.demo"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-simple:2.0.7")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("org.assertj:assertj-core:3.24.2")
    val mockitoVersion = "5.2.0"
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
            showStandardStreams = true
        }
    }
}