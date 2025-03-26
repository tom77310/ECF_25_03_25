package com.example.TP_PayYouPayMe_17_03_25.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.TP_PayYouPayMe_17_03_25.model.Utilisateur;
import com.example.TP_PayYouPayMe_17_03_25.repository.UtilisateurRepository;


@Service
public class UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;
    private final AuthentificationService authService;

	public UtilisateurService(UtilisateurRepository utilisateurRepository,
			AuthentificationService authService) {
		this.utilisateurRepository = utilisateurRepository;
		this.authService = authService;
	}

    public Utilisateur getCurrentUser() {
        String pseudo = authService.getCurrentPseudo();
        if (pseudo != null) {
            Optional<Utilisateur> utilisateur = utilisateurRepository.findByPseudo(pseudo);
            return utilisateur.orElse(null);
        }
        return null;
    }
	
	
	public List<Utilisateur> getAllUtilisateurs() {
		return this.utilisateurRepository.findAll();
	}

	public void createUser(Utilisateur utilisateurToSave) {
		utilisateurRepository.save(utilisateurToSave);
	}
	
	public void updateUser(Utilisateur userToSave) {
		Utilisateur utilisateurToModify = getCurrentUser();
		utilisateurToModify.setNom(userToSave.getNom());
		utilisateurToModify.setPrenom(userToSave.getPrenom());
		utilisateurToModify.setEmail(userToSave.getEmail());
		utilisateurRepository.save(utilisateurToModify);
	
	}

	public void addUserToContactList(String pseudoToAdd) {
		Utilisateur userConnected = getCurrentUser();
		Utilisateur userToAdd = getUserByPseudo(pseudoToAdd);
		if(userToAdd!=null
				&& userToAdd!= userConnected
				&& !userConnected.getContact().contains(userToAdd)) {
			userConnected.getContact().add(userToAdd);
		}
		utilisateurRepository.save(userConnected);

	}
	
	public Utilisateur getUserByPseudo(String pseudotoadd) {
		return utilisateurRepository.findByPseudo(pseudotoadd).orElse(null);
	}

	public void deleteContactById(Integer id) {
		Utilisateur userConnected = getCurrentUser();
		Utilisateur contactToDelete = utilisateurRepository.findById(id).orElse(null);
		if(contactToDelete!=null) {
			userConnected.getContact().remove(contactToDelete);
		}
		utilisateurRepository.save(userConnected);
		
	}

	public void suspendreCompte() {
		Utilisateur userConnected = getCurrentUser();
		userConnected.setRole("SUSPENDU");
		utilisateurRepository.save(userConnected);		
	}

	public void suspendreCompte(int id) {
		Utilisateur utilisateurToSuspendre = utilisateurRepository.findById(id).get();
		utilisateurToSuspendre.setActif(false);
		utilisateurToSuspendre.setRole("SUSPENDU");
		utilisateurRepository.save(utilisateurToSuspendre);
		
	}
}