package demo.qnectRespBean;

public class QnectRespBean {
	
	private String pubKey;
	
	private  String priKey;

	public String getPubKey() {
		return pubKey;
	}

	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}

	public String getPriKey() {
		return priKey;
	}

	public void setPriKey(String priKey) {
		this.priKey = priKey;
	}
	
	public QnectRespBean (String msg){
		
		pubKey = "%TFGHFDSCBV";
		priKey = "kjh*nbvdasd%";
	}
	
}
