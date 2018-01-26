package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.BeanClass;

public interface ServiceClass {
	
	void insert();
	
	void delete();
	
	List<BeanClass> allBeanClass();
	
	String testMethod(String req);

}
