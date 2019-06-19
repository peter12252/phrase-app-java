package com.sharecare.phraseappjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class Config {
    @Bean
    public ResourceBundle resourceBundle(){
        String language = System.getProperty("language", "en");
        String country = System.getProperty("country", "US");

        Locale currentLocale = new Locale(language, country);

        System.out.format("Initializing with Locale %s - %s via %s - %s\n", currentLocale.getLanguage(), currentLocale.getCountry(), language, country);

        ResourceBundle resourceBundle = ResourceBundle.getBundle("translations.MessagesBundle", currentLocale);
        return resourceBundle;
    }

    @Bean
    public Map<String, ResourceBundle> phraseAppTranslations(){
        Map<String, ResourceBundle> phraseAppTranslations = new HashMap<>();

        ResourceBundle resourceBundle = ResourceBundle.getBundle("translations.PhraseAppBundle");

        phraseAppTranslations.put("default", ResourceBundle.getBundle("translations.PhraseAppBundle", new Locale("en", "GB")));
        phraseAppTranslations.put("de_DE", ResourceBundle.getBundle("translations.PhraseAppBundle", new Locale("de", "DE")));
        phraseAppTranslations.put("en_GB", ResourceBundle.getBundle("translations.PhraseAppBundle", new Locale("en", "GB")));

        return phraseAppTranslations;
    }

}
