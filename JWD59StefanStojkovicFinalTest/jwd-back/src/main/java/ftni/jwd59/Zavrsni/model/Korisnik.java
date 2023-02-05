package ftni.jwd59.Zavrsni.model;

import java.util.Objects;

import javax.persistence.*;

import ftni.jwd59.Zavrsni.enumeration.KorisnickaUloga;

@Entity
public class Korisnik {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String korisnickoIme;

    @Column( unique = true, nullable = false)
    private String eMail;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(nullable = false)
    private String lozinka;

    @Enumerated(EnumType.STRING)
    private KorisnickaUloga uloga;


public Korisnik(){

}

public Korisnik(String korisnickoIme, String eMail, String ime, String prezime, String lozinka, KorisnickaUloga uloga) {
    this.korisnickoIme = korisnickoIme;
    this.eMail = eMail;
    this.ime = ime;
    this.prezime = prezime;
    this.lozinka = lozinka;
    this.uloga = uloga;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getKorisnickoIme() {
	return korisnickoIme;
}

public void setKorisnickoIme(String korisnickoIme) {
	this.korisnickoIme = korisnickoIme;
}

public String geteMail() {
	return eMail;
}

public void seteMail(String eMail) {
	this.eMail = eMail;
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

public String getLozinka() {
	return lozinka;
}

public void setLozinka(String lozinka) {
	this.lozinka = lozinka;
}

public KorisnickaUloga getUloga() {
	return uloga;
}

public void setUloga(KorisnickaUloga uloga) {
	this.uloga = uloga;
}

@Override
public int hashCode() {
	return Objects.hash(eMail, id, ime, korisnickoIme, lozinka, prezime, uloga);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Korisnik other = (Korisnik) obj;
	return Objects.equals(eMail, other.eMail) && Objects.equals(id, other.id) && Objects.equals(ime, other.ime)
			&& Objects.equals(korisnickoIme, other.korisnickoIme) && Objects.equals(lozinka, other.lozinka)
			&& Objects.equals(prezime, other.prezime) && uloga == other.uloga;
}

@Override
public String toString() {
	return "Korisnik [id=" + id + ", korisnickoIme=" + korisnickoIme + ", eMail=" + eMail + ", ime=" + ime
			+ ", prezime=" + prezime + ", lozinka=" + lozinka + ", uloga=" + uloga + "]";
}

}