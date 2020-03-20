package com.habib.sample.cosmosdb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.habib.sample.cosmosdb.datamodel.PlantLocationName;
import com.habib.sample.cosmosdb.datamodel.WorkerLocation;
import com.habib.sample.cosmosdb.model.PlantLocationNameResponse;
import com.habib.sample.cosmosdb.model.WorkerLocationRequest;
import com.habib.sample.cosmosdb.model.WorkerLocationResponse;
import com.habib.sample.cosmosdb.repository.PlantLocationNameRepository;
import com.habib.sample.cosmosdb.repository.WorkerRefDataCustomRepo;

@Service
public class WorkerReferenceDataService {

	private static final Logger logger = LoggerFactory.getLogger(WorkerReferenceDataService.class);

	private PlantLocationNameRepository repo;

	private WorkerRefDataCustomRepo customRepo;

	public WorkerReferenceDataService(PlantLocationNameRepository repo, WorkerRefDataCustomRepo customRepo) {
		this.repo = repo;
		this.customRepo = customRepo;
	}

	public void createPlantLocationNames() {

		customRepo.addPlantLocations(allPlantLocationNames());
	}

	private List<PlantLocationName> allPlantLocationNames() {

		List<PlantLocationName> plantLocations = new ArrayList<PlantLocationName>();
		plantLocations.add(new PlantLocationName("STHM", "STOCKHOLM"));
		plantLocations.add(new PlantLocationName("AMSN", "AMSTERDAM"));
		plantLocations.add(new PlantLocationName("LNDN", "LONDON"));
		return plantLocations;
	}

	public List<PlantLocationNameResponse> getPlantLocations(String plantName) {
		logger.info("Calling custom repo to fetch details based on plant name");
		var plantLocationsNames = customRepo.getPlantLocationsByName(plantName);
		List<PlantLocationNameResponse> responses = plantLocationsNames.stream().map(name -> {
			PlantLocationNameResponse plantLocationName = new PlantLocationNameResponse();
			plantLocationName.setPlantLocation(name.getPlantLocation());
			plantLocationName.setPlantName(name.getPlantName());
			return plantLocationName;
		}).collect(Collectors.toList());

		return responses;
	}

	public List<PlantLocationNameResponse> getPlantNames(String plantLocation) {
		logger.info("Calling default data  to fetch details based on plant name");
		var plantLocationsNames = repo.findByPlantLocation(plantLocation.toUpperCase());
		List<PlantLocationNameResponse> responses = plantLocationsNames.stream().map(name -> {
			PlantLocationNameResponse plantLocationName = new PlantLocationNameResponse();
			plantLocationName.setPlantLocation(name.getPlantLocation());
			plantLocationName.setPlantName(name.getPlantName());
			return plantLocationName;
		}).collect(Collectors.toList());

		return responses;
	}

	/**
	 * Method to add Worker Location in Cosmos DB reference data
	 * 
	 * @param WORKERID
	 * @param request
	 * @return
	 */
	public WorkerLocationResponse addWorkerLocation(String WORKERID, WorkerLocationRequest request) {

		WorkerLocation wl = new WorkerLocation(WORKERID, request.getLocation());
		var savedObject = customRepo.addWorkerLocation(wl);
		WorkerLocationResponse response = new WorkerLocationResponse();
		response.setWorkerid(savedObject.getWorkerid());
		response.setLocation(savedObject.getLocation());
		return response;
	}

	public WorkerLocationResponse getWorkerLocation(String WORKERID) {
		var wl = customRepo.getWorkerLocation(WORKERID);
		WorkerLocationResponse response = new WorkerLocationResponse();
		response.setWorkerid(wl.getWorkerid());
		response.setLocation(wl.getLocation());
		return response;
	}

}
