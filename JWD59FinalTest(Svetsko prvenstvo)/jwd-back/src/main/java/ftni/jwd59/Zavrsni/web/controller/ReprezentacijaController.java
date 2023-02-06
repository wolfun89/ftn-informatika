package ftni.jwd59.Zavrsni.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ftni.jwd59.Zavrsni.model.Reprezentacija;
import ftni.jwd59.Zavrsni.service.ReprezentacijaService;
import ftni.jwd59.Zavrsni.support.ReprezentacijaToReprezentacijaDTO;
import ftni.jwd59.Zavrsni.web.dto.ReprezentacijaDTO;

@RestController
@RequestMapping(value = "/api/reprezentacije", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ReprezentacijaController {

	@Autowired
	private ReprezentacijaService service;
	
	@Autowired
	private ReprezentacijaToReprezentacijaDTO toDTO;
	
//	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<ReprezentacijaDTO>> getAll() {
	
		List<Reprezentacija> reprezentacije = service.findAll();
	
		return new ResponseEntity<>(toDTO.convert(reprezentacije), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<ReprezentacijaDTO> getOne(@PathVariable Long id){
		Reprezentacija e = service.findOneById(id);

        if(e != null) {
            return new ResponseEntity<>(toDTO.convert(e), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}