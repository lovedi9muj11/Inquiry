package th.co.maximus.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import th.co.maximus.bean.MapGLBean;
import th.co.maximus.bean.MasterDataSyncBean;
import th.co.maximus.bean.Principal;
import th.co.maximus.bean.UserBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.service.CallEpisOnlineService;
import th.co.maximus.service.MapGLService;
import th.co.maximus.service.MasOfficerService;
import th.co.maximus.service.MasterDataService;

@Service
public class CallEpisOnlineServiceImp implements CallEpisOnlineService{
	
	@Value("${url.online}")
	private String url;
	
	@Value("${text.branarea}")
	private String branArea;
	
	@Autowired
	MasterDataService masterDataService;
	
	@Autowired
	MapGLService mapGLService;
	
	@Autowired
	MasOfficerService masOfficerService;

	RestTemplate restTemplate;
	
	public CallEpisOnlineServiceImp() {
		restTemplate = new RestTemplate();
	}

	@Override
	public void callOnline() {
//		String postUrl = url.concat("/test/test.json"); // /Maximus/Test
//		ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, new BeanClass(), String.class);
//		System.out.println("Response for Post Request: " + postResponse.getBody());		
	}

	@Override
	public void callOnlineSyncMasterData() {
		try {
			MasterDataSyncBean masterDataSyncBean = new MasterDataSyncBean();
			List<MasterDataSyncBean> list = new ArrayList<MasterDataSyncBean>();
			
			Set<String> groupKeys = new HashSet<String>();
			groupKeys.add(Constants.MasterData.BANK_TYPE);
			groupKeys.add(Constants.MasterData.BUSINESS_AREA);
			groupKeys.add(Constants.MasterData.OTHER_PAYMENT_UNIT);
			groupKeys.add(Constants.MasterData.VAT);
			groupKeys.add(Constants.MasterData.IBACSS_CANCEL_REASON);
			groupKeys.add(Constants.MasterData.OTHER_CANCEL_REASON);
			groupKeys.add(Constants.MasterData.EDC_CREDIT_CARD_BANK);
			
			String gettUrl = url.concat("/offline/masterDataSyncByGroupKey.json"); // /offline/insertPayment //masterdatasync1
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

	@Override
	public void callOnlineSyncMapGL() {
		try {
			MapGLBean glBean = new MapGLBean();
			List<MapGLBean> list = new ArrayList<MapGLBean>();
			String gettUrl = url.concat("/offline/mapGLServiceTypesync.json");
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

	@Override
	public void callOnlineSyncUser() {
		Set<String> branchArea = new HashSet<String>();
		branchArea.add(branArea);
		
		try {
			UserBean userBean = new UserBean();
			Principal principal = new Principal(); 
			List<UserBean> list = new ArrayList<UserBean>();
			String gettUrl = url.concat("/offline/userSyncByArea.json");
			ResponseEntity<String> getResponse = restTemplate.postForEntity(gettUrl, branchArea, String.class);
			
			JSONArray jsonArray = new JSONArray(getResponse.getBody());
			for(int i=0; i<jsonArray.length(); i++) {
				userBean = new UserBean();
				principal = new Principal();
				userBean.setName(jsonArray.getJSONObject(i).getString("givenName"));
				userBean.setSurName(jsonArray.getJSONObject(i).getString("familyName"));
				userBean.setUserName(jsonArray.getJSONObject(i).getString("name"));
				userBean.setPassword(jsonArray.getJSONObject(i).getString("password"));
				
				JSONObject object = jsonArray.getJSONObject(i).getJSONObject("principal");
				principal.setName(object.getString("name"));
				
				userBean.setPrincipal(principal);
				userBean.setLoginFlag(Constants.USER.LOGIN_FLAG_Y);
				list.add(userBean);
			}
			String respone = masOfficerService.insertMasOfficerUser(list);
			System.out.println(" Return Status for insert User respone :: " + respone);
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
