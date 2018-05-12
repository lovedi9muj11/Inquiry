package th.co.maximus.dao;

import th.co.maximus.bean.MapGLBean;

public interface MapGLServiceDao {
	void insertMapGLService(MapGLBean mapGLBean);
	
	void deleteBeforInsert();
}
