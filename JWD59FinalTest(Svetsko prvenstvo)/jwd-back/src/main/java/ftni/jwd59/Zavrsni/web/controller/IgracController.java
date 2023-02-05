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


import ftni.jwd59.Zavrsni.model.Igrac;
import ftni.jwd59.Zavrsni.service.IgracService;
import ftni.jwd59.Zavrsni.support.IgracToIgracDTO;
import ftni.jwd59.Zavrsni.web.dto.IgracDTO;

@RestController
@RequestMapping(value = "/api/igraci", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class IgracController {

	@Autowired
	private IgracService service;
	
	@Autowired
	private IgracToIgracDTO toDTO;
	
//	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<IgracDTO>> getAll() {
	
		List<Igrac> igraci = service.findAll();
	
		return new ResponseEntity<>(toDTO.convert(igraci), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<IgracDTO> getOne(@PathVariable Long id){
		Igrac e = service.findOneById(id);

        if(e != null) {
            return new ResponseEntity<>(toDTO.convert(e), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}