import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
		Banque banque = new Banque();
		Client client = new Client();
		Compte compte = new Compte();
		Adresse adresse = new Adresse();
		Operation operation = new Operation();

		ArrayList<Operation> operations = new ArrayList<Operation>();
		ArrayList<Client> clients = new ArrayList<Client>();

		clients.add(client);
		operations.add(operation);

		// Ajout des propriétés d'une opération
		operation.setCompte(compte);
		operation.setDate(LocalDateTime.now());
		operation.setMontant(1000);
		operation.setMotif("oui");
		// Ajout des propriétés d'une banque
		banque.setNom("CIC");
		// Ajout des propriétés d'une adresse
		adresse.setNumero(35);
		adresse.setCodePostal(45100);
		adresse.setRue("de la vache");
		adresse.setVille("muette");
		// Ajout des propriétés d'un compte
		compte.setBanque(banque);
		compte.setNumero("151331");
		compte.setOperations(operations);
		compte.setClients(clients);
		compte.setSolde(150);
		// Ajout des propriétés d'un client
		client.setAdresse(adresse);
		client.setDateNaissance(LocalDate.now());
		client.setNom("OUIn");
		client.setPrenom("Jean");
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
