package com.example.CarParkManagementSystem.view;

import com.example.CarParkManagementSystem.controller.IParkingController;
import com.example.CarParkManagementSystem.controller.ParkingSystemController;
import com.example.CarParkManagementSystem.entity.ParkingLot;
import com.example.CarParkManagementSystem.entity.ParkingStall;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParkingDisplay {

	private IParkingController controller;
	
    @RequestMapping("/stalls")
    public String homePage(Model model) {
    	controller = new ParkingSystemController();
		List<ParkingStall> stallItems = controller.getStallList();
		if (stallItems.isEmpty()) {
			ParkingLot temp = new ParkingLot();
			ParkingStall s = temp.addParkingStall();
			s.parkCar("12345", 3);
			stallItems.add(s);
			stallItems.add(temp.addParkingStall());
		}

		System.out.println(stallItems.size());
		for (ParkingStall s : stallItems)
			System.out.println(s);

    	model.addAttribute("stalls", stallItems);
    			return "stalls";
    } 
    @RequestMapping("/reservation")
    public String reservationPage(Model model, @RequestParam int stall) {
    	model.addAttribute("number", stall);
    	return "reservation";
    }
    @PostMapping("/reserveForm")
    public String  reserveStall(@RequestBody String stallId ,@RequestBody String Post,Model model) {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	LocalDateTime now = LocalDateTime.now();
    	String time = dtf.format(now);
    	String[] data = Post.split("&");
    	int Id = Integer.parseInt(data[0].replace("stallId=", ""));
    	int minutes = Integer.parseInt(data[1].replace("minutesLeft=", ""));
    	/*Stall tempStall = new Stall(Id, time, minutes, 1);
    	stallItems.set(Id-1, tempStall);
    	model.addAttribute("stall",stallItems);*/
        return "redirect:stalls";
    }
}
