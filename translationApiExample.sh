#credential initialization
phrase_app_user="demo@phraseapp.com"
phrase_app_password="phrase"

#list the PhraseApp projects
curl -H "User-Agent: Sharecare Test App (hubert.pan@sharecare.com)" -u $phrase_app_user:$phrase_app_password "https://api.phraseapp.com/api/v2/projects"

#list locales
curl -H "User-Agent: Sharecare Test App (hubert.pan@sharecare.com)" -u $phrase_app_user:$phrase_app_password "https://api.phraseapp.com/api/v2/projects/00000000000000004158e0858d2fa45c/locales"

#Download locale
curl -H "User-Agent: Sharecare Test App (hubert.pan@sharecare.com)" -u $phrase_app_user:$phrase_app_password "https://api.phraseapp.com/api/v2/projects/00000000000000004158e0858d2fa45c/locales/b3bd2f1219a170fb9f9d7e32eb857d9e/download?file_format=properties&" > ./src/main/resources/translations/PhraseAppBundle_de_DE.properties
curl -H "User-Agent: Sharecare Test App (hubert.pan@sharecare.com)" -u $phrase_app_user:$phrase_app_password "https://api.phraseapp.com/api/v2/projects/00000000000000004158e0858d2fa45c/locales/0f91c1b8f5ec3fe5ded4e15ea500b913/download?file_format=properties&" > ./src/main/resources/translations/PhraseAppBundle_en_GB.properties