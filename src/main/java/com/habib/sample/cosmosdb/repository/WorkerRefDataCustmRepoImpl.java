package com.habib.sample.cosmosdb.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import com.habib.sample.cosmosdb.datamodel.PlantLocationName;
import com.habib.sample.cosmosdb.datamodel.WorkerLocation;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * Impl class to handle customized method using MongoTemplate to do operation in Azure Cosmos Database
 * @author Habib Ahmed
 *
 */
@Repository
public class WorkerRefDataCustmRepoImpl implements WorkerRefDataCustomRepo {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkerRefDataCustmRepoImpl.class);
	
	
	MongoTemplate mongoTemplate;

	public WorkerRefDataCustmRepoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	/**
	 * Gets the plant location
	 */
	@Override
	public List<PlantLocationName> getPlantLocationsByName(String plantName) {
		logger.info("Query to get location by plantName {}",plantName);
		Query query = new Query();
		List<PlantLocationName>  plants = mongoTemplate.find(query.addCriteria(Criteria.where("plantName").is(plantName)),PlantLocationName.class);
		return plants;
	}

	@Override
	public WorkerLocation addWorkerLocation(WorkerLocation wl) {

		Query query = new Query();
		Update update = new Update();
		update.set("location", wl.getLocation());
		UpdateResult result = mongoTemplate.upsert(query.addCriteria(Criteria.where("workerid").is(wl.getWorkerid())), update,
				WorkerLocation.class);
		WorkerLocation savedObject = mongoTemplate.findOne(query, WorkerLocation.class);
		return savedObject;
	}


	@Override
	public WorkerLocation getWorkerLocation(String WORKERID) {
		logger.info("Query to get location of Worker {}",WORKERID);
		WorkerLocation wl = mongoTemplate.findById(WORKERID, WorkerLocation.class);
		return wl;
	}
	
	
	/**
	 * Adds PlantLocation. Using BulkOperations upsert method try to update if matches else
	 * insert.
	 * 
	 */

	@Override
	public void addPlantLocations(List<PlantLocationName> plantNames) {

		BulkOperations bulk = mongoTemplate.bulkOps(BulkMode.UNORDERED, PlantLocationName.class);
		bulk.upsert(prepareListofUpsert(plantNames));
		BulkWriteResult result = bulk.execute();
		logger.info("Number of matched count : " +result.getMatchedCount());
	}
	
	
	/**
	 * Prepares the data in List<Pair<Query, Update>> format to be used in BulkOpertaion.upsert() 
	 * @param plantNames
	 * @return
	 */
	private List<Pair<Query, Update>> prepareListofUpsert(List<PlantLocationName> plantNames) {

		List<Pair<Query, Update>> toUpsertList = new ArrayList<Pair<Query, Update>>();

		for (Iterator iterator = plantNames.iterator(); iterator.hasNext();) {
			PlantLocationName plantLocationName = (PlantLocationName) iterator.next();

			Query query = new Query();
			Update update = new Update();
			query.addCriteria(Criteria.where("plantName").is(plantLocationName.getPlantName()));
			update.set("plantLocation", plantLocationName.getPlantLocation());
			toUpsertList.add(Pair.of(query, update));
		}

		return toUpsertList;
	}
	

}
