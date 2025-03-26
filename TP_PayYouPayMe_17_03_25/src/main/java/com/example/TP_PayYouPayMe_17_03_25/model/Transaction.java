package com.example.TP_PayYouPayMe_17_03_25.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	private Float sommeTransaction;
	
	private String contenuMessage;
	private LocalDate date;

	@ManyToOne
	private Utilisateur envoyeurTransaction;

	@ManyToOne
	private Utilisateur receveurTransaction;

	
	
	
	public Transaction(Float sommeTransaction, String contenuMessage, LocalDate date) {
		super();
		this.sommeTransaction = sommeTransaction;
		this.contenuMessage = contenuMessage;
		this.date = date;
	}

	public Transaction() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getSommeTransaction() {
		return sommeTransaction;
	}

	public void setSommeTransaction(Float sommeTransaction) {
		this.sommeTransaction = sommeTransaction;
	}

	public String getContenuMessage() {
		return contenuMessage;
	}

	public void setContenuMessage(String contenuMessage) {
		this.contenuMessage = contenuMessage;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Utilisateur getEnvoyeurTransaction() {
		return envoyeurTransaction;
	}

	public void setEnvoyeurTransaction(Utilisateur envoyeurTransaction) {
		this.envoyeurTransaction = envoyeurTransaction;
	}

	public Utilisateur getReceveurTransaction() {
		return receveurTransaction;
	}

	public void setReceveurTransaction(Utilisateur receveurTransaction) {
		this.receveurTransaction = receveurTransaction;
	}

	
}