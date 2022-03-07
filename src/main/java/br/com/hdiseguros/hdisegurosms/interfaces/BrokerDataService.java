package br.com.hdiseguros.hdisegurosms.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.hdiseguros.hdisegurosms.dto.ActiveDTO;
import br.com.hdiseguros.hdisegurosms.model.BrokerData;

@FeignClient(url= "https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/brokerData" , name = "brokerData")
public interface BrokerDataService {
	
	@GetMapping("{code}")
    BrokerData findBrokerByCode(@PathVariable("code") String code);
	
	@PutMapping("{code}")
    BrokerData updateStatus(@PathVariable("code") String code, ActiveDTO activeDTO);

}
