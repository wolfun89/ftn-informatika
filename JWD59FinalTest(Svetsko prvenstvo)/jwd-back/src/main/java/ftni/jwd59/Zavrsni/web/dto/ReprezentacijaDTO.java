package ftni.jwd59.Zavrsni.web.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class ReprezentacijaDTO {
	
	Long id;
	
	@NotBlank
	String naziv;
	
	@Length(max = 3)
	@Length(min = 3)
	String skraceniNaziv;

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

	public ReprezentacijaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}