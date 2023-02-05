package ftni.jwd59.Zavrsni.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reprezentacija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String naziv;
	
	@Column(nullable = false, unique = true, length = 3)
	private String skraceniNaziv;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Igrac> igraci = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Utakmica> utakmice = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	public List<Igrac> getIgraci() {
		return igraci;
	}

	public void setIgraci(List<Igrac> igraci) {
		this.igraci = igraci;
	}

	public List<Utakmica> getUtakmice() {
		return utakmice;
	}

	public void setUtakmice(List<Utakmica> utakmice) {
		this.utakmice = utakmice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, igraci, naziv, skraceniNaziv, utakmice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reprezentacija other = (Reprezentacija) obj;
		return Objects.equals(id, other.id) && Objects.equals(igraci, other.igraci)
				&& Objects.equals(naziv, other.naziv) && Objects.equals(skraceniNaziv, other.skraceniNaziv)
				&& Objects.equals(utakmice, other.utakmice);
	}

	@Override
	public String toString() {
		return "Reprezentacija [id=" + id + ", naziv=" + naziv + ", skraceniNaziv=" + skraceniNaziv + ", igraci="
				+ igraci + ", utakmice=" + utakmice + "]";
	}

	public Reprezentacija() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}