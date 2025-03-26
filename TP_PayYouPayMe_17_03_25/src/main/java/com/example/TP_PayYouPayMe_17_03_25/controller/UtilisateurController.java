package com.example.TP_PayYouPayMe_17_03_25.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.TP_PayYouPayMe_17_03_25.model.Utilisateur;
import com.example.TP_PayYouPayMe_17_03_25.service.UtilisateurService;


@Controller
@RequestMapping("/profil")
public class UtilisateurController {

	private final UtilisateurService utilisateurService;

	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	
	@GetMapping("/")
	public String getCurrentUser(Model model) {
		Utilisateur utilisateur = utilisateurService.getCurrentUser();
		model.addAttribute("userToDisplay", utilisateur);
		return "affichageUser";
	}
	
	@PostMapping("/saveutilisateur")
	public String saveUtilisateur(Model model,
			@ModelAttribute Utilisateur userToSave) {
		
		
		utilisateurService.updateUser(userToSave);
		
		Utilisateur utilisateur = utilisateurService.getCurrentUser();
		model.addAttribute("userToDisplay", utilisateur);
		return "AffichageUser";
	}
	
	@PostMapping("/suspendrecompte")
	public String supendreUtilisateur(Model model) {
		utilisateurService.suspendreCompte();
		return "acceuil";
	}
}