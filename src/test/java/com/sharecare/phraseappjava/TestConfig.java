package com.sharecare.phraseappjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class TestConfig {
    @Bean
    public ResourceBundle resourceBundle(){
        Properties properties = System.getProperties();
        String language = properties.getProperty("language", "en");
        String country = properties.getProperty("country", "US");

        Locale currentLocale = new Locale(language, country);

        System.out.format("Initializing with Locale %s - %s", currentLocale.getLanguage(), currentLocale.getCountry());

        ResourceBundle resourceBundle = ResourceBundle.getBundle("translations.MessagesBundle", currentLocale);
        return resourceBundle;
    }

    @Bean
    public Map<String, ResourceBundle> phraseAppTranslations(){
        Map<String, ResourceBundle> phraseAppTranslations = new HashMap<>();

        ResourceBundle resourceBundle = ResourceBundle.getBundle("translations.PhraseAppBundle");

        phraseAppTranslations.put("default", resourceBundle);

        return phraseAppTranslations;
    }
}
