package ftni.jwd59.Zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftni.jwd59.Zavrsni.model.Igrac;
import ftni.jwd59.Zavrsni.web.dto.IgracDTO;

@Component
public class IgracToIgracDTO implements Converter<Igrac, IgracDTO>{

	@Override
	public IgracDTO convert(Igrac i) {
		IgracDTO dto = new IgracDTO();
		dto.setId(i.getId());
		dto.setIme(i.getIme());
		dto.setPostignutiGolovi(i.getPostignutiGolovi());
		return dto;
	}

	public List<IgracDTO> convert(List<Igrac> igraci) {
		List<IgracDTO> dto = new ArrayList<>();

        for(Igrac i : igraci) {
            dto.add(convert(i));
        }

        return dto;
	}

}
