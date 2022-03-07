package br.com.hdiseguros.hdisegurosms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hdiseguros.hdisegurosms.dto.ActiveDTO;
import br.com.hdiseguros.hdisegurosms.dto.CorretorDTO;
import br.com.hdiseguros.hdisegurosms.interfaces.BrokerDataService;
import br.com.hdiseguros.hdisegurosms.interfaces.BrokerService;
import br.com.hdiseguros.hdisegurosms.model.Broker;
import br.com.hdiseguros.hdisegurosms.model.BrokerData;

@Service
public class CorretorService {

	@Autowired
	private BrokerService brokerService;

	@Autowired
	private BrokerDataService brokerDataService;
	private CorretorDTO corretorDTO;
	private Broker broker;

	public CorretorDTO findByDocument(String document) {

		broker = brokerService.findBrokerByDocument(document);

		BrokerData brokerData = brokerDataService.findBrokerByCode(broker.getCode());

		if (brokerData.getActive().trim().equals("true")) {

			corretorDTO = new CorretorDTO();
			corretorDTO.setName(broker.getName());
			corretorDTO.setDocument(broker.getDocument());
			corretorDTO.setCode(broker.getCode());
			corretorDTO.setCreateDate(broker.getCreateDate());
			corretorDTO.setCommissionRate(brokerData.getCommissionRate());
			corretorDTO.setActive(brokerData.getActive());
		}

		return corretorDTO;
	}

	public BrokerData updateStatus(String document, ActiveDTO activeDTO) {
		
		broker = brokerService.findBrokerByDocument(document);
		
		BrokerData brokerData = brokerDataService.findBrokerByCode(broker.getCode());
				
		BrokerData newBrokerData = brokerDataService.updateStatus(brokerData.getCode(), activeDTO);
		
		return newBrokerData;

	}

}
