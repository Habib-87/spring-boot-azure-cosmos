package com.habib.sample.cosmosdb.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.habib.sample.cosmosdb.model.PlantLocationNameResponse;
import com.habib.sample.cosmosdb.model.WorkerLocationRequest;
import com.habib.sample.cosmosdb.model.WorkerLocationResponse;
import com.habib.sample.cosmosdb.service.WorkerReferenceDataService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/workersdata")
public class WorkerReferenceDataController {

	private WorkerReferenceDataService service;

	public WorkerReferenceDataController(WorkerReferenceDataService service) {
		this.service = service;
	}
	
	 @ApiOperation(value = "Get PlantLocationName by plant name", notes = "Pass the plant name(plant code) and and get the details about the Plant Location")
	 @ApiResponses({
         @ApiResponse(code = 200, message = "The Response object."),
         @ApiResponse(code = 401, message = "Authorization information is missing or invalid."),
         @ApiResponse(code = 404, message = "The specified plantname was not found.")
	 })
	@RequestMapping(value = "/plantname/{plantName}", method = RequestMethod.GET)
	public List<PlantLocationNameResponse> getPlantLocation(@PathVariable String plantName) {
		List<PlantLocationNameResponse> locs = service.getPlantLocations(plantName);
		return locs;
	}
	
	 @ApiOperation(value = "Get PlantLocationName by plant location", notes = "Pass the plant location and and get the details about the Plant name of the location")
	 @ApiResponses({
         @ApiResponse(code = 200, message = "The Response object."),
         @ApiResponse(code = 401, message = "Authorization information is missing or invalid."),
         @ApiResponse(code = 404, message = "The specified plantlocation was not found.")
	 })
	@RequestMapping(value = "/plantlocation/{plantLocation}", method = RequestMethod.GET)
	public List<PlantLocationNameResponse> getPlantName(@PathVariable String plantLocation) {
		List<PlantLocationNameResponse> locs = service.getPlantNames(plantLocation);
		return locs;
	}
	 @ApiOperation(value = "Get Worker Location by WorkerId", notes = "Allows to get the location of worker by passing the Worker Id")
	 @ApiResponses({
         @ApiResponse(code = 200, message = "The Response object."),
         @ApiResponse(code = 401, message = "Authorization information is missing or invalid."),
         @ApiResponse(code = 404, message = "The specified WORKERID was not found.")
	 })
	@RequestMapping(value = "{WORKERID}/workerlocation", method = RequestMethod.GET)
	public WorkerLocationResponse getWorkerLocation(@PathVariable String WORKERID) {
		return service.getWorkerLocation(WORKERID);
	}

	@ApiOperation(value = "Get Worker Locations", notes = "Allows to get the locations of all worker")
	@ApiResponses({
			@ApiResponse(code = 200, message = "The Response object."),
			@ApiResponse(code = 401, message = "Authorization information is missing or invalid."),
	})
	@RequestMapping(value = "/workerlocation", method = RequestMethod.GET)
	public List<WorkerLocationResponse> getWorkerLocations() {
		return service.getWorkerLocations();
	}
	 
	 @ApiOperation(value = "Add Worker Location by WorkerId", notes = "Allows to save the  worker location by passing the Worker Id in path variable")
	 @ApiResponses({
         @ApiResponse(code = 200, message = "The Response object."),
         @ApiResponse(code = 401, message = "Authorization information is missing or invalid.")
	 })
	@RequestMapping(value = "{WORKERID}/workerlocation", method = RequestMethod.POST)
	public WorkerLocationResponse addWorkerLocation(@PathVariable String WORKERID, @RequestBody WorkerLocationRequest request) {
		return service.addWorkerLocation(WORKERID,request);
	}
	/**
	 * Save the Plant Location and Name data while initializing the service.This is predefined refrence data so wants to save it before accessing it.
	 */
	@PostConstruct
	public void init() {
		service.createPlantLocationNames();
	}

	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ResponseEntity<String> getHealth() {
		return ResponseEntity.ok("Connection Successful");
	}

}
