#### Mutation Testing Demo

This demo demonstrates the use of the pitest plugin for mutation testing.
Both maven and gradle are supported, with JUnit Jupiter and JDK 11.

Maven: `./mvnw org.pitest:pitest-maven:mutationCoverage`
<br>
Gradle: `./gradlew pitest`

In order to run the plugin on modified and added files only, make sure you have the scm element (in the maven pom) and run:

Maven: `./mvnw org.pitest:pitest-maven:scmMutationCoverage`