package com.example.TP_PayYouPayMe_17_03_25.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TP_PayYouPayMe_17_03_25.model.Transaction;
import com.example.TP_PayYouPayMe_17_03_25.model.Utilisateur;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

    List<Transaction> findByEnvoyeurTransaction(Utilisateur envoyeurTransaction);
    List<Transaction> findByReceveurTransaction(Utilisateur receveurTransaction);
    
	 @Query("SELECT t FROM Transaction t WHERE t.envoyeurTransaction = :user OR t.receveurTransaction = :user ORDER BY t.date DESC")
	    List<Transaction> findAllByUser(@Param("user") Utilisateur user);
	 
	@Query("SELECT t FROM Transaction t JOIN t.envoyeurTransaction s JOIN t.receveurTransaction r WHERE s.login = :login OR r.login = :login ORDER BY t.date DESC")
    List<Transaction> findAllByUserLogin(@Param("login") String login);
}