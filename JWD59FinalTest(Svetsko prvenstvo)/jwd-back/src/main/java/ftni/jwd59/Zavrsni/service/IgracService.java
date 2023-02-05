package ftni.jwd59.Zavrsni.service;

import java.util.List;

import ftni.jwd59.Zavrsni.model.Igrac;

public interface IgracService {

	List<Igrac> findAll();

	Igrac findOneById(Long id);

}
