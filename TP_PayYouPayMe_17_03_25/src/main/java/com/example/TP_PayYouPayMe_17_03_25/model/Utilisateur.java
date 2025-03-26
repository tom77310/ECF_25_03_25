package com.example.TP_PayYouPayMe_17_03_25.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String pseudo;
	private String nom;

	//@Column(name="Prenom")
	private String prenom;

	private String email;

	private String iban;

	private Float sommeCompteDepart;

	private String login;
	
	private String motDePasse;

	private String role;

	private boolean actif;
	
	private boolean confirmer;
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(Integer id, String pseudo, String nom, String prenom, String email, String iban,
			Float sommeCompteDepart, String login, String motDePasse, String role, boolean actif, List<Transfert> transferts,
			List<Transaction> transactionEnvoyer, List<Transaction> transactionRecue, List<Message> messageEnvoyer,
			List<Utilisateur> contact) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.iban = iban;
		this.sommeCompteDepart = sommeCompteDepart;
		this.login = login;
		this.motDePasse = motDePasse;
		this.role = role;
		this.actif = actif;
		this.transferts = transferts;
		this.transactionEnvoyer = transactionEnvoyer;
		this.transactionRecue = transactionRecue;
		this.messageEnvoyer = messageEnvoyer;
		this.contact = contact;
	}





	public Utilisateur(Integer id, String nom, String prenom, String email, String iban, 
			Float sommeCompteDepart, String login, String motDePasse, 
			List<Transaction> transactionEnvoyer, List<Transaction> transactionRecue,
			List<Message> messageEnvoyer, List<Utilisateur> contact, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.iban = iban;
		this.sommeCompteDepart = sommeCompteDepart;
		this.login = login;
		this.motDePasse = motDePasse;
		this.transactionEnvoyer = transactionEnvoyer;
		this.transactionRecue = transactionRecue;
		this.messageEnvoyer = messageEnvoyer;
		this.contact = contact;
		this.role = role;
	}

	public Utilisateur(Integer id, String pseudo, String nom, String prenom, String email, String iban,
			Float sommeCompteDepart, String motDePasse,  String login,
			List<Transaction> transactionEnvoyer, List<Transaction> transactionRecue,
			List<Message> messageEnvoyer, List<Utilisateur> contact, String role) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.iban = iban;
		this.sommeCompteDepart = sommeCompteDepart;
		this.login = login;
		this.motDePasse = motDePasse;
		this.transactionEnvoyer = transactionEnvoyer;
		this.transactionRecue = transactionRecue;
		this.messageEnvoyer = messageEnvoyer;
		this.contact = contact;
		this.role = role;
	}

	@OneToMany(mappedBy = "envoyeurTransfert")
	private List<Transfert> transferts = new ArrayList<Transfert>();
	
	@OneToMany(mappedBy = "envoyeurTransaction")
	private List<Transaction> transactionEnvoyer = new ArrayList<Transaction>();

	@OneToMany(mappedBy = "receveurTransaction")
	private List<Transaction> transactionRecue = new ArrayList<Transaction>();

	@OneToMany(mappedBy = "utilisateur")
	private List<Message> messageEnvoyer = new ArrayList<Message>();

	@ManyToMany
	private List<Utilisateur> contact = new ArrayList<Utilisateur>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Float getSommeCompteDepart() {
		return sommeCompteDepart;
	}

	public void setSommeCompteDepart(Float sommeCompteDepart) {
		this.sommeCompteDepart = sommeCompteDepart;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<Transaction> getTransactionEnvoyer() {
		return transactionEnvoyer;
	}

	public void setTransactionSent(List<Transaction> transactionEnvoyer) {
		this.transactionEnvoyer = transactionEnvoyer;
	}

	public List<Transaction> getTransactionRecue() {
		return transactionRecue;
	}

	public void setTransactionRecue(List<Transaction> transactionRecue) {
		this.transactionRecue = transactionRecue;
	}

	public List<Message> getMessageEnvoyer() {
		return messageEnvoyer;
	}

	public void setMessageEnvoyer(List<Message> messageEnvoyer) {
		this.messageEnvoyer = messageEnvoyer;
	}

	public List<Utilisateur> getContact() {
		return contact;
	}

	public void setContact(List<Utilisateur> contact) {
		this.contact = contact;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Transfert> getTransferts() {
		return transferts;
	}

	public void setTransferts(List<Transfert> transferts) {
		this.transferts = transferts;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public boolean isConfirmer() {
		return confirmer;
	}

	public void setConfirmer(boolean confirmer) {
		this.confirmer = confirmer;
	}

	
}