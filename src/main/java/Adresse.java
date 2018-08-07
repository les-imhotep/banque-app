import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "ADRESSE")

public class Adresse {

	// @Column(name = "ID")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private int id;
	@Column(name = "NUMERO")

	private int numero;
	@Column(name = "RUE")
	private String rue;
	@Column(name = "CPDE_POSTAL")
	private int codePostal;
	@Column(name = "VILLE")
	private String Ville;

	// public int getId() {
	// return id;
	// }
	//
	// public void setId(int id) {
	// this.id = id;
	// }

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + ", numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", Ville="
				+ Ville + "]";
	}
}
