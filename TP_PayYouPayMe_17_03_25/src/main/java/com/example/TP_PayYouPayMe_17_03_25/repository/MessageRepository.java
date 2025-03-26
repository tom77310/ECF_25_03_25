package com.example.TP_PayYouPayMe_17_03_25.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TP_PayYouPayMe_17_03_25.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

}