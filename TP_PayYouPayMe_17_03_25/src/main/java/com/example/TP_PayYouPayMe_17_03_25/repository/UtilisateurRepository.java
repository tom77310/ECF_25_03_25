package com.example.TP_PayYouPayMe_17_03_25.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TP_PayYouPayMe_17_03_25.model.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

    Optional<Utilisateur> findByPseudo(String pseudo);
  Optional<Utilisateur> findByLogin(String login);
}