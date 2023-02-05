package ftni.jwd59.Zavrsni.support;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftni.jwd59.Zavrsni.model.Korisnik;
import ftni.jwd59.Zavrsni.service.KorisnikService;
import ftni.jwd59.Zavrsni.web.dto.KorisnikDTO;

@Component
public class KorisnikDtoToKorisnik implements Converter<KorisnikDTO, Korisnik>{
	@Autowired
    private KorisnikService korisnikService;
	 @Override
	    public Korisnik convert(KorisnikDTO korisnikDTO) {
	        Korisnik entity = null;

	        if(korisnikDTO.getId() == null) {
	            entity = new Korisnik();
	        }else {
	            Optional<Korisnik> korisnikOptional = korisnikService.findOne(korisnikDTO.getId());
	            if(korisnikOptional.isPresent()){
	                entity = korisnikOptional.get();
	            }
	        }

	        if(entity != null) {
	            entity.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
	            entity.seteMail(korisnikDTO.geteMail());
	            entity.setIme(korisnikDTO.getIme());
	            entity.setPrezime(korisnikDTO.getPrezime());
	        }

	        return entity;
	    }
}
