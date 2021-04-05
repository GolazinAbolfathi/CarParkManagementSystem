package com.example.CarParkManagementSystem.controller;

import com.example.CarParkManagementSystem.model.Stall;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParkingDisplayController {
	
	List<Stall> stallItems = new ArrayList<Stall>();
	
    @RequestMapping("/stalls")
    public String homePage(Model model) {

    	
    	if(stallItems.isEmpty()) {
    	stallItems.add(new Stall(1,"11:23",0,1));
    	stallItems.add(new Stall(2,"11:43",31,1));
    	stallItems.add(new Stall(3,"11:63",4231,1));
    	stallItems.add(new Stall(4,"13:23",11,1));
    	stallItems.add(new Stall(5,"14:22",13,1));
    	stallItems.add(new Stall(6,"17:41",0,1));
    	}
    	//dummy data
    	model.addAttribute("stall", stallItems);
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
    	Stall tempStall = new Stall(Id, time, minutes, 1);
    	stallItems.set(Id-1, tempStall);
    	model.addAttribute("stall",stallItems);
        return "redirect:stalls";
    }
}
