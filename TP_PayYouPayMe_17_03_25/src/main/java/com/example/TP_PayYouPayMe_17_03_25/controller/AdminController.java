package com.example.TP_PayYouPayMe_17_03_25.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.TP_PayYouPayMe_17_03_25.service.MessageService;
import com.example.TP_PayYouPayMe_17_03_25.service.TransactionService;
import com.example.TP_PayYouPayMe_17_03_25.service.UtilisateurService;



@Controller
@RequestMapping("/admin")
public class AdminController {
	private final MessageService messageService;
	private final TransactionService transactionService;
	private final UtilisateurService utilisateurService;
	
	public AdminController(MessageService messageService,
			TransactionService transactionService,
			UtilisateurService utilisateurService) {
		this.messageService = messageService;
		this.transactionService = transactionService;
		this.utilisateurService = utilisateurService;
	}

	
	@GetMapping("/donnéesAdmin")
	public String getAllDatas(Model model) {
		model.addAttribute("messages", messageService.getAllMessages());
		model.addAttribute("transactions", transactionService.getAllTransactions());
		model.addAttribute("utilisateurs", utilisateurService.getAllUtilisateurs());
		return "admin";
	}
	
	@PostMapping("/reponse")
	public String repondreMessage(Model model,  @RequestParam int id,
			@RequestParam String contenu) {
		messageService.repondreMessage(id, contenu);	
		model.addAttribute("messages", messageService.getAllMessages());
		model.addAttribute("transactions", transactionService.getAllTransactions());
		model.addAttribute("utilisateurs", utilisateurService.getAllUtilisateurs());
		return "admin";
	}
	
	@PostMapping("/desactiveruser")
	public String desactiverUser(Model model, @RequestParam int id) {
		utilisateurService.suspendreCompte(id);
		model.addAttribute("messages", messageService.getAllMessages());
		model.addAttribute("transactions", transactionService.getAllTransactions());
		model.addAttribute("utilisateurs", utilisateurService.getAllUtilisateurs());
		return "admin";
	}
	
	
	
}