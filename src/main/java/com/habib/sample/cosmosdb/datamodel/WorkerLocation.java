package com.habib.sample.cosmosdb.datamodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="WorkerLocation")
public class WorkerLocation {
	
	@Id
	private String workerid;
	private String location;
	
	
	public WorkerLocation(String workerid, String location) {
		super();
		this.workerid = workerid;
		this.location = location;
	}
	
	
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
