package ftni.jwd59.Zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import ftni.jwd59.Zavrsni.model.Utakmica;
import ftni.jwd59.Zavrsni.service.ReprezentacijaService;
import ftni.jwd59.Zavrsni.web.dto.ReprezentacijaDTO;
import ftni.jwd59.Zavrsni.web.dto.UtakmicaDTO;

@Component
public class UtakmicaToUtakmicaDTO implements Converter<Utakmica, UtakmicaDTO>{
	
	@Autowired
	private ReprezentacijaToReprezentacijaDTO toDTO;

	@Override
	public UtakmicaDTO convert(Utakmica u) {
		UtakmicaDTO dto = new UtakmicaDTO();
		
		dto.setId(u.getId());
		dto.setReprezentacijaA(toDTO.convert(u.getReprezentacijaA()));
		dto.setReprezentacijaB(toDTO.convert(u.getReprezentacijaB()));
		dto.setBrojGolovaA(u.getBrojGolovaA());
		dto.setBrojGolovaB(u.getBrojGolovaB());
		return dto;
	}

	public List<UtakmicaDTO> convert(List<Utakmica> utakmice) {
		List<UtakmicaDTO> dto = new ArrayList<>();
		
		for(Utakmica u : utakmice) {
			dto.add(convert(u));
		}
		
		return dto;
	}

}
