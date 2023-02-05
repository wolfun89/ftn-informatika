package ftni.jwd59.Zavrsni.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Igrac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String ime;
	
	@Column(nullable = false)
	private String prezime;
	
	@Column
	private int postignutiGolovi;
	
	@ManyToOne
	private Reprezentacija reprezentacija;

	public Reprezentacija getReprezentacija() {
		return reprezentacija;
	}

	public void setReprezentacija(Reprezentacija reprezentacija) {
		this.reprezentacija = reprezentacija;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getPostignutiGolovi() {
		return postignutiGolovi;
	}

	public void setPostignutiGolovi(int postignutiGolovi) {
		this.postignutiGolovi = postignutiGolovi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ime, postignutiGolovi, prezime, reprezentacija);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Igrac other = (Igrac) obj;
		return Objects.equals(id, other.id) && Objects.equals(ime, other.ime)
				&& postignutiGolovi == other.postignutiGolovi && Objects.equals(prezime, other.prezime)
				&& Objects.equals(reprezentacija, other.reprezentacija);
	}

	@Override
	public String toString() {
		return "Igrac [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", postignutiGolovi=" + postignutiGolovi
				+ ", reprezentacija=" + reprezentacija + "]";
	}

	public Igrac() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}