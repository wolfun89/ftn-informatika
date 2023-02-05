package ftni.jwd59.Zavrsni.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Utakmica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Reprezentacija reprezentacijaA;
	
	@ManyToOne
	private Reprezentacija reprezentacijaB;
	
	@Column
	private int brojGolovaA;
	
	@Column
	private int brojGolovaB;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reprezentacija getReprezentacijaA() {
		return reprezentacijaA;
	}

	public void setReprezentacijaA(Reprezentacija reprezentacijaA) {
		if(this.reprezentacijaA.getId() != this.reprezentacijaB.getId()) {			
			this.reprezentacijaA = reprezentacijaA;
		}
	}

	public Reprezentacija getReprezentacijaB() {
		return reprezentacijaB;
	}

	public void setReprezentacijaB(Reprezentacija reprezentacijaB) {
		if(this.reprezentacijaA.getId() != this.reprezentacijaB.getId()) {			
			this.reprezentacijaB = reprezentacijaB;
		}
	}

	public int getBrojGolovaA() {
		return brojGolovaA;
	}

	public void setBrojGolovaA(int brojGolovaA) {
		this.brojGolovaA = brojGolovaA;
	}

	public int getBrojGolovaB() {
		return brojGolovaB;
	}

	public void setBrojGolovaB(int brojGolovaB) {
		this.brojGolovaB = brojGolovaB;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brojGolovaA, brojGolovaB, id, reprezentacijaA, reprezentacijaB);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utakmica other = (Utakmica) obj;
		return brojGolovaA == other.brojGolovaA && brojGolovaB == other.brojGolovaB && Objects.equals(id, other.id)
				&& Objects.equals(reprezentacijaA, other.reprezentacijaA)
				&& Objects.equals(reprezentacijaB, other.reprezentacijaB);
	}

	@Override
	public String toString() {
		return "Utakmica [id=" + id + ", reprezentacijaA=" + reprezentacijaA + ", reprezentacijaB=" + reprezentacijaB
				+ ", brojGolovaA=" + brojGolovaA + ", brojGolovaB=" + brojGolovaB + "]";
	}

	public Utakmica() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}