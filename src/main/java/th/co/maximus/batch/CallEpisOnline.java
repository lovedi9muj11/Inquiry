package th.co.maximus.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import th.co.maximus.service.CallEpisOnlineService;

@RestController
public class CallEpisOnline {

	@Autowired
	CallEpisOnlineService callEpisOnlineService;

	public void callOnline() {
		try {
			callEpisOnlineService.callOnline();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/syncMasterData", method = RequestMethod.GET, produces = "application/json")
	public Map<String, String> callOnlineSyncMasterData() {
		try {
			callEpisOnlineService.callOnlineSyncMasterData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("result", "SUCCESS");
		return result;

	}

	@RequestMapping(value = "/syncMapGL", method = RequestMethod.GET, produces = "application/json")
	public Map<String, String> callOnlineSyncMapGL() {
		try {
			callEpisOnlineService.callOnlineSyncMapGL();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("result", "SUCCESS");
		return result;
	}

	@RequestMapping(value = "/syncUser", method = RequestMethod.GET, produces = "application/json")
	public Map<String, String> callOnlineSyncUser() {
		try {
			callEpisOnlineService.callOnlineSyncUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("result", "SUCCESS");
		return result;
	}

}
