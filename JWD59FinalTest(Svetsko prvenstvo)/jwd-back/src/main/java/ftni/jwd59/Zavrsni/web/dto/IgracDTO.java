package ftni.jwd59.Zavrsni.web.dto;

public class IgracDTO {
	
	Long id;
	
	String ime;
	
	String prezime;
	
	int postignutiGolovi;

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

	public IgracDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}