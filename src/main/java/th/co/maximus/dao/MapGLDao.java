package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.MapGLBean;

public interface MapGLDao {
	
	List<MapGLBean> findAll();
	List<MapGLBean> findByRevenuType(String revennuId);
	List<MapGLBean> findBySource(String source);
	List<MapGLBean> findBySourceAll(String source);
	List<MapGLBean> findBySourceOther();
	List<MapGLBean> findByServiceSource(String revennuId);
	List<MapGLBean> findBySourceOtherProdCode(String prodCode);

}
