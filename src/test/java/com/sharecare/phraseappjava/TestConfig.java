package com.sharecare.phraseappjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

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

}
