
package com.habib.sample.cosmosdb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("cosmos-db-config")
public class PropertyConfig {
	
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getDburi() {
		return dburi;
	}
	public void setDburi(String dburi) {
		this.dburi = dburi;
	}
	private String dbname;
	private String dburi;
	
	
	
}

