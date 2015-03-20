package com.scheduler.process;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;


import com.wsdl.ConversionRate;
import com.wsdl.ConversionRateResponse;
import com.wsdl.Currency;
import com.wsdl.ObjectFactory;



@Component("synchronizeBean")
@Service 
public class SynchronizeBean {
	
	@Autowired    
	private WebServiceTemplate webServiceTemplate; 
	
	public void synchronize() {
		
		ConversionRate conversionRate = new ObjectFactory().createConversionRate();         
		conversionRate.setFromCurrency(Currency.GBP);         
		conversionRate.setToCurrency(Currency.USD);          
		ConversionRateResponse response = (ConversionRateResponse) webServiceTemplate.marshalSendAndReceive(conversionRate);
		System.out.println(response.getConversionRateResult());

		
	}
}
