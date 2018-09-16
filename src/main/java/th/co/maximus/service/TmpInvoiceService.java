package th.co.maximus.service;

import th.co.maximus.bean.TmpInvoiceBean;

public interface TmpInvoiceService {
	public void insertTmpInvoice(TmpInvoiceBean tmpInvoiceBean);
	public TmpInvoiceBean findByManualId(Integer manualId);

}
