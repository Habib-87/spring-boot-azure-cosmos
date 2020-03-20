# spring-boot-azure-cosmos

The project is to show how to connect Azure Cosmos DB from your spring boot application. Here I have used Azure Cosmos DB emulator to implement in local. We used Mongo DB API to connect Cosmos DB.

The local cosmos db link is configured in the application.yaml. Before accessing the production cosmos db the link in application.yaml needs to be changed accordingly. 

The solution has been implemented in two ways. 
1. Using Spring Data - MongoRepository 
2. Creating a custom repository and using MongoTemplate.

The main purpose of the project to show how to connect Cosmos DB using Spring Boot+Mongo DB API. Exception and Unit testing are not being handled properly.
Basic swagger documentation is available in the below link.
http://localhost:9089/swagger-ui.html#/

The default port of the application is 9089.



# Azure Cosmos DB Emulator - Local installation 
Please find the below link to install in your local machine.

https://docs.microsoft.com/en-us/azure/cosmos-db/local-emulator 


After installing the Emulator you need to install the certificate as mentioned in the above link. Few tips if you are facing issues to install the certificate. 
After copying the certificate from certlm.msc save it to your local drive as documentdbemulatorcert.cer(Just as an example, you can save in the below path C:\cosmos_cert). Please follow the below steps to install the certificate.
https://docs.microsoft.com/en-us/azure/cosmos-db/local-emulator#export-the-ssl-certificate

After saving the certificate go to your Java Security folder like the below path. You may have a different java version. The below example path is mine.

cd C:\Program Files\Java\jdk-11.0.5\lib\security

Execute the below line to install the certificate through CMD. Open the CMD as an Admin.

keytool -keystore cacerts -importcert -alias documentdbemulatorcert -file C:\cosmos_cert\documentdbemulatorcert.cer

Please run the below command from your Azure Cosmos DB installation directory

Microsoft.Azure.Cosmos.Emulator.exe /AllowNetworkAccess /Key=C2y6yDjf5/R+ob0N8A7Cgv30VRDJIWEHLM+4QDU5DE2nQ9nDuVTqobD4b8mGGyPMbIZnqyMsEcaGQy67XIw/Jw== /EnableMongoDbEndpoint

Here the Key is Primary key which you will find in data explorer after installing the Cosmos DB. The default link for local is 
https://localhost:8081/_explorer/index.html

If still, you are facing issues try to delete all the files from %LOCALAPPDATA%\CosmosDBEmulator and clicking reset data option.



