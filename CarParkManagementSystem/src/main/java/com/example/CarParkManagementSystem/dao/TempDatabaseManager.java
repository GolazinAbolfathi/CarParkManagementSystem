package com.example.CarParkManagementSystem.dao;

import com.example.CarParkManagementSystem.entity.*;
import com.example.CarParkManagementSystem.service.NewUserService;
import com.example.CarParkManagementSystem.service.NewUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TempDatabaseManager implements IDatabaseManager {
    private final ArrayList<ParkingLot> lots = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>();
    @Autowired
    private NewUserService newUserService;

    public TempDatabaseManager()
    {
        User user = new User(
                "Smatt",
                "Mithieson",
                "", "",
                "",
                "","",
                0);
        ParkingLot lot = new ParkingLot();
        lot.addParkingStall().parkCar("123456", 5);
        lot.addParkingStall().parkCar("EWA 705", 2);
        lot.addParkingStall();
        addParkingLot(lot);
//        createUser(user);
    }
    @Override
    public User getUser(int userID) {
        for (User u : users)
            if (u.getUser_id() == userID)
                return u;
        return null;
    }

    @Override
    public void createUser(User user) {
        // Make sure the user id doesn't conflict
//        if (users.size() > 0)
//            user.setUser_id(users.get(users.size() - 1).getUser_id() + 1);
//        users.add(user);

        List<String> emailList = newUserService.getAllEmails();
        String compareEmail = user.getEmail();
        if (emailList.contains(compareEmail)) {
            String failureMessage = "Already has the email address: " + compareEmail;
//            model.addAttribute("failureMessage", failureMessage);

        } else {
            String successMessage = "Successfully Sign Up";
//            model.addAttribute("successMessage", successMessage);
            newUserService.createNewUser(user);
        }
    }

    @Override
    public ParkingPass getParkingPass(int passID) {
        for (var lot : lots)
            for (var stall : lot.getParkingStalls()) {
                ParkingPass pass = stall.getParkingPass(passID);
                if (pass != null)
                    return pass;
            }
        return null;
    }

    @Override
    public ParkingLot getParkingLot(int parkingLotID) {
        for (var lot : lots)
            if (lot.getLotId() == parkingLotID)
                return lot;
        return null;
    }

    @Override
    public List<ParkingLot> getParkingLots() {
        return lots;
    }

    @Override
    public Invoice getInvoice(int passId) {
        ParkingPass pass = getParkingPass(passId);
        if (pass != null)
            return pass.getInvoice();
        return null;
    }

    @Override
    public void addParkingPass(ParkingPass pass) {
        // Make sure the parking lot has already been added
        ParkingLot lot = getParkingLot(
                pass.getParkingStall().getParkingLot().getLotId()
        );
        if (lot == null) {
            lot = pass.getParkingStall().getParkingLot();
            addParkingLot(lot);
        }
        // Make sure the parking stall has already been added
        ParkingStall stall = lot.getParkingStall(pass.getParkingStall().getStallNumber());
        if (stall == null) {
            stall = pass.getParkingStall();
            addParkingStall(stall);
        }

        // If the pass isn't added by now you fucked up
    }

    @Override
    public void addParkingStall(ParkingStall stall) {

    }

    @Override
    public void addParkingLot(ParkingLot lot) {
        lots.add(lot);
    }

    @Override
    public void addInvoice(Invoice invoice) {
        // Don't feel like it
    }
}
