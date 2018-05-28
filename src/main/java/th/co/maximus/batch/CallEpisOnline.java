package th.co.maximus.batch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import th.co.maximus.bean.BeanClass;
import th.co.maximus.bean.MapGLBean;
import th.co.maximus.bean.MasterDataSyncBean;
import th.co.maximus.bean.UserBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.service.MapGLService;
import th.co.maximus.service.MasterDataService;

@Controller
public class CallEpisOnline {
	
	@Value("${url.online}")
	private String url;
	
	@Autowired
	MasterDataService masterDataService;
	
	@Autowired
	MapGLService mapGLService;

	RestTemplate restTemplate;
	
	public CallEpisOnline() {
		restTemplate = new RestTemplate();
	}
	
	public void callOnline(){
		try {
			String postUrl = url.concat("/EpisWeb/test/test.json"); // /Maximus/Test
			ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, new BeanClass(), String.class);
			System.out.println("Response for Post Request: " + postResponse.getBody());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void callOnlineSyncMasterData(){
		try {
			MasterDataSyncBean masterDataSyncBean = new MasterDataSyncBean();
			List<MasterDataSyncBean> list = new ArrayList<MasterDataSyncBean>();
			
			Set<String> groupKeys = new HashSet<String>();
			groupKeys.add(Constants.MasterData.BANK_TYPE);
			groupKeys.add(Constants.MasterData.BUSINESS_AREA);
			groupKeys.add(Constants.MasterData.OTHER_PAYMENT_UNIT);
			
			String gettUrl = url.concat("/EpisWeb/offline/masterDataSyncByGroupKey.json"); // /offline/insertPayment //masterdatasync1
			ResponseEntity<String> getResponse = restTemplate.postForEntity(gettUrl, groupKeys, String.class);
			JSONArray jsonArray = new JSONArray(getResponse.getBody());
			for(int i=0; i<jsonArray.length(); i++) {
				masterDataSyncBean = new MasterDataSyncBean();
//				masterDataSyncBean.setId( jsonArray.getJSONObject(i).getLong("id") );
				masterDataSyncBean.setKey( jsonArray.getJSONObject(i).getString("key"));
				masterDataSyncBean.setValue( jsonArray.getJSONObject(i).getString("value"));
				masterDataSyncBean.setGroupKey( jsonArray.getJSONObject(i).getString("groupKey"));
				masterDataSyncBean.setType( jsonArray.getJSONObject(i).getString("type"));
				masterDataSyncBean.setStatus( jsonArray.getJSONObject(i).getString("status"));
				masterDataSyncBean.setOrdered( jsonArray.getJSONObject(i).getString("ordered"));
				masterDataSyncBean.setParentId( jsonArray.getJSONObject(i).getString("parentId"));
				masterDataSyncBean.setRefId( jsonArray.getJSONObject(i).getString("refId"));
				masterDataSyncBean.setProperty1( jsonArray.getJSONObject(i).getString("property1"));
				masterDataSyncBean.setProperty2( jsonArray.getJSONObject(i).getString("property2"));
				masterDataSyncBean.setProperty3( jsonArray.getJSONObject(i).getString("property3"));
				masterDataSyncBean.setProperty4( jsonArray.getJSONObject(i).getString("property4"));
				masterDataSyncBean.setProperty5( jsonArray.getJSONObject(i).getString("property5"));
				masterDataSyncBean.setCreateBy( jsonArray.getJSONObject(i).getString("createBy"));
				masterDataSyncBean.setCreateDate(null);
				masterDataSyncBean.setUpdateBy( jsonArray.getJSONObject(i).getString("updateBy"));
				masterDataSyncBean.setUpdateDate(null);
				masterDataSyncBean.setInitialValue( jsonArray.getJSONObject(i).getString("initialValue"));
				list.add(masterDataSyncBean);
			}
			
			System.out.println("Response for Post Request: " + getResponse.getBody().length() + " data " + getResponse.getBody());
			
			
			String respone = masterDataService.insertMasterDataSync(list);
			System.out.println(" Return Status for insert Master Data respone :: " + respone);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void callOnlineSyncMapGL(){
		try {
			MapGLBean glBean = new MapGLBean();
			List<MapGLBean> list = new ArrayList<MapGLBean>();
			String gettUrl = url.concat("/EpisWeb/offline/mapGLServiceTypesync.json");
			ResponseEntity<String> getResponse = restTemplate.getForEntity(gettUrl, String.class);
			
			JSONArray jsonArray = new JSONArray(getResponse.getBody());
			for(int i=0; i<jsonArray.length(); i++) {
				glBean = new MapGLBean();
				glBean.setGlCode( jsonArray.getJSONObject(i).getString("glCode"));
				glBean.setProductCode( jsonArray.getJSONObject(i).getString("productCode"));
				glBean.setProductName( jsonArray.getJSONObject(i).getString("productName"));
				glBean.setSubProductCode( jsonArray.getJSONObject(i).getString("subProductCode"));
				glBean.setSubProductName( jsonArray.getJSONObject(i).getString("subProductName"));
				glBean.setServiceName( jsonArray.getJSONObject(i).getString("serviceName"));
				glBean.setRevenueTypeCode( jsonArray.getJSONObject(i).getString("revenueTypeCode"));
				glBean.setRevenueTypeName( jsonArray.getJSONObject(i).getString("revenueTypeName"));
				glBean.setSegMentCode( jsonArray.getJSONObject(i).getString("segmentCode"));
				glBean.setSegMentName( jsonArray.getJSONObject(i).getString("segmentName"));
				glBean.setSource( jsonArray.getJSONObject(i).getString("source"));
				glBean.setServiceCode( jsonArray.getJSONObject(i).getString("serviceCode"));
				glBean.setStatus( jsonArray.getJSONObject(i).getString("status"));
				glBean.setCreateBy( jsonArray.getJSONObject(i).getString("createBy"));
				glBean.setUpdateBy( jsonArray.getJSONObject(i).getString("updateBy"));
				list.add(glBean);
			}
			String respone = mapGLService.insertMapGL(list);
			System.out.println(" Return Status for insert GL Data respone :: " + respone);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void callOnlineSyncUser(){
		try {
			UserBean userBean = new UserBean();
			List<UserBean> list = new ArrayList<UserBean>();
			String gettUrl = url.concat("/EpisWeb/offline/userSyncByArea.json");
			ResponseEntity<String> getResponse = restTemplate.getForEntity(gettUrl, String.class);
			
			JSONArray jsonArray = new JSONArray(getResponse.getBody());
			for(int i=0; i<jsonArray.length(); i++) {
				userBean = new UserBean();
//				glBean.setGlCode( jsonArray.getJSONObject(i).getString("glCode"));
				list.add(userBean);
			}
//			String respone = mapGLService.insertMapGL(list);
			System.out.println(" Return Status for insert User respone :: " + "respone");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
