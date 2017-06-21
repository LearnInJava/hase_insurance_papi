package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import demo.QnectRespBean.QnectRespBean;

@Service
public class InsuranceService {
	
	@Autowired
	private QnectService qnectService;
	
	public ResponseEntity<?> insuranceServiceProcess(){
		//QnectService qnectService = new QnectService();
		QnectRespBean qnectRespBean = qnectService.process();
		ResponseEntity<?> responseEntity = new ResponseEntity(qnectRespBean , HttpStatus.OK);
		return responseEntity;

	}
	
}
