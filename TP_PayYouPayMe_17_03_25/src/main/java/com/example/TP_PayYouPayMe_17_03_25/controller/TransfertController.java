package com.example.TP_PayYouPayMe_17_03_25.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TP_PayYouPayMe_17_03_25.service.TransfertService;
import com.example.TP_PayYouPayMe_17_03_25.service.UtilisateurService;

@Controller
@RequestMapping("/transfert")
public class TransfertController {

	private final TransfertService transferService;
	private final UtilisateurService utilisateurService;

	public TransfertController(TransfertService transfertService,
			UtilisateurService utilisateurService) {
		this.transferService = transfertService;
		this.utilisateurService = utilisateurService;
	}
	
	
	@GetMapping("/")
	public String getTransfert(Model model) {
		model.addAttribute("utilisateur", utilisateurService.getCurrentUser());
		return "transfert";
	}
	
	@PostMapping("/createTransfert")
	public String createTransfert(Model model, @RequestParam String messageTransfert, @RequestParam Float sommeTransfert) {
		transferService.createTransfert(messageTransfert, sommeTransfert);
		
		model.addAttribute("utilisateur", utilisateurService.getCurrentUser());
		return "transfert";
	}
}