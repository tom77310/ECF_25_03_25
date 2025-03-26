package com.example.TP_PayYouPayMe_17_03_25.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TP_PayYouPayMe_17_03_25.service.UtilisateurService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	private final UtilisateurService utilisateurService;
	
	public ContactController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	
	
	@GetMapping("/")
	public String getContactPage(Model model) {
		model.addAttribute("contacts", utilisateurService.getCurrentUser().getContact());
		return "contact";
	}
	
	@PostMapping("/addcontact")
	public String addContact(Model model, @RequestParam("pseudotoadd") String pseudotoadd) {
		utilisateurService.addUserToContactList(pseudotoadd);
		model.addAttribute("contacts", utilisateurService.getCurrentUser().getContact());
		return "contact";
	}
	
	@PostMapping("/deletecontact")
	public String deleteContact(Model model, @RequestParam Integer id) {
		utilisateurService.deleteContactById(id);
		
		model.addAttribute("contacts", utilisateurService.getCurrentUser().getContact());
		return "contact";
	}
	
}