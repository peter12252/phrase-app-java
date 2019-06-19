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

    @Bean(name = "translations")
    public Map<String, ResourceBundle> phraseAppTranslations(){
        Map<String, ResourceBundle> phraseAppTranslations = new HashMap<>();

        Locale enGBLocale = new Locale("en", "GB");
        Locale deDELocale = new Locale("de", "DE");

        ResourceBundle resourceBundleEnGB = PropertyResourceBundle.getBundle("translations.PhraseAppBundle", enGBLocale);
        ResourceBundle resourceBundleDeDe = PropertyResourceBundle.getBundle("translations.PhraseAppBundle", deDELocale);


        System.out.println("Config: resourceBundleEnGB" + resourceBundleEnGB);
        System.out.println("Config: resourceBundleDeDe" + resourceBundleDeDe);
        System.out.println("Config: resourceBundleEnGB keys" + resourceBundleEnGB.keySet());
        System.out.println("Config: resourceBundleEnGB key entry" + resourceBundleEnGB.getString("my_simple_todo_app"));

        phraseAppTranslations.put("default", resourceBundleEnGB);
        phraseAppTranslations.put("de_DE", resourceBundleDeDe);
        phraseAppTranslations.put("en_GB", resourceBundleEnGB);

        System.out.println("Config phraseAppTranslations keys" + phraseAppTranslations.keySet());

        return phraseAppTranslations;
    }

}
