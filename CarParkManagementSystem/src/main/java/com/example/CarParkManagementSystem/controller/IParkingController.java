package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.entity.*;

import java.util.List;

public interface IParkingController {
    /**
     * Parks a car in a stall
     * @param lotid Which parking lot to park at
     * @param stallNum Which stall to park in
     * @param plannedDuration How many hours will they be staying
     * @param plateNum License plate number for the car
     * @return A parking pass indicating the parked status
     */
    ParkingPass parkCar (int lotid, int stallNum, int plannedDuration, String plateNum);

    /**
     * Creates a new parking lot with an auto-generated ID.
     * @return The newly created parking lot
     */
    ParkingLot createLot();

    /**
     * Creates a stall in a given parking lot. A stall number will be auto generated
     * @param lotNum The parking lot id to create the stall for
     * @return The newly created parking stall
     */
    ParkingStall createStall (int lotNum);

    /**
     * Signal that the user is leaving the parking lot and generate an invoice
     * @param passId The parking pass to generate an invoice for
     * @return The generated invoice, still unpaid.
     */
    Invoice generateInvoice(int passId);

    /**
     * Pay for a given invoice with the chosen payment method
     * @param invoiceId Which invoice to pay for
     * @param paymentMethod How to pay
     * @return The invoice which got paid for
     */
    Invoice pay(int invoiceId, PaymentMethod paymentMethod);

    /**
     * Adds a new user
     * @param firstName
     * @param lastName
     * @param email
     * @param address
     * @param phoneNum
     * @param username
     * @param password
     * @param userType
     * @return
     */
    User addUser(String firstName,
                String lastName,
                String email,
                String address,
                String phoneNum,
                String username,
                String password,
                int userType);

    /**
     * Gets a list of all stalls available to the controller
     * @return A list of stalls
     */
    List<ParkingStall> getStallList();

    //SignIn
    User getUser(String username,
                 String password);
}
