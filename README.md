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

## Viewing PhraseApp Translations
To view the PhraseApp de_DE translations go to the following url: `http://localhost:8080/translations?localeString=de_DE`
To view the PhraseApp en_BR translations go to the following url: `http://localhost:8080/translations?localeString=en_BR` 

## Updating `/translations` with PhraseApp
`translationApiExample.sh` gives a simple example of how to automatically update translations from phraseapp

If the script fails, please see the comments in the script for debugging purposes.