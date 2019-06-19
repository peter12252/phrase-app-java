#credential initialization
phrase_app_user="demo@phraseapp.com"
phrase_app_password="phrase"

#list the PhraseApp projects
curl -H "User-Agent: Sharecare Test App (hubert.pan@sharecare.com)" -u $phrase_app_user:$phrase_app_password "https://api.phraseapp.com/api/v2/projects"

phrase_app_project_id="ae71de126dd7f183e660a9bdef2e62ed"

#list locales
curl -H "User-Agent: Sharecare Test App (hubert.pan@sharecare.com)" -u $phrase_app_user:$phrase_app_password "https://api.phraseapp.com/api/v2/projects/$phrase_app_project_id/locales"

#Download locale
curl -H "User-Agent: Sharecare Test App (hubert.pan@sharecare.com)" -u $phrase_app_user:$phrase_app_password "https://api.phraseapp.com/api/v2/projects/$phrase_app_project_id/locales/b3bd2f1219a170fb9f9d7e32eb857d9e/download?file_format=properties&" > ./src/main/resources/translations/PhraseAppBundle_de_DE.properties
curl -H "User-Agent: Sharecare Test App (hubert.pan@sharecare.com)" -u $phrase_app_user:$phrase_app_password "https://api.phraseapp.com/api/v2/projects/$phrase_app_project_id/locales/0f91c1b8f5ec3fe5ded4e15ea500b913/download?file_format=properties&" > ./src/main/resources/translations/PhraseAppBundle_en_GB.properties


curl -X POST -H "Content-Type: application/json" -H "User-Agent: Sharecare Test App (hubert.pan@sharecare.com)" -u $phrase_app_user:$phrase_app_password -d '{"note":"My Deploy Script","scopes":["read","write"] }' "https://api.phraseapp.com/api/v2/authorizations"

curl -X POST -H "Content-Type: application/json" -H "User-Agent: Sharecare Test App (hubert.pan@sharecare.com)" -u $phrase_app_user:$phrase_app_password -d '{"note":"My Deploy Script","scopes":["read","write"] }' "https://api.phraseapp.com/api/v2/authorizations"
{"id":"fd12ce8c3c65c14ea008efcb93b9990a","note":"My Deploy Script","token_last_eight":"ee6c5267","hashed_token":"a67a0d3133d34d37b016c0361184c647771c74df75c094da4929aa5a3322c210","scopes":["read","write"],"expires_at":null,"created_at":"2019-06-19T21:49:42Z","updated_at":"2019-06-19T21:49:42Z","token":"55fd250aa7219ae1428a388ae8814e53ea2bc32dde49a839ae8fdce1ee6c5267"}sc3612:phrase-app-java hubert.pan$



./src/main/resources/translations/MessagesBundle_<locale_name>.properties