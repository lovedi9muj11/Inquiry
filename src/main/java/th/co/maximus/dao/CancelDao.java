package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.DropDownBean;

public interface CancelDao {

	List<DropDownBean> reasonCancelIbacss();
	
	List<DropDownBean> reasonCancelOther();
	
}
