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
	MongoTemplate mt = new MongoTemplate(mc, "database");
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

	@Override
	public void createUser(User user) {
		initializeDatabase();
		try {
			mongoOperations.insert(user);

		} catch (Exception e) {
		}
	}

	public void addParkingPass(ParkingPass pass) {
		initializeDatabase();
		try {
			mongoOperations.insert(pass);

		} catch (Exception e) {
		}
	}

	@Override
	public void addParkingStall(ParkingStall stall) {
		initializeDatabase();
		try {
			mongoOperations.insert(stall);
		} catch (Exception e) {
		}
	}

	@Override
	public void addParkingLot(ParkingLot lot) {
		initializeDatabase();
		try {
			mongoOperations.insert(lot);
		} catch (Exception e) {
		}
	}

	@Override
	public void addInvoice(Invoice invoice) {
		initializeDatabase();
		try {
			mongoOperations.insert(invoice);
		} catch (Exception e) {
		}
	}

	public void initializeDatabase() {
		if (mongoOperations.collectionExists(ParkingLot.class)) {
			mongoOperations.dropCollection(ParkingLot.class);
			mongoOperations.dropCollection(ParkingStall.class);
			ParkingLot pl = new ParkingLot(1);
				pl.addParkingStall();
				pl.addParkingStall();
				pl.addParkingStall();
				pl.addParkingStall();
				pl.addParkingStall();
				pl.addParkingStall();
				pl.addParkingStall();
				pl.addParkingStall();
				pl.addParkingStall();
				pl.addParkingStall();
				pl.addParkingStall();
				pl.addParkingStall();
			try {
				mongoOperations.insert(pl);
				List<ParkingStall> lps = pl.getParkingStalls();
				for (int x = 0; x<pl.getStallCount(); x++) {
					mongoOperations.insert(lps.get(x));
					System.out.println(lps.get(x).getStallNumber());
				}
			} catch (Exception e) {
				// do nothing
			}
		}
	}
}
