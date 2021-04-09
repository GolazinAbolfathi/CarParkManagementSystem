package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.entity.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

public class DatabaseManager implements IDatabaseManager {

	MongoClient mc = MongoClients.create();
	MongoTemplate mt = new MongoTemplate(mc, "CarParking");
	MongoOperations mongoOperations = mt;

	@Override
	public ParkingPass getParkingPass(int passID) {
		initializeDatabase();
		try {
			return mongoOperations.findOne(new Query(Criteria.where("passId").is(passID)), ParkingPass.class);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ParkingLot getParkingLot(int parkingLotID) {
		initializeDatabase();
		try {
			return mongoOperations.findOne(new Query(Criteria.where("lotId").is(parkingLotID)), ParkingLot.class);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<ParkingLot> getParkingLots() {
		initializeDatabase();
		return mongoOperations.findAll(ParkingLot.class);

	}

	@Override
	public Invoice getInvoice(int invoiceID) {
		initializeDatabase();
		// return mongoOperations.findOne(new
		// Query(Criteria.where("invoiceId").is(invoiceID)), Invoice.class);
		return null;
	}

	@Override
	public User getUser(int userID) {
		initializeDatabase();
		try {
			return mongoOperations.findOne(new Query(Criteria.where("user_id").is(userID)), User.class);
		} catch (Exception e) {
			return null;
		}
	}
	public List<ParkingStall> getStalls() {
		initializeDatabase();
		try {
			return mongoOperations.findAll(ParkingStall.class);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public void createUser(User user) {
		initializeDatabase();
		try {
			mongoOperations.save(user);

		} catch (Exception e) {
		}
	}

	public void addParkingPass(ParkingPass pass) {
		initializeDatabase();
		try {
			mongoOperations.save(pass);

		} catch (Exception e) {
		}
	}

	@Override
	public void addParkingStall(ParkingStall stall) {
		initializeDatabase();
		try {
			mongoOperations.save(stall);
		} catch (Exception e) {
		}
	}

	@Override
	public void addParkingLot(ParkingLot lot) {
		initializeDatabase();
		try {
			mongoOperations.save(lot);
		} catch (Exception e) {
		}
	}

	@Override
	public void addInvoice(Invoice invoice) {
		initializeDatabase();
		try {
			mongoOperations.save(invoice);
		} catch (Exception e) {
		}
	}

	public void initializeDatabase() {
		mongoOperations.dropCollection("parkingStall");
		mongoOperations.dropCollection("parkingLot");
		if(!mongoOperations.collectionExists("parkingStall")) {
		ParkingLot pl = new ParkingLot(1);
		ParkingStall temp = new ParkingStall(pl);
		mongoOperations.save(pl);
		for(int x = 1; x<11; x++) {
			mongoOperations.save(temp);
			temp = new ParkingStall(pl);
			temp.setStallNumber(x+1);
		}

		}
		}
	}
