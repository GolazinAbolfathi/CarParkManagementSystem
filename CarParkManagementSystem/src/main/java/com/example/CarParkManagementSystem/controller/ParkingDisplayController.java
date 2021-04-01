package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.model.Stall;
import com.example.CarParkManagementSystem.model.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParkingDisplayController {

    @RequestMapping("/stalls")
    public String homePage(Model model) {
    	List<Stall> stallItems = new ArrayList<Stall>();
    	
    	//insert dummy object
    	stallItems.add(new Stall(1,"11:23",0,1));
    	stallItems.add(new Stall(2,"11:43",31,1));
    	stallItems.add(new Stall(3,"11:63",4231,1));
    	stallItems.add(new Stall(4,"13:23",11,1));
    	stallItems.add(new Stall(5,"14:22",13,1));
    	stallItems.add(new Stall(6,"17:41",0,1));
    	model.addAttribute("stall", stallItems);
    			return "stalls";
    }


}
