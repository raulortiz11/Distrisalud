package co.com.indra.distrisalud.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String inicio() 
	{
		return "master";		
	}

	
	
}
