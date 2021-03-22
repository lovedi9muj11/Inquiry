package th.co.inquiry.service;

import java.util.List;

import th.co.inquiryx.bean.BeanClass;

public interface ServiceClass {
	
	void insert();
	
	void delete();
	
	List<BeanClass> allBeanClass();
	
	String testMethod(String req);

}
