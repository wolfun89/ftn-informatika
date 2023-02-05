package ftni.jwd59.Zavrsni.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftni.jwd59.Zavrsni.model.Reprezentacija;
import ftni.jwd59.Zavrsni.model.Utakmica;
import ftni.jwd59.Zavrsni.service.UtakmicaService;
import ftni.jwd59.Zavrsni.support.UtakmicaDTOToUtakmica;
import ftni.jwd59.Zavrsni.support.UtakmicaToUtakmicaDTO;
import ftni.jwd59.Zavrsni.web.dto.UtakmicaDTO;

@RestController
@RequestMapping(value = "/api/utakmice", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class UtakmicaController {
	
	@Autowired
	private UtakmicaService service;
	
	@Autowired
	private UtakmicaToUtakmicaDTO toDTO;
	
	@Autowired
	private UtakmicaDTOToUtakmica toEntity;
	
//	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<UtakmicaDTO>> getAll(
					@RequestParam(required = false) Long reprezentacijaAId,
					@RequestParam(required = false) Long reprezentacijaBId,
					@RequestParam(value = "pageNo", defaultValue ="0") Integer pageNo) {
	
		Page<Utakmica> page = service.find(reprezentacijaAId, reprezentacijaBId, pageNo);
	
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
	
		return new ResponseEntity<>(toDTO.convert(page.getContent()), headers, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping("/{id}")
    public ResponseEntity<UtakmicaDTO> getOne(@PathVariable Long id){
        Utakmica e = service.findOneById(id);

        if(e != null) {
            return new ResponseEntity<>(toDTO.convert(e), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
		Utakmica e = service.delete(id);

        if(e != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UtakmicaDTO> update(@PathVariable Long id, @Valid @RequestBody UtakmicaDTO dto){

        if(!id.equals(dto.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Utakmica e = toEntity.convert(dto);
        Utakmica updated = service.update(e);

        return new ResponseEntity<>(toDTO.convert(updated),HttpStatus.OK);
    }
	
	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDTO> create(@Valid @RequestBody UtakmicaDTO dto) {
		Utakmica e = toEntity.convert(dto);
		Utakmica saved = service.save(e);
		
		return new ResponseEntity<>(toDTO.convert(saved), HttpStatus.CREATED);
	}
	
}