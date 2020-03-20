package com.habib.sample.cosmosdb.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Request object to get location of a Worker and save it to database.Worker ID is being passed thorugh Path Variable")
public class WorkerLocationRequest {
	
	private String location;
	
	@ApiModelProperty(example = "Stockholm")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
