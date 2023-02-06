package ftni.jwd59.Zavrsni.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import ftni.jwd59.Zavrsni.model.Reprezentacija;
import ftni.jwd59.Zavrsni.model.Utakmica;
import ftni.jwd59.Zavrsni.repository.UtakmicaRepository;
import ftni.jwd59.Zavrsni.service.UtakmicaService;

@Service
public class JpaUtakmicaService implements UtakmicaService{
	
	@Autowired
	private UtakmicaRepository repository;

	@Override
	public Page<Utakmica> find(Long reprezentacijaAId, Long reprezentacijaBId, Integer pageNo) {
		if(reprezentacijaAId == null) {
			repository.findByReprezentacijabId(reprezentacijaBId, PageRequest.of(pageNo, 3));
		}
		if(reprezentacijaBId == null) {
			repository.findByReprezentacijaaId(reprezentacijaAId, PageRequest.of(pageNo, 3));
		}
		return repository.findByReprezentacijaAIdAndReprezentacijaBId(reprezentacijaAId, reprezentacijaBId, PageRequest.of(pageNo, 3));
	}

	@Override
	public Utakmica findOneById(Long id) {
		return repository.findOneById(id);
	}

	@Override
	public Utakmica delete(Long id) {
		Utakmica u = repository.findOneById(id);
		if(u != null) {
			repository.deleteById(id);
			return u;
		}
		return null;
	}

	@Override
	public Utakmica save(Utakmica e) {
		return repository.save(e);
	}

	@Override
	public Utakmica update(Utakmica e) {
		return repository.save(e);
	}

	@Override
	public List<Utakmica> findAll() {
		return repository.findAll();
	}
	

	
	

}
