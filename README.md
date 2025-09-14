#### Mutation Testing Demo

This demo demonstrates the use of the pitest plugin for mutation testing.
Both maven and gradle are supported, with JUnit Jupiter and JDK 11.

Maven: `./mvnw org.pitest:pitest-maven:mutationCoverage [-gs default-settings.xml]`
<br>
Gradle: `./gradlew pitest`

In order to run the plugin on modified and added files only, make sure you have the scm element (maven) and run:

Maven: `./mvnw org.pitest:pitest-maven:scmMutationCoverage`