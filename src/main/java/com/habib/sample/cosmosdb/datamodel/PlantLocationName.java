package com.habib.sample.cosmosdb.datamodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="PlantLocationName")
public class PlantLocationName {

	@Id
	private String id;
	private String plantName;
	private String plantLocation;

	public PlantLocationName(String plantName, String plantLocation) {
		this.plantName = plantName;
		this.plantLocation = plantLocation;
	}

	public PlantLocationName() {
	}

	@Override
	public String toString() {
		return "PlantLocationName [plantName=" + plantName + ", plantLocation=" + plantLocation + "]";
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantLocation() {
		return plantLocation;
	}

	public void setPlantLocation(String plantLocation) {
		this.plantLocation = plantLocation;
	}

}
