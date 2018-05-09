package th.co.maximus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.MapGLBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.dao.MapGLServiceDao;
import th.co.maximus.service.MapGLService;

@Service
public class MapGLServiceImp implements MapGLService{

	@Autowired
	MapGLServiceDao mapGLServiceDao;
	
	@Override
	public String insertMapGL(List<MapGLBean> mapGLBeanList) {
		String statusResult = "";
		try {
			statusResult = Constants.MasterData.STATUS_SUCCESS;
			mapGLServiceDao.deleteBeforInsert();
			for(int i=0; i<mapGLBeanList.size(); i++) {
				mapGLServiceDao.insertMapGLService(mapGLBeanList.get(i));
			}
		}catch(Exception e) {
			statusResult = Constants.MasterData.STATUS_FAIL;
			e.printStackTrace();
		}
		return statusResult;
	}

}
