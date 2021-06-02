package com.habib.sample.cosmosdb.repository;

import java.util.List;

import com.habib.sample.cosmosdb.datamodel.PlantLocationName;
import com.habib.sample.cosmosdb.datamodel.WorkerLocation;

/**
 * Interface to handle other methods/customs methods which are not available in MongoRepository
 */
public interface WorkerRefDataCustomRepo {
	
	List<PlantLocationName> getPlantLocationsByName(String plantName);

	WorkerLocation addWorkerLocation(WorkerLocation wl);

	WorkerLocation getWorkerLocation(String WORKERID);
	
	void addPlantLocations(List<PlantLocationName> list);

	List<WorkerLocation> getWorkerLocations();

}
