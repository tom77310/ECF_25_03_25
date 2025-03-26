package com.example.TP_PayYouPayMe_17_03_25.data;
import java.time.LocalDate;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.TP_PayYouPayMe_17_03_25.model.Message;
import com.example.TP_PayYouPayMe_17_03_25.model.Transaction;
import com.example.TP_PayYouPayMe_17_03_25.model.Transfert;
import com.example.TP_PayYouPayMe_17_03_25.model.Utilisateur;
import com.example.TP_PayYouPayMe_17_03_25.repository.MessageRepository;
import com.example.TP_PayYouPayMe_17_03_25.repository.TransactionRepository;
import com.example.TP_PayYouPayMe_17_03_25.repository.TransfertRepository;
import com.example.TP_PayYouPayMe_17_03_25.repository.UtilisateurRepository;



@Configuration
public class DataInitializer {

	@Bean
	CommandLineRunner initDatabase(UtilisateurRepository utilisateurRepository,
			MessageRepository messageRepository,
			TransactionRepository transactionRepository,
			TransfertRepository transfertRepository) {
		return args -> {
			Utilisateur u1 = new Utilisateur();
			u1.setNom("firstNameU1");
			u1.setPrenom("LastNameU1");
			u1.setPseudo("user");
			u1.setLogin("usertest");
			u1.setIban("monIBAN");
			u1.setEmail("test1@test.com");
			u1.setMotDePasse("$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc.");
			u1.setRole("USER");
			u1.setSommeCompteDepart(30f);
			u1.setActif(true);
			utilisateurRepository.save(u1);

			Utilisateur u2 = new Utilisateur();
			u2.setNom("firstNameU2");
			u2.setPrenom("LastNameU2");
			u2.setPseudo("admin");
			u2.setMotDePasse("$2y$10$kp1V7UYDEWn17WSK16UcmOnFd1mPFVF6UkLrOOCGtf24HOYt8p1iC");
			u2.setRole("ADMIN");
			u2.setLogin("usertest2");
			u2.setIban("monIBAN");
			u2.setEmail("test2@test.com");
			u2.setSommeCompteDepart(20f);
			u2.setActif(true);
			utilisateurRepository.save(u2);

			Utilisateur u3 = new Utilisateur();
			u3.setNom("firstNameU3");
			u3.setPrenom("LastNameU3");
			u3.setPseudo("user3");
			u3.setMotDePasse("$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc.");
			u3.setLogin("usertest3");
			u3.setIban("monIBAN");
			u3.setEmail("test3@test.com");
			u3.setSommeCompteDepart(20f);
			u3.setActif(true);
			utilisateurRepository.save(u3);
			
			//user suspendu
			Utilisateur u4 = new Utilisateur();
			u4.setNom("firstNameU3");
			u4.setPrenom("LastNameU3");
			u4.setPseudo("user4");
			u4.setMotDePasse("$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc."); //mdp user
			u4.setLogin("usertest3");
			u4.setIban("monIBAN");
			u4.setEmail("test3@test.com");
			u4.setSommeCompteDepart(20f);
			u4.setRole("SUSPENDU");
			u4.setActif(true);
			
			utilisateurRepository.save(u4);

			u1.getContact().add(u2);
			
			utilisateurRepository.save(u1);

			
			Transaction t1 = new Transaction(20f, "pour les courses", LocalDate.now());
			t1.setEnvoyeurTransaction(u1);
			t1.setReceveurTransaction(u2);
			transactionRepository.save(t1);

			Transaction t2 = new Transaction(30f, "Transation 2", LocalDate.now());
			t2.setEnvoyeurTransaction(u2);
			t2.setReceveurTransaction(u1);
			transactionRepository.save(t2);
			
			Transaction t3 = new Transaction(20f, "Transaction 3", LocalDate.now());
			t3.setEnvoyeurTransaction(u1);
			t3.setReceveurTransaction(u2);
			transactionRepository.save(t3);
			
			Message m1 = new Message("message 1", LocalDate.now(), null);
			m1.setUtilisateur(u1);
			messageRepository.save(m1);
			
			Message m3 = new Message("message 3", LocalDate.now(), null);
			m3.setUtilisateur(u1);
			messageRepository.save(m3);
			
			Message m2 = new Message("message 2", LocalDate.now(), null);
			m2.setUtilisateur(u2);
			messageRepository.save(m2);
			
			
			Transfert transfert1 = new Transfert(10f, "transfert 1", LocalDate.now(), u1);
			Transfert transfert2  = new Transfert(-10f, "transfert 2", LocalDate.now(), u1);
			Transfert transfert3 = new Transfert(100f, "transfert 3", LocalDate.now(), u2);
			transfertRepository.save(transfert1);
			transfertRepository.save(transfert2);
			transfertRepository.save(transfert3);

		};
	}

}