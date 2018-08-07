import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")

public class Compte {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "SOLDE")
	private double solde;

	@ManyToOne
	@JoinColumn(name = "NOM_BANQUE")
	private Banque banque;

	@ManyToMany
	@JoinTable(name = "COMPTE_CLIENT",

			joinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName =

			"ID"), inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName =

			"ID")

	)
	private List<Client> clients;

	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;

	public Compte() {
		operations = new ArrayList<Operation>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", banque=" + banque + ", operations="
				+ operations + ", clients=" + clients + "]";
	}

}
