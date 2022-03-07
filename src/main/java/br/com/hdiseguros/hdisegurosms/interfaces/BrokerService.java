package br.com.hdiseguros.hdisegurosms.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.hdiseguros.hdisegurosms.model.Broker;

@FeignClient(url= "https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/broker" , name = "broker")
public interface BrokerService {
	
	@GetMapping("{document}")
    Broker findBrokerByDocument(@PathVariable("document") String document);
}
