package com.example.TP_PayYouPayMe_17_03_25.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TP_PayYouPayMe_17_03_25.model.Transfert;

@Repository
public interface TransfertRepository extends JpaRepository<Transfert, Integer>{

}