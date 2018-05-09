package th.co.maximus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import th.co.maximus.bean.MapGLBean;

@Service
public interface MapGLService {
	
	String insertMapGL(List<MapGLBean> mapGLBeanList);
	
}
