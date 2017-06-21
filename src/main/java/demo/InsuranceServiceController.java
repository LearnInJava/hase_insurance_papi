package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Money;
import demo.service.InsuranceService;


@RestController
@RequestMapping(value="/api")
public class InsuranceServiceController {
	
	@Autowired
	private InsuranceService insuranceService;
	
	@Autowired
	private ResponseEntity responseEntity;
	
	@RequestMapping(value="/obtain",method=RequestMethod.POST)
	public ResponseEntity getMoney (@RequestBody Money money){
		
		System.out.println(money.getType());
		System.out.println(money.getNumber());
		
		responseEntity = insuranceService.insuranceServiceProcess();
		
		return responseEntity;
	}
}
