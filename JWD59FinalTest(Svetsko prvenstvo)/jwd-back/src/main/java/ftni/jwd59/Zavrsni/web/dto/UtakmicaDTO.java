package ftni.jwd59.Zavrsni.web.dto;

public class UtakmicaDTO {
	
	Long id;
	
	ReprezentacijaDTO reprezentacijaA;
	
	ReprezentacijaDTO reprezentacijaB;
	
	int brojGolovaA;
	
	int brojGolovaB;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReprezentacijaDTO getReprezentacijaA() {
		return reprezentacijaA;
	}

	public void setReprezentacijaA(ReprezentacijaDTO reprezentacijaA) {
		this.reprezentacijaA = reprezentacijaA;
	}

	public ReprezentacijaDTO getReprezentacijaB() {
		return reprezentacijaB;
	}

	public void setReprezentacijaB(ReprezentacijaDTO reprezentacijaB) {
		this.reprezentacijaB = reprezentacijaB;
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

	public UtakmicaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}