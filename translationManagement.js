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

if(process.argv.length > 2){
    if(process.argv[2] === "pull"){
        console.log('pulling translations')
        pullTranslations()
    } else {
        if(process.argv[2] === "push"){
            console.log("currently not supported")
        }
    }

} else {
    console.log("run `" + process.argv[1] + " pull`, to fetch new translations")
}

function pullTranslations(){
    getTargetProject(getLocalesForProject)
}

function getTargetProject(processProject){
    https.get("https://api.phraseapp.com/api/v2/projects", options, function(res){
        var data = '';
        res.on('data', function(chunk){
            data += chunk;
        })

        res.on('end', function(){
            var projectsResponse = JSON.parse(data);
            var candidateProjects = projectsResponse.filter(function(project){return project.name===targetApplication})
            if(candidateProjects.length > 0){
                var project = candidateProjects[0]
                var projectId = project.id;
                console.log("Using project id: " + projectId);

                processProject(project)

            } else {
                console.error("Failed to locate any valid projects")
            }

        })
    });
}

function getLocalesForProject(project){
    var projectId = project.id;
    https.get("https://api.phraseapp.com/api/v2/projects/" + projectId + "/locales", options, function(res2){
        var data2 = '';
        res2.on('data', function(chunk){
            data2 += chunk;
        })
        res2.on('end', function(){
            var localesResponse = JSON.parse(data2);
            localesResponse.forEach(function(locale){pullTranslationForLocale(locale, projectId, 'properties', writeOutFile)})
        })
    });
}

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
    fs.writeFile(fileTarget, fileContent, function(err){
        if(err) throw err;
        console.log('Overwrote: ' + fileTarget);
    })
}