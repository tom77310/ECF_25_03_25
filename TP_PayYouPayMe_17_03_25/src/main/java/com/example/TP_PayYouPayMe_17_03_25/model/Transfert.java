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
public class Transfert {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	private Float sommeTransfert;
	
	private String messageTransfert;
	private LocalDate date;

	@ManyToOne
	private Utilisateur envoyeurTransfert;
	
	public Transfert() {
		super();
	}

	
	
	public Transfert(Float sommeTransfert, String messageTransfert, LocalDate date, Utilisateur envoyeurTransfert) {
		super();
		this.sommeTransfert = sommeTransfert;
		this.messageTransfert = messageTransfert;
		this.date = date;
		this.envoyeurTransfert = envoyeurTransfert;
	}



	public Transfert(Integer id, Float sommeTransfert, String messageTransfert, LocalDate date, Utilisateur envoyeurTransfert) {
		super();
		this.id = id;
		this.sommeTransfert = sommeTransfert;
		this.messageTransfert = messageTransfert;
		this.date = date;
		this.envoyeurTransfert = envoyeurTransfert;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getSommeTransfert() {
		return sommeTransfert;
	}

	public void setSommeTransfert(Float sommeTransfert) {
		this.sommeTransfert = sommeTransfert;
	}

	public String getMessageTransfert() {
		return messageTransfert;
	}

	public void setMessageTransfert(String messageTransfert) {
		this.messageTransfert = messageTransfert;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Utilisateur getEnvoyeurTransaction() {
		return envoyeurTransfert;
	}

	public void setEnvoyeurTransfert(Utilisateur envoyeurTransfert) {
		this.envoyeurTransfert = envoyeurTransfert;
	}
	
	
	
	
}