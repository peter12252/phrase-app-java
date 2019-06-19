# phrase-app-java
This repository serves as a demo project for using PhraseApp with Spring Boot Java

## Initialization and First Run

Prerequisites:
 - Java 1.8 (Corretto)
 - Node 10+
 - Git
 - Bash shell

Clone the project

Change the current directory to the project's root directory

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
IMPORTANT THE CODE IN THIS SECTION IS USING A PUBLIC DEMO ACCOUNT PROVIDED BY PHRASEAPP, EXECUTING THIS CODE MAY PULL DOWN UNEXPECTED CONTENT.

PRIOR TO ANY DEMOS, ONE MAY WANT TO ACCESS https://phraseapp.com/account/login USING THE FOLLOWING DEMO CREDENTIALS AND VERIFYING THAT NOTHING UNWANTED IS PRESENT.

```js
user: demo@phraseapp.com
password:phrase
```

You can download the most recent translations by executing `./translationManagement.js pull` from the project's root directory

Alternatively `translationApiExample.sh` gives a simple example of how to automatically update translations from phraseapp using curl calls

If the script fails, please see the comments in the script for debugging purposes.