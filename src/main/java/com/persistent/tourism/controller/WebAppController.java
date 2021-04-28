package com.persistent.tourism.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.persistent.tourism.entities.Booking;
import com.persistent.tourism.entities.MyUserDetails;
import com.persistent.tourism.entities.Pack;
import com.persistent.tourism.entities.TourismUser;
import com.persistent.tourism.services.BookingService;
import com.persistent.tourism.services.ContService;
import com.persistent.tourism.services.PackageService;


@Controller
public class WebAppController {
	
	@Autowired
	ContService contService;
	
	@Autowired
	PackageService packService;
	
	@Autowired
	BookingService bookingService;
	

	
	

	@GetMapping(path = "/")
	public String home() {
		return "home";
	}
	
	@GetMapping(path = "/home")
	public String home1() {
		return "home";
	}
	
	@GetMapping(path = "/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping(path = "/signup")
	public String signUp(Model model) {
		model.addAttribute("firstName", "First Name");
		model.addAttribute("lastName", "Last Name");
		model.addAttribute("mobNo", "Your Mobile No.");
		model.addAttribute("password", "1234");
		return "signup";
	}
	
	@PostMapping(path = "/signup")
	public String registerUser(Model model, @ModelAttribute TourismUser user) {
		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		if(contService.SaveUser(user)) {
			return "redirect:login";
		}
		return "redirect:signup?error";
	}
	
	@GetMapping(path = "/package")
	public String packages(Model model) {
		
		List<Pack> plist = new ArrayList<>();
		plist = packService.getAllPackages();
		model.addAttribute("places", plist);
		return "package";
	}
	//checking role of the user
	@GetMapping(path="/user/checkout")
	public String checkout(Model model, Authentication authentication,@RequestParam("pid") String packId) {
		model.addAttribute("name", "Hi " + ((MyUserDetails)(authentication.getPrincipal())).getFirstName());
		model.addAttribute("pid", packId);
		if(((MyUserDetails)(authentication.getPrincipal())).getFirstName().equals("ADMIN")) {
			return "redirect:/admin/package";}
		return "checkout";	
	}
	
	
	@GetMapping(path = "/user/home")
	public String userhome(Authentication authentication, Model model) {
		model.addAttribute("name", "Hi " + ((MyUserDetails)(authentication.getPrincipal())).getFirstName());
		
		if(((MyUserDetails)(authentication.getPrincipal())).getFirstName().equals("ADMIN")) {
			return "redirect:/admin/home";
		}

		return "userhome";
	}
	
	

	@GetMapping(path = "/user/package")
	public String userpackages(Model model, Authentication authentication) {
		List<Pack> plist = new ArrayList<>();
		plist = packService.getAllPackages();
		model.addAttribute("places", plist);
		model.addAttribute("name", "Hi " + ((MyUserDetails)(authentication.getPrincipal())).getFirstName());
		model.addAttribute("num",((MyUserDetails)(authentication.getPrincipal())).getMobileNo());
		return "userpackage";
	}
	
	//showall bookings
	@GetMapping(path="/user/dashboard")
	public String userBookingDetails(Model model,Authentication authentication) {
		String uid = ((MyUserDetails)(authentication.getPrincipal())).getMobileNo();
		model.addAttribute("name",((MyUserDetails)(authentication.getPrincipal())).getFirstName());
		model.addAttribute("bookings",bookingService.findByUser(uid));
		return "userBooking";
	}
	
	//cancel your bookings
	@GetMapping(path="/user/cancel")
	public String cancelBoking(Model model,@RequestParam("bid") int bid) {
		bookingService.deleteBooking(bid);
		return "redirect:/user/dashboard";
		
	}


	//order the package
	@PostMapping(path="/user/confirmation")
	public String confirmation(Model model, HttpServletRequest request,Authentication authentication, @RequestParam("pid") Long packId) {
		int p  =Integer.parseInt(request.getParameter("noOfPeople"));
		float Costp = packService.getPackageById(packId).getCost();
		float totalCost = p*Costp;
		Booking b= new Booking();
		b.setUid(((MyUserDetails)(authentication.getPrincipal())).getMobileNo());
		b.setPid((packId));
		b.setCost(totalCost);
		b.setName(request.getParameter("firstname"));
		b.setEmail(request.getParameter("email"));
		b.setNoOfPeople(p);
		b.setDate(java.time.LocalDate.now());
		bookingService.saveBooking(b);
		model.addAttribute("bid",b.getBid());
		model.addAttribute("price",totalCost );
		return "confirmation";
	}
	

	//delete account
	@GetMapping(path="/user/delete")
	public String userDelete(Model model, Authentication authentication) {
		bookingService.deleteByUser(((MyUserDetails)(authentication.getPrincipal())).getMobileNo());
		contService.deleteUser(((MyUserDetails)(authentication.getPrincipal())).getMobileNo());
		return "redirect:/home";
	}
	
	
}
