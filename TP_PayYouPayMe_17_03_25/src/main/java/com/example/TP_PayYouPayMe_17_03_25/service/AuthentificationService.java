package com.example.TP_PayYouPayMe_17_03_25.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {

    /**
     * Récupère le nom d'utilisateur actuellement connecté
     * @return Le nom d'utilisateur (login) ou null si aucun utilisateur n'est connecté
     */
    public String getCurrentPseudo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        return null;
    }
}