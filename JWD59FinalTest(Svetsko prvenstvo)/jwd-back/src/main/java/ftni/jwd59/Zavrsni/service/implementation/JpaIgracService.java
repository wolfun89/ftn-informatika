package ftni.jwd59.Zavrsni.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftni.jwd59.Zavrsni.model.Igrac;
import ftni.jwd59.Zavrsni.repository.IgracRepository;
import ftni.jwd59.Zavrsni.service.IgracService;

@Service
public class JpaIgracService implements IgracService{
	
	@Autowired
	private IgracRepository repository;

	@Override
	public List<Igrac> findAll() {
		return repository.findAll();
	}

	@Override
	public Igrac findOneById(Long id) {
		return repository.findOneById(id);
	}
	
	

}
