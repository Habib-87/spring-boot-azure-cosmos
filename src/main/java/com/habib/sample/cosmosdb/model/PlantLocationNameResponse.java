package com.habib.sample.cosmosdb.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Plant Name and Plant Location Response,Plant name is some code and location is some place")
public class PlantLocationNameResponse {
	
	private String plantName;
	private String plantLocation;
	
	@ApiModelProperty(example = "STHLM")
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	@ApiModelProperty(example = "Stockholm")
	public String getPlantLocation() {
		return plantLocation;
	}
	public void setPlantLocation(String plantLocation) {
		this.plantLocation = plantLocation;
	}

}
