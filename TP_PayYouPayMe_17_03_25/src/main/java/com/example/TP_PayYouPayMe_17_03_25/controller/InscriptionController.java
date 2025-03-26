package com.example.TP_PayYouPayMe_17_03_25.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TP_PayYouPayMe_17_03_25.model.Utilisateur;
import com.example.TP_PayYouPayMe_17_03_25.service.UtilisateurService;

@Controller
public class InscriptionController {

	  private final PasswordEncoder passwordEncoder;
	    private final UtilisateurService utilisateurService;
	    
	    public InscriptionController(PasswordEncoder passwordEncoder,
	    		UtilisateurService utilisateurService) {
	    	this.passwordEncoder = passwordEncoder;
	    	this.utilisateurService = utilisateurService;
	    }
	@GetMapping("/inscription")
	public String getInscriptionPage(Model model) {
		model.addAttribute("user", new Utilisateur());
		return "inscription";
	}
	@PostMapping("/inscription")
	public String inscriptionFormulaire(Model model, @RequestParam String pseudo,
			@RequestParam String motDePasse, @RequestParam String nom, @RequestParam String prenom, @RequestParam Float sommeCompteDepart
			, @RequestParam String email, @RequestParam String iban, @RequestParam String login) {
		Utilisateur utilisateurToSave = new Utilisateur();
		utilisateurToSave.setNom(nom);
		utilisateurToSave.setPrenom(prenom);
		utilisateurToSave.setEmail(email);
		utilisateurToSave.setPseudo(pseudo);
		utilisateurToSave.setLogin(login);
		utilisateurToSave.setIban(iban);
		utilisateurToSave.setMotDePasse(passwordEncoder.encode(motDePasse));
		utilisateurToSave.setActif(true);
		utilisateurToSave.setSommeCompteDepart(sommeCompteDepart);
		utilisateurToSave.setRole("USER");
		utilisateurToSave.setConfirmer(false);
		utilisateurService.createUser(utilisateurToSave);		
		return "redirect:/";
	}
}