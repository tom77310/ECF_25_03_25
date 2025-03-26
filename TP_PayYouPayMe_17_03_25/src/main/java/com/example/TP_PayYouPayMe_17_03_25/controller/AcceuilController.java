package com.example.TP_PayYouPayMe_17_03_25.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcceuilController {
	@GetMapping("/")
	public String Acceuil() {
		return "acceuil";
	}
	
}

