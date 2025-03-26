package com.example.TP_PayYouPayMe_17_03_25.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TP_PayYouPayMe_17_03_25.service.TransactionService;
import com.example.TP_PayYouPayMe_17_03_25.service.UtilisateurService;


@Controller
@RequestMapping("/transaction")
public class TransactionController {

	
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    
    
	private final TransactionService transactionService;
	private final UtilisateurService utilisateurService;
	
	public TransactionController(TransactionService transactionService,
			UtilisateurService utilisateurService) {
		this.transactionService = transactionService;
		this.utilisateurService = utilisateurService;
	}
	
	
	@GetMapping("/")
	public String getTransaction(Model model) {
		model.addAttribute("utilisateur", utilisateurService.getCurrentUser());
		return "transaction";
	}
	
	@PostMapping("/createtransaction")
	public String createTransaction(Model model,
			@RequestParam String receveurTransaction,
			@RequestParam Float sommeTransaction,
			@RequestParam String contenuMessage) {
		logger.info("Tentative de création d'une transaction");
		transactionService.createTransaction(receveurTransaction, sommeTransaction, contenuMessage);
		model.addAttribute("utilisateur", utilisateurService.getCurrentUser());
		return "transaction";
	}
}