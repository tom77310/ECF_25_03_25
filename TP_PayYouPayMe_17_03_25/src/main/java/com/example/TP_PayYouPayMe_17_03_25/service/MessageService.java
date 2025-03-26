package com.example.TP_PayYouPayMe_17_03_25.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TP_PayYouPayMe_17_03_25.model.Message;
import com.example.TP_PayYouPayMe_17_03_25.model.Utilisateur;
import com.example.TP_PayYouPayMe_17_03_25.repository.MessageRepository;

@Service
public class MessageService {

	private final MessageRepository messageRepository;
	private final UtilisateurService utilisateurService;
	
	public MessageService(MessageRepository messageRepository,
			UtilisateurService utilisateurService) {
		this.messageRepository = messageRepository;
		this.utilisateurService = utilisateurService;
	}

	public List<Message> getAllMessages() {
		return this.messageRepository.findAll();
	}

	public List<Message> getMessageFromCurrentUser() {
		return utilisateurService.getCurrentUser().getMessageEnvoyer();
	}

	public void addMessage(String contenu) {
		Utilisateur utilisateur = utilisateurService.getCurrentUser();
		Message message = new Message();
		message.setContenu(contenu);
		message.setDate(LocalDate.now());
		message.setUtilisateur(utilisateur);
		
		messageRepository.save(message);
		
	}

	public void repondreMessage(int id, String contenu) {
		Message messageToUpdate = messageRepository.findById(id).orElse(null);
		if(messageToUpdate!=null) {
			messageToUpdate.setReponse(contenu);
			messageRepository.save(messageToUpdate);
		}
		
	}
}