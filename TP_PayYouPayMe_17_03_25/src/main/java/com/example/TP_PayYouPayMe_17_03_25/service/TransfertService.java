package com.example.TP_PayYouPayMe_17_03_25.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TP_PayYouPayMe_17_03_25.model.Transfert;
import com.example.TP_PayYouPayMe_17_03_25.model.Utilisateur;
import com.example.TP_PayYouPayMe_17_03_25.repository.TransfertRepository;

@Service
public class TransfertService {

	private final TransfertRepository transfertRepository;
	private final UtilisateurService utilisateurService;
	
	public TransfertService(TransfertRepository transfertRepository,
			UtilisateurService utilisateurService) {
		this.transfertRepository = transfertRepository;
		this.utilisateurService = utilisateurService;
	}

	public List<Transfert> getAllTransferts() {
		return transfertRepository.findAll();
	}

	public void createTransfert(String messageTransfert, Float sommeTransfert) {
		Utilisateur utilisateur = utilisateurService.getCurrentUser();

		
		Transfert transfert = new Transfert();
		transfert.setSommeTransfert(sommeTransfert);
		transfert.setDate(LocalDate.now());
		transfert.setMessageTransfert(messageTransfert);
		transfert.setEnvoyeurTransfert(utilisateur);
		
		if(sommeTransfert<0 && utilisateur.getSommeCompteDepart() > Math.abs(sommeTransfert)) {
			utilisateur.setSommeCompteDepart(utilisateur.getSommeCompteDepart() - Math.abs(sommeTransfert));
		}
		else {
			utilisateur.setSommeCompteDepart(utilisateur.getSommeCompteDepart() + Math.abs(sommeTransfert));
		}
		
		utilisateurService.updateUser(utilisateur);
		transfertRepository.save(transfert);
	}
}