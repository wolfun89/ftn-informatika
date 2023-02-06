package ftni.jwd59.Zavrsni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftni.jwd59.Zavrsni.model.Reprezentacija;

@Repository
public interface ReprezentacijaRepository extends JpaRepository<Reprezentacija, Long>{

	Reprezentacija findOneById(Long id);
	
	

}
