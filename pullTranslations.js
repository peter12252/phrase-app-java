#!/usr/bin/env node

var https = require('https');
var fs = require('fs');

var phraseAppUser = "demo@phraseapp.com";
var phraseAppPw = "phrase";
var targetApplication = "My Demo Application";

var options = {
    headers:{
        "User-Agent":"Sharecare Test App (hubert.pan@sharecare.com)"
    },
    auth:phraseAppUser+":" + phraseAppPw
};

https.get("https://api.phraseapp.com/api/v2/projects", options, function(res){
    var data = '';
    res.on('data', function(chunk){
        data += chunk;
    })

    res.on('end', function(){
        var projectsResponse = JSON.parse(data);
        var candidateProjects = projectsResponse.filter(function(project){return project.name===targetApplication})
        if(candidateProjects.length > 0){
            var projectId = candidateProjects[0].id;
            console.log("Using project id: " + projectId);

            https.get("https://api.phraseapp.com/api/v2/projects/" + projectId + "/locales", options, function(res2){
                var data2 = '';
                //console.log("bob")
                res2.on('data', function(chunk){
                    data2 += chunk;
                })
                res2.on('end', function(){
                    var localesResponse = JSON.parse(data2);
                    //console.dir(localesResponse);
                    localesResponse.forEach(function(locale){pullTranslationForLocale(locale, projectId, 'properties', writeOutFile)})
                })
            });

        } else {
            console.error("Failed to locate any valid projects")
        }

    })
});

function pullTranslationForLocale(locale, projectId, format, handleOutput){
    var id = locale.id;
    var code = locale.code;
    //console.log(code);

    https.get("https://api.phraseapp.com/api/v2/projects/" + projectId + "/locales/" + id + "/download?file_format=" + format, options, function(res3){
        var data3 = "";

        res3.on('data', function(chunk){
            data3 += chunk;
        })

        res3.on('end', function(){
            //console.log(data3);
            handleOutput(data3, locale, format)
        })
    });
}

function writeOutFile(fileContent, locale, format){
    var rawCode = locale.code;
    var processedCode = rawCode.replace("-","_");
    var fileTarget = "./src/main/resources/translations/PhraseAppBundle_" + processedCode + "." + format;
    console.dir(fileTarget);
    // fs.writeFile(fileTarget, fileContent, function(err){
    //     if(err) throw err;
    //     console.log('Overwrote: ' + fileTarget);
    // })
}