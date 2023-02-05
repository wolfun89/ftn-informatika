package ftni.jwd59.Zavrsni.service;

import java.util.List;

import ftni.jwd59.Zavrsni.model.Reprezentacija;

public interface ReprezentacijaService {

	List<Reprezentacija> findAll();

	Reprezentacija findOneById(Long id);

}
