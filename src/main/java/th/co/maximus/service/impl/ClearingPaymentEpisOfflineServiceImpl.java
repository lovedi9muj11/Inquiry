package th.co.maximus.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.dao.DeductionManualDao;
import th.co.maximus.dao.PaymentInvoiceManualDao;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.dao.TrsChequeRefManualDao;
import th.co.maximus.dao.TrsMethodManualDao;
import th.co.maximus.dao.TrscreDitrefManualDao;
import th.co.maximus.model.DuductionEpisOffline;
import th.co.maximus.model.PaymentInvoiceEpisOffline;
import th.co.maximus.model.ReceiptOfflineModel;
import th.co.maximus.model.TrsChequerefEpisOffline;
import th.co.maximus.model.TrsCreditrefEpisOffline;
import th.co.maximus.model.TrsMethodEpisOffline;
import th.co.maximus.service.ClearingPaymentEpisOfflineService;

@Service
public class ClearingPaymentEpisOfflineServiceImpl implements ClearingPaymentEpisOfflineService{

	@Autowired
	private PaymentManualDao paymentManualDao;
	@Autowired
	private PaymentInvoiceManualDao paymentInvoiceManualDao;
	@Autowired
	private DeductionManualDao deductionManualDao;
	@Autowired
	private TrsMethodManualDao trsMethodManualDao;
	@Autowired
	private TrsChequeRefManualDao trsChequeRefManualDao;
	@Autowired
	private TrscreDitrefManualDao TrscreDitrefManualDao;

	@Override
	public ReceiptOfflineModel findRecipt(Integer manualId) throws SQLException {
		// TODO Auto-generated method stub
		return paymentManualDao.findByManualId(manualId);
	}

	@Override
	public List<PaymentInvoiceEpisOffline> findPaymentInvoice(Integer manualId)throws SQLException {
		// TODO Auto-generated method stub
		return paymentInvoiceManualDao.findByManualId(manualId);
	}

	@Override
	public List<DuductionEpisOffline> findDeduction(Integer manualId) throws Exception {
		// TODO Auto-generated method stub
		return deductionManualDao.findDeductionManual(manualId);
	}

	@Override
	public List<TrsMethodEpisOffline> findTrsMethod(Integer manualId) throws Exception {
		// TODO Auto-generated method stub
		return trsMethodManualDao.findByManualId(manualId);
	}

	@Override
	public List<TrsCreditrefEpisOffline> findTrsCredit(long methodTrsId) throws Exception{
		// TODO Auto-generated method stub
		return TrscreDitrefManualDao.findByMethodId(methodTrsId);
	}

	@Override
	public List<TrsChequerefEpisOffline> findTrsCheq(long methodTrsId) throws SQLException {
		// TODO Auto-generated method stub
		return trsChequeRefManualDao.findByManualId(methodTrsId);
	}


}
