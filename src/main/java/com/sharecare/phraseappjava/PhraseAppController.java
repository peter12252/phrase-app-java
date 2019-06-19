package com.sharecare.phraseappjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@Controller
public class PhraseAppController {

    private ResourceBundle resourceBundle;
    private Map<String, ResourceBundle> phraseAppTranslations;

    @Autowired
    public PhraseAppController(ResourceBundle resourceBundle, Map<String, ResourceBundle> phraseAppTranslations){
        this.resourceBundle = resourceBundle;
        this.phraseAppTranslations = phraseAppTranslations;
    }

    @ResponseBody
    @RequestMapping("/")
    public Map defaultResponse(){
        Map<String, String> map = new HashMap<>();
        map.put("Hi", this.resourceBundle.getString("hi"));
        return map;
    }

    @ResponseBody
    @RequestMapping("/translations")
    public Map getTranslations(@RequestParam(required = false) String localeString){
        Map<String, String> map = new HashMap<>();

        System.out.println(localeString);

        ResourceBundle resourceBundle = this.phraseAppTranslations.get(localeString);
        if(resourceBundle == null){
            resourceBundle = this.phraseAppTranslations.get("default");
        }

        System.out.println("resourceBundle" + resourceBundle);

        if(resourceBundle != null){
            Enumeration<String> keys = resourceBundle.getKeys();
            while(keys.hasMoreElements()){
                String key = keys.nextElement();
                map.put(key, this.resourceBundle.getString(key));
            }
        }


        return map;
    }
}
