package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import demo.qnectRespBean.QnectRespBean;

@Service
public class QnectService {
	

	public QnectRespBean process(){
		
		QnectRespBean qnectRespBean = new QnectRespBean("msg");
		return qnectRespBean;
		
	}
	

}
