package ftni.jwd59.Zavrsni.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftni.jwd59.Zavrsni.model.Utakmica;

@Repository
public interface UtakmicaRepository extends JpaRepository<Utakmica, Long>{

	Utakmica findOneById(Long id);

	Page<Utakmica> findByReprezentacijaAIdAndReprezentacijaBId(Long reprezentacijaAId, Long reprezentacijaBId,
			Pageable p);

	Page<Utakmica> findByReprezentacijaAId(Long reprezentacijaAId, PageRequest of);

	Page<Utakmica> findByReprezentacijaBId(Long reprezentacijaBId, PageRequest of);
	
	

}
