package th.co.maximus.service.impl;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;

import th.co.maximus.bean.MapGLBean;
import th.co.maximus.bean.MasterDataBean;
import th.co.maximus.bean.MasterDataSyncBean;
import th.co.maximus.bean.MasterDatasBean;
import th.co.maximus.bean.Principal;
import th.co.maximus.bean.UserBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.dao.MasterDataDao;
import th.co.maximus.service.CallEpisOnlineService;
import th.co.maximus.service.MapGLService;
import th.co.maximus.service.MasOfficerService;
import th.co.maximus.service.MasterDataService;
import th.co.maximus.util.GetMacAddress;

@Service
public class CallEpisOnlineServiceImp implements CallEpisOnlineService{
	
	@Value("${url.online}")
	private String url;
	private final SSLContext sslContext;
	private final SSLConnectionSocketFactory csf;
	private final HttpComponentsClientHttpRequestFactory requestFactory;
	RestTemplate restTemplate;
	
	@Autowired private MasterDataDao masterDataDao;

	
	@Autowired
	MasterDataService masterDataService;
	
	@Autowired
	MapGLService mapGLService;
	
	@Autowired
	MasOfficerService masOfficerService;

	
	public CallEpisOnlineServiceImp() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
		csf = new SSLConnectionSocketFactory(sslContext, new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});
		requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.custom().setSSLSocketFactory(csf).build());
		restTemplate = new RestTemplate(requestFactory);
	}

	@Override
	public void callOnline() {
		String mac =  GetMacAddress.getMACAddress();
		 String pos ="";
		 String posName="";
		 String branchArea="";
		 String branchCode="";
		 String taxIdCat="";
		 String costCenter="";
		String postUrl = url.concat("/offline/posByMac/"+ mac +".json"); 
		ResponseEntity<String> postResponse = restTemplate.getForEntity(postUrl, String.class);
		System.out.println("Response for Post Request: " + postResponse.getBody());
		try {
			JSONArray jsonArray = new JSONArray(postResponse.getBody());
			for(int i=0; i<jsonArray.length(); i++) {
				pos = jsonArray.getJSONObject(i).getString("no");
				posName = jsonArray.getJSONObject(i).getString("name");
				JSONObject  json = new JSONObject(jsonArray.getJSONObject(i).getString("shop"));
					branchCode = json.getString("businessPlace");
					branchArea = json.getString("businessArea");
					costCenter = json.getString("costCenter");
					taxIdCat = "0107546000229";
			}
			MasterDataBean masterDataPos = new MasterDataBean();
			masterDataPos.setKeyCode("POS");
			masterDataPos.setValue(pos);
			masterDataDao.insertInitProgram(masterDataPos);
			MasterDataBean masterDataPosName = new MasterDataBean();
			masterDataPosName.setKeyCode("POS_NAME");
			masterDataPosName.setValue(posName);
			masterDataDao.insertInitProgram(masterDataPosName);
			MasterDataBean masterDataBranchCode = new MasterDataBean();
			masterDataBranchCode.setKeyCode("BRANCH_CODE");
			masterDataBranchCode.setValue(branchCode);
			masterDataDao.insertInitProgram(masterDataBranchCode);
			MasterDataBean masterDataBranchArea = new MasterDataBean();
			masterDataBranchArea.setKeyCode("BRANCH_AREA");
			masterDataBranchArea.setValue(branchArea);
			masterDataDao.insertInitProgram(masterDataBranchArea);
			MasterDataBean masterDataCostCenter = new MasterDataBean();
			masterDataCostCenter.setKeyCode("COST_CENTER");
			masterDataCostCenter.setValue(costCenter);
			masterDataDao.insertInitProgram(masterDataCostCenter);
			MasterDataBean masterDatataxIdCat= new MasterDataBean();
			masterDatataxIdCat.setKeyCode("TAX_ID_CAT");
			masterDatataxIdCat.setValue(taxIdCat);
			masterDataDao.insertInitProgram(masterDatataxIdCat);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
//			groupKeys.add(Constants.MasterData.IBACSS_CANCEL_REASON); /**change*/
			groupKeys.add(Constants.MasterData.OTHER_CANCEL_REASON);
			groupKeys.add(Constants.MasterData.EDC_CREDIT_CARD_BANK);
			groupKeys.add(Constants.MasterData.CUSTOMER_SEGMENT);
			groupKeys.add(Constants.MasterData.IBACSS_WOIBACSS_CANCEL_REASON);
			
			
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
				masterDataSyncBean.setCreateDate(new Date());
				masterDataSyncBean.setUpdateBy( jsonArray.getJSONObject(i).getString("updateBy"));
				masterDataSyncBean.setUpdateDate(new Date());
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
				glBean.setErpInterfaceFlag(jsonArray.getJSONObject(i).getString("erpInterfaceFlag"));
				glBean.setCreateDate( new Date());
				glBean.setUpdateBy( jsonArray.getJSONObject(i).getString("updateBy"));
				glBean.setUpdateDate( new Date());
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
		 List<MasterDataBean> resultList = masterDataDao.findAllByGropType(Constants.INIT_PROJECT);
		Set<String> branchArea = new HashSet<String>();
		String branArea = "";
		String posno ="";
		 for (MasterDataBean masterDataBean : resultList) {
				if(masterDataBean.getValue().equals("POS")) {
					posno = masterDataBean.getText();
				}
				
				if(masterDataBean.getValue().equals("BRANCH_AREA")) {
					branArea = masterDataBean.getText();
				}
			}
		branchArea.add(branArea);
		
		try {
			UserBean userBean = new UserBean();
			Principal principal = new Principal(); 
			List<UserBean> list = new ArrayList<UserBean>();
			String gettUrl = url.concat("/offline/userSyncByArea/"+posno+".json");
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
