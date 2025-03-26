package com.example.TP_PayYouPayMe_17_03_25.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TP_PayYouPayMe_17_03_25.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {

	private final MessageService messageService;

	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	
	@GetMapping("/")
	public String message(Model model) {
		model.addAttribute("messages", messageService.getMessageFromCurrentUser());
		return "message";
	}
	

	@PostMapping("/addmessage")
	public String addMessage(Model model, @RequestParam String contenu) {
		messageService.addMessage(contenu);
		
		
		model.addAttribute("messages", messageService.getMessageFromCurrentUser());
		return "message";
	}
}