The Worker Reference data API service using Cosmos Database.
The Worker Reference data API service using Cosmos Database.
The main purpose of the service is to store some reference data in the database required by our application. Those data we can be access by rest API and saved into Cosmos DB which can be accessed using Mongo DB API.

Two types of data we are saving in the DB.
Plant Location and Plant Name.
Worker Id and Location

PlantLocationName is being saved while initializing the service using MongoTemplate and BulkOpertaions upsert.
PlantLocationName can be GET by passing either plant name or by plant location.
WorkerLocation can be saved by accessing POST API and passing the Location.
GET Worker Location by passing the Worker ID.

Implement the solution using Spring Data and Mongo Template.


## Example



### Test get plant location by passing plant name
```
curl 
  --request GET \
  --url http://localhost:9089/worker/refdata/v1/workersdata/plantname/AMSN
 
```
### Swagger Documentation 
```
--- url http://localhost:9089/swagger-ui.html#/

```