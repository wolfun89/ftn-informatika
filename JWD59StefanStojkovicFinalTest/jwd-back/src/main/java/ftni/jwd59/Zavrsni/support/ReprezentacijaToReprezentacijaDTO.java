package ftni.jwd59.Zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftni.jwd59.Zavrsni.model.Igrac;
import ftni.jwd59.Zavrsni.model.Reprezentacija;
import ftni.jwd59.Zavrsni.web.dto.IgracDTO;
import ftni.jwd59.Zavrsni.web.dto.ReprezentacijaDTO;

@Component
public class ReprezentacijaToReprezentacijaDTO implements Converter<Reprezentacija, ReprezentacijaDTO>{

	@Override
	public ReprezentacijaDTO convert(Reprezentacija r) {
		ReprezentacijaDTO dto = new ReprezentacijaDTO();
		dto.setId(r.getId());
		dto.setNaziv(r.getNaziv());
		dto.setSkraceniNaziv(r.getSkraceniNaziv());
		return dto;
		
	}

	public List<ReprezentacijaDTO> convert(List<Reprezentacija> reprezentacije) {
		List<ReprezentacijaDTO> dto = new ArrayList<>();

        for(Reprezentacija r : reprezentacije) {
            dto.add(convert(r));
        }

        return dto;
	}

}
