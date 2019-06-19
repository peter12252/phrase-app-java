package com.sharecare.phraseappjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public PhraseAppController(ResourceBundle resourceBundle, @Qualifier("translations") Map<String, ResourceBundle> phraseAppTranslations){
        this.resourceBundle = resourceBundle;
        this.phraseAppTranslations = phraseAppTranslations;
        System.out.println("Controller-phraseAppTranslations" + phraseAppTranslations);
        System.out.println("Controller phraseAppTranslations keys" + phraseAppTranslations.keySet());
        System.out.println("Controller en_GB translations" + phraseAppTranslations.get("en_GB"));
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
    public Map<String, Object> getTranslations(@RequestParam(required = false) String localeString){
        Map<String, Object> map = new HashMap<>();

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
                System.out.println("pushing key: " + key);
                map.put(key, this.resourceBundle.getObject(key));
            }
        }


        return map;
    }
}
