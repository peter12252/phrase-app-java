# phrase-app-java
This repository serves as a demo project for using PhraseApp with Spring Boot Java

## Initialization and First Run

Clone the project

Run and compile the tests
```./gradlew clean build```

Execute the built jar file
```java -jar ./build/libs/phrase-app-java-*.jar```

Then go to the following url `http://localhost:8080/` and you should get the following JSON object: `{"Hi":"hello"}`

## Customizing the default locale

To start the project with a default locale other than en-US, e.g. es-US, execute:
```java -Dlanguage="es" -Dcountry="US" -jar ./build/libs/phrase-app-java-*.jar```

Then go to the following url `http://localhost:8080/` and you should get the following JSON object: `{"Hi":"hola"}`