package th.co.maximus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.TmpInvoiceBean;
import th.co.maximus.dao.TmpInvoiceDao;
import th.co.maximus.service.TmpInvoiceService;

@Service
public class TmpInvoiceServiceImpl implements TmpInvoiceService{
	@Autowired
	private TmpInvoiceDao tmpInvoiceDao;
	@Override
	public void insertTmpInvoice(TmpInvoiceBean tmpInvoiceBean) {
		// TODO Auto-generated method stub
		tmpInvoiceDao.insertTmpInvoice(tmpInvoiceBean);
		
	}
	@Override
	public TmpInvoiceBean findByManualId(Integer manualId) {
		// TODO Auto-generated method stub
		return tmpInvoiceDao.findByManualId(manualId);
	}

}
