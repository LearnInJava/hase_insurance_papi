package demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import demo.model.Money;



@RestController
@RequestMapping(value="/api")
public class InsuranceServiceController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(InsuranceServiceController.class);
	
//	private ResponseEntity<?> responseEntity;
	
	@RequestMapping(value="/wechat",method=RequestMethod.GET)
	public String getMoney (HttpServletRequest request ,HttpServletResponse response) throws ClientProtocolException, IOException{
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://localhost:8080/api/dataServer");
		//Content-Type:application/x-www-form-urlencoded 
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username","admin"));
		params.add(new BasicNameValuePair("password","123456"));
		
		httpPost.setEntity(new UrlEncodedFormEntity(params,"utf-8"));
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		if(httpResponse.getStatusLine().getStatusCode()==200){
			HttpEntity entity = httpResponse.getEntity();
			String result = EntityUtils.toString(entity, "UTF-8");
			System.out.println(result);
		}
		
		return "access";
	}
	
	@ResponseBody
	@RequestMapping(value="/dataServer", method={RequestMethod.POST,RequestMethod.GET})
	public String getParams(@RequestBody Money money){
		String type = money.getType();
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", type);
		} catch (JSONException e) {
			e.printStackTrace();
		}
			
		return obj.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/reqdata" , method=RequestMethod.POST)
	public String getData(HttpServletResponse response){
		
		JSONObject object = new JSONObject();
		try {
			object.put("男一", "乐无异");
			object.put("女一", "闻人羽");
			object.put("男二", "夏夷则");
			object.put("女二", "阿阮");
		} catch (JSONException e) {
			LOGGER.error("error when combine json data, msg : "+ e.getMessage());
		}
		return object.toString();
	}
}
