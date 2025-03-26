package com.example.TP_PayYouPayMe_17_03_25.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class DeconnexionController {

	@GetMapping("/deconnexion")
	public String Deconnexion() {
		return "redirect:/";
	}
	
}
