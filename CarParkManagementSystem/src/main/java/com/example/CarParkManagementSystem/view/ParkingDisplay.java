package com.example.CarParkManagementSystem.view;

import com.example.CarParkManagementSystem.controller.IParkingController;
import com.example.CarParkManagementSystem.controller.ParkingSystemController;
import com.example.CarParkManagementSystem.entity.ParkingLot;
import com.example.CarParkManagementSystem.entity.ParkingStall;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParkingDisplay {
	@Autowired
	private IParkingController controller;
	
    @RequestMapping("/stalls")
    public String homePage(Model model) {
    	controller = new ParkingSystemController();
		List<ParkingStall> stallItems = controller.getStallList();
		System.out.println(stallItems.size());
		for (ParkingStall s : stallItems)
			System.out.println(s);

    	model.addAttribute("stalls", stallItems);
    			return "stalls";
    } 
    @RequestMapping("/reservation")
    public String reservationPage(Model model, @RequestParam int stall, @RequestParam int lot) {
    	model.addAttribute("stallno", stall);
    	model.addAttribute("lotno", lot);
    	return "reservation";
    }
    @PostMapping("/reserveForm")
    public String  reserveStall(@RequestBody String postArgs, Model model) {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    	System.out.println(postArgs);
    	LocalDateTime now = LocalDateTime.now();
    	String time = dtf.format(now);
    	String[] args = postArgs.split("&");
		Dictionary<String, String> dict = new Hashtable<>();
		for (String s : args) {
			String[] pair = s.split("=");
			dict.put(pair[0], pair[1]);
		}
		dict.keys().asIterator().forEachRemaining(key -> {
			System.out.printf("%s: %s%n", key, dict.get(key));
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++)
			sb.append((char)((int)(Math.random() * 27) + 'A'));
		for (int i = 0; i < 3; i++)
			sb.append((char)((int)(Math.random() * 10) + '0'));
		controller.parkCar(
				Integer.parseInt(dict.get("lotid")),
				Integer.parseInt(dict.get("stallId")),
				Integer.parseInt(dict.get("minutesLeft")),
				sb.toString()
		);
        return "redirect:stalls";
    }
}
