package com.example.TP_PayYouPayMe_17_03_25.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.TP_PayYouPayMe_17_03_25.model.Transaction;
import com.example.TP_PayYouPayMe_17_03_25.model.Utilisateur;
import com.example.TP_PayYouPayMe_17_03_25.repository.TransactionRepository;
import com.example.TP_PayYouPayMe_17_03_25.repository.UtilisateurRepository;


@Service
public class TransactionService {

	private final TransactionRepository transactionRepository;
    private final AuthentificationService authService;
    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurService utilisateurService;
    
	public TransactionService(TransactionRepository transactionRepository,
			AuthentificationService authService,
			UtilisateurRepository utilisateurRepository,
			UtilisateurService utilisateurService) {
		this.transactionRepository = transactionRepository;
		this.authService = authService;
		this.utilisateurRepository = utilisateurRepository;
		this.utilisateurService = utilisateurService;
	}

	public List<Transaction> getAllTransactions() {
		
		return this.transactionRepository.findAll();
	}
	    
    public List<Transaction> getCurrentUserTransactions() {
        String username = authService.getCurrentPseudo();
        if (username != null) {
            return transactionRepository.findAllByUserLogin(username);
        }
        return Collections.emptyList();
    }
    
    public List<Transaction> getUserTransactions(Integer userId) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(userId);
        return utilisateur.map(u -> transactionRepository.findAllByUser(u))
                         .orElse(Collections.emptyList());
    }

	public void createTransaction(String pseudo, Float sommeTransaction, String contenuMessage) {
		Utilisateur envoyeurTransaction = utilisateurService.getCurrentUser();
		Utilisateur receveurTransaction = utilisateurService.getUserByPseudo(pseudo);
		
		if(envoyeurTransaction.getSommeCompteDepart() > sommeTransaction && sommeTransaction > 0 && receveurTransaction!=null) {
			Transaction transactionToCreate = new Transaction();
			transactionToCreate.setSommeTransaction(sommeTransaction);
			transactionToCreate.setDate(LocalDate.now());
			transactionToCreate.setContenuMessage(contenuMessage);
			transactionToCreate.setReceveurTransaction(receveurTransaction);
			transactionToCreate.setEnvoyeurTransaction(envoyeurTransaction);
			
			transactionRepository.save(transactionToCreate);
			receveurTransaction.setSommeCompteDepart(receveurTransaction.getSommeCompteDepart()+sommeTransaction);
			envoyeurTransaction.setSommeCompteDepart(envoyeurTransaction.getSommeCompteDepart()-sommeTransaction);
			utilisateurService.updateUser(receveurTransaction);
			utilisateurService.updateUser(envoyeurTransaction);
		}
		else {
			
		}
		
	}
}