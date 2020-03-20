
package com.habib.sample.cosmosdb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.habib.sample.cosmosdb.datamodel.PlantLocationName;


public interface PlantLocationNameRepository extends MongoRepository<PlantLocationName, String> {

	List<PlantLocationName> findByPlantLocation(String plantLocation);

	List<PlantLocationName> findByPlantName(String plantName);
	
	

}
