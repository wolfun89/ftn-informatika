package ftni.jwd59.Zavrsni.service;

import java.util.List;

import org.springframework.data.domain.Page;

import ftni.jwd59.Zavrsni.model.Reprezentacija;
import ftni.jwd59.Zavrsni.model.Utakmica;

public interface UtakmicaService {

	Page<Utakmica> find(Long reprezentacijaAId, Long reprezentacijaBId, Integer pageNo);

	Utakmica findOneById(Long id);

	Utakmica delete(Long id);

	Utakmica save(Utakmica e);

	Utakmica update(Utakmica e);
	
	List<Utakmica> findAll();

}
