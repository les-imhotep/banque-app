package dev;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BanqueTest {
	EntityManagerFactory emf;
	EntityManager em;

	@Before
	public void setUp() {
		// Ouverture de la connexion
		emf = Persistence.createEntityManagerFactory("banque-app");
		em = emf.createEntityManager();

	}

	@Test
	public void test() {

		// Banque
		Banque banque = new Banque();
		banque.setNom("CIC");

		// Adresse
		Adresse adresse = new Adresse();
		adresse.setNumero(35);
		adresse.setCodePostal(45100);
		adresse.setRue("de la vache");
		adresse.setVille("muette");

		// Client
		Client client = new Client();
		client.setBanque(banque);
		client.setAdresse(adresse);
		client.setDateNaissance(LocalDate.now());
		client.setNom("OUIn");
		client.setPrenom("Jean");

		// Compte
		Compte compte = new Compte();
		compte.setNumero("151331");

		compte.setClients(Arrays.asList(client));
		compte.setSolde(150);

		// Opération
		Operation operation = new Operation();
		operation.setCompte(compte);
		operation.setDate(LocalDateTime.now());
		operation.setMontant(1000);
		operation.setMotif("oui");

		compte.setOperations(Arrays.asList(operation));

		// Ajout des propriétés d'une opération

		// Ajout des propriétés d'un compte

		System.out.println(banque);

		// On met à jour la bdd
		EntityTransaction transaction = this.em.getTransaction();
		transaction.begin();
		this.em.persist(banque);
		this.em.persist(operation);
		this.em.persist(client);
		this.em.persist(compte);

		transaction.commit();

	}

	@After
	public void cleanUp() {
		// Fermeture de la connexion
		em.close();
		emf.close();
	}
}
