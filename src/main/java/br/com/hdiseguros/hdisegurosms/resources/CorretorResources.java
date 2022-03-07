package br.com.hdiseguros.hdisegurosms.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hdiseguros.hdisegurosms.dto.ActiveDTO;
import br.com.hdiseguros.hdisegurosms.dto.CorretorDTO;
import br.com.hdiseguros.hdisegurosms.model.BrokerData;
import br.com.hdiseguros.hdisegurosms.service.CorretorService;

@RestController
@RequestMapping(path = "/api/v1/corretor", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CorretorResources {

	@Autowired
	private CorretorService corretorService;

	@GetMapping(value = "/find/{document}")
	public ResponseEntity<CorretorDTO> findByCodPaciente(@PathVariable("document") String document) {
		CorretorDTO corretorDTO = corretorService.findByDocument(document);
		return ResponseEntity.ok().body(corretorDTO);
	}
	
	@PutMapping(value = "/update-status/{document}")
	@ResponseBody 
	public ResponseEntity<BrokerData> updateStatus(@PathVariable("document") String document, @RequestBody ActiveDTO active ) {
		BrokerData newBrokerData = corretorService.updateStatus(document, active  );
		return ResponseEntity.ok().body(newBrokerData);
	}
}