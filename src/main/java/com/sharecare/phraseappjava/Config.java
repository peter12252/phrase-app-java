package com.sharecare.phraseappjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

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

}
