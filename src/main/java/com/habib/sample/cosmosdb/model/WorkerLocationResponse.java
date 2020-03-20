package com.habib.sample.cosmosdb.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Location response of Worker. Data to show where a perticular working is working.")
public class WorkerLocationResponse {
	
	private String workerid;
	private String location;
	
	@ApiModelProperty(example = "Stockholm")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@ApiModelProperty(example = "HABAHM")
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}

}
