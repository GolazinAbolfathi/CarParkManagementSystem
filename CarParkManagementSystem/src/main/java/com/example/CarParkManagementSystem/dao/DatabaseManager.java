package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.entity.User;
import com.example.CarParkManagementSystem.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

public class DatabaseManager implements IDatabaseManager {
	@Autowired
	MongoTemplate mt;
	MongoOperations mongoOperations = mt;

	@Override
	public ParkingPass getParkingPass(int passID) {
		try {
			return mongoOperations.findOne(new Query(Criteria.where("passId").is(passID)), ParkingPass.class);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ParkingLot getParkingLot(int parkingLotID) {
		try {
			return mongoOperations.findOne(new Query(Criteria.where("lotId").is(parkingLotID)), ParkingLot.class);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<ParkingLot> getParkingLots() {
		try {
			return mongoOperations.findAll(ParkingLot.class);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Invoice getInvoice(int invoiceID) {
		// return mongoOperations.findOne(new
		// Query(Criteria.where("invoiceId").is(invoiceID)), Invoice.class);
		return null;
	}

	@Override
	public User getUser(int userID) {
		try {
			return mongoOperations.findOne(new Query(Criteria.where("user_id").is(userID)), User.class);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void createUser(User user) {
		try {
			mongoOperations.insert(user);

		} catch (Exception e) {
		}
	}

	public void addParkingPass(ParkingPass pass) {
		try {
			mongoOperations.insert(pass);

		} catch (Exception e) {
		}
	}

	@Override
	public void addParkingStall(ParkingStall stall) {
		try {
			mongoOperations.insert(stall);
		} catch (Exception e) {
		}
	}

	@Override
	public void addParkingLot(ParkingLot lot) {
		try {
			mongoOperations.insert(lot);
		} catch (Exception e) {
		}
	}

	@Override
	public void addInvoice(Invoice invoice) {
		try {
			mongoOperations.insert(invoice);
		} catch (Exception e) {
		}
	}
}
