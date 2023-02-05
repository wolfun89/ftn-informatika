package ftni.jwd59.Zavrsni.support;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import ftni.jwd59.Zavrsni.model.Utakmica;
import ftni.jwd59.Zavrsni.service.ReprezentacijaService;
import ftni.jwd59.Zavrsni.service.UtakmicaService;
import ftni.jwd59.Zavrsni.web.dto.UtakmicaDTO;

@Component
public class UtakmicaDTOToUtakmica implements Converter<UtakmicaDTO, Utakmica>{
	
	@Autowired
	private UtakmicaService utakmicaService;
	
	@Autowired
	private ReprezentacijaService reprezentacijaService;

	@Override
	public Utakmica convert(UtakmicaDTO dto) {
		Utakmica utakmica;
		
		if(dto.getId() == null){
            utakmica = new Utakmica();
        }else{
            utakmica = utakmicaService.findOneById(dto.getId());
        }
		if(utakmica != null && 
				(!(utakmica.getReprezentacijaA().getId().equals(utakmica.getReprezentacijaB().getId())))) {
			utakmica.setReprezentacijaA(reprezentacijaService.findOneById(dto.getReprezentacijaA().getId()));
			utakmica.setReprezentacijaB(reprezentacijaService.findOneById(dto.getReprezentacijaB().getId()));
			utakmica.setBrojGolovaA(0);
			utakmica.setBrojGolovaB(0);
		}
		return utakmica;
	}

}
