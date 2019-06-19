package com.sharecare.phraseappjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@Controller
public class PhraseAppController {

    private ResourceBundle resourceBundle;

    @Autowired
    public PhraseAppController(ResourceBundle resourceBundle){
        this.resourceBundle = resourceBundle;
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
    public Map getTranslations(){
        Map<String, String> map = new HashMap<>();
        map.put("Hi", this.resourceBundle.getString("hi"));
        return map;
    }
}
