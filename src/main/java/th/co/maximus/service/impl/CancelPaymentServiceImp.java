package th.co.maximus.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;

import th.co.maximus.bean.DeductionManualBean;
import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.bean.TrsChequeRefManualBean;
import th.co.maximus.bean.TrsMethodManualBean;
import th.co.maximus.bean.TrscreDitrefManualBean;
import th.co.maximus.core.utils.ReciptNoGenCode;
import th.co.maximus.dao.DeductionManualDao;
import th.co.maximus.dao.PaymentInvoiceManualDao;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.dao.TrsChequeRefManualDao;
import th.co.maximus.dao.TrsMethodManualDao;
import th.co.maximus.dao.TrscreDitrefManualDao;
import th.co.maximus.service.CancelPaymentService;

@Service
public class CancelPaymentServiceImp implements CancelPaymentService {
	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	@Autowired
	private PaymentInvoiceManualDao paymentInvoiceManualDao;
	
	@Autowired
	private DeductionManualDao deductionManualDao;
	
	@Autowired
	private PaymentManualDao paymentManualDao;
	
	@Autowired
	private TrsChequeRefManualDao trsChequeRefManualDao;
	
	@Autowired
	private TrscreDitrefManualDao trscreDitrefManualDao;
	
	@Autowired
	private ReciptNoGenCode reciptNoGenCode;
	
	@Autowired
	private TrsMethodManualDao trsMethodManualDao;

	@Override
	public List<PaymentMMapPaymentInvBean> findAllCancelPayment() {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<PaymentMMapPaymentInvBean>();
		for(PaymentMMapPaymentInvBean paymentMMapPaymentInvBean :paymentInvoiceManualDao.findPaymentMuMapPaymentInV()) {
			paymentMMapPaymentInvBean.setPaidDateStr(dt.format(paymentMMapPaymentInvBean.getPaidDate()));
			paymentMMapPaymentInvBean.setCreateDateStr(dt.format(paymentMMapPaymentInvBean.getCreateDate()));
			result.add(paymentMMapPaymentInvBean);
		}
		return result;
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findAllCancelPaymentFromId(long manualId) {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<PaymentMMapPaymentInvBean>();
		for(PaymentMMapPaymentInvBean paymentMMapPaymentInvBean :paymentInvoiceManualDao.findPaymentMuMapPaymentInVFromId(manualId)) {
			paymentMMapPaymentInvBean.setPaidDateStr(dt.format(paymentMMapPaymentInvBean.getPaidDate()));
			paymentMMapPaymentInvBean.setCreateDateStr(dt.format(paymentMMapPaymentInvBean.getCreateDate()));
			result.add(paymentMMapPaymentInvBean);
		}
		return result;
	}

	@Override
	public List<PaymentMMapPaymentInvBean> serviceCriteriaFromInvoiceOrReceiptNo(String receiptNo, String invoiceNo) {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<PaymentMMapPaymentInvBean>();
		for(PaymentMMapPaymentInvBean paymentMMapPaymentInvBean :paymentInvoiceManualDao.findCriteriaFromInvoiceOrReceiptNo(receiptNo, invoiceNo)) {
			paymentMMapPaymentInvBean.setPaidDateStr(dt.format(paymentMMapPaymentInvBean.getPaidDate()));
			paymentMMapPaymentInvBean.setCreateDateStr(dt.format(paymentMMapPaymentInvBean.getCreateDate()));
			result.add(paymentMMapPaymentInvBean);
		}
		return result;
	}

	@Override
	public void insertAndUpdateCancelPayment(PaymentMMapPaymentInvBean paymentMMapPaymentInvBean) {
		PaymentInvoiceManualBean paymentInvoiceManualBean = new PaymentInvoiceManualBean();
		paymentInvoiceManualDao.updateRecodeStatusFromReceiptNo("C", paymentMMapPaymentInvBean.getManualId());
		if ("02".equals(paymentMMapPaymentInvBean.getStatusCancelPayment())) {
			//Insert PaymentManual
			List<PaymentManualBean> paymentManual = paymentManualDao.findPaymentManualFromNanualId(paymentMMapPaymentInvBean.getManualId());
			if(!paymentManual.isEmpty()) {
				PaymentManualBean paymentManualBean = new PaymentManualBean();
				for(PaymentManualBean resultPaymentManual : paymentManual) {
					paymentManualBean.setInvoiceNo(resultPaymentManual.getInvoiceNo());
					paymentManualBean.setReceiptNoManual(reciptNoGenCode.genCodeRecipt(paymentManualBean.getDocType()));
					paymentManualBean.setPaidDate(resultPaymentManual.getPaidDate());
					paymentManualBean.setBrancharea(resultPaymentManual.getBrancharea());
					paymentManualBean.setBranchCode(resultPaymentManual.getBranchCode());
					paymentManualBean.setPaidAmount(resultPaymentManual.getPaidAmount());
					paymentManualBean.setSource(resultPaymentManual.getSource());
					paymentManualBean.setClearing(resultPaymentManual.getClearing());
					paymentManualBean.setRemark(resultPaymentManual.getRemark());
					paymentManualBean.setCreateBy(resultPaymentManual.getCreateBy());
					paymentManualBean.setCreateDate(resultPaymentManual.getCreateDate());
					paymentManualBean.setUpdateBy(resultPaymentManual.getUpdateBy());
					paymentManualBean.setUpdateDate(resultPaymentManual.getUpdateDate());
					paymentManualBean.setRecordStatus(resultPaymentManual.getRecordStatus());
					paymentManualBean.setAccountNo(resultPaymentManual.getAccountNo());
					paymentManualBean.setPaytype(resultPaymentManual.getPaytype());
					paymentManualBean.setDocType(resultPaymentManual.getDocType());
					paymentManualDao.insertPayment(paymentManualBean);
				}
			}
			//Insert PaymentInvoice
			List<PaymentInvoiceManualBean> resultPaymentInvoice = paymentInvoiceManualDao.findPaymentInvoiceFromManualId(paymentMMapPaymentInvBean.getManualId());
			if(!resultPaymentInvoice.isEmpty()) {
				paymentInvoiceManualBean = resultPaymentInvoice.get(0);
				paymentInvoiceManualDao.insert(paymentInvoiceManualBean);
			}
			//insert TrsChequeRefManual
			List<TrsChequeRefManualBean> trsChequeRefManual = trsChequeRefManualDao.findTrachequeFromManualId(paymentMMapPaymentInvBean.getManualId());
			if(!trsChequeRefManual.isEmpty()) {
				for(TrsChequeRefManualBean resultTrsChe : trsChequeRefManual) {
					TrsChequeRefManualBean trsChequeRefManualBean = new TrsChequeRefManualBean();
					trsChequeRefManualBean.setChequeNo(resultTrsChe.getChequeNo());
					trsChequeRefManualBean.setPublisherId(resultTrsChe.getPublisherId());
					trsChequeRefManualBean.setPublisher(resultTrsChe.getPublisher());
					trsChequeRefManualBean.setBranch(resultTrsChe.getBranch());
					trsChequeRefManualBean.setaMount(resultTrsChe.getaMount());
					trsChequeRefManualBean.setUpdateDttm(resultTrsChe.getUpdateDttm());
					trsChequeRefManualBean.setUpdateSystem(resultTrsChe.getUpdateSystem());
					trsChequeRefManualBean.setUpdateUser(resultTrsChe.getUpdateUser());
					trsChequeRefManualBean.setVersionStamp(resultTrsChe.getVersionStamp());
					trsChequeRefManualBean.setChequeDate(resultTrsChe.getChequeDate());
					trsChequeRefManualBean.setBounceChequeDate(resultTrsChe.getBounceChequeDate());
					trsChequeRefManualBean.setReverseArDate(resultTrsChe.getReverseArDate());
					trsChequeRefManualBean.setBounceStatus(resultTrsChe.getBounceStatus());
					trsChequeRefManualBean.setMethodManualId(resultTrsChe.getMethodManualId());
					trsChequeRefManualDao.insert(trsChequeRefManualBean);
				}
			}
			//insert TrscreDitrefManual
			List<TrscreDitrefManualBean> resultTrscreDitrefManual = trscreDitrefManualDao.trscreDitrefManualFromManualId(paymentMMapPaymentInvBean.getManualId());
			if(!resultPaymentInvoice.isEmpty()) {
				for(TrscreDitrefManualBean result : resultTrscreDitrefManual) {
					TrscreDitrefManualBean trscreDitrefManualBean = new TrscreDitrefManualBean();
					trscreDitrefManualBean.setCreditNo(result.getCreditNo());
					trscreDitrefManualBean.setPublisherdec(result.getPublisherdec());
					trscreDitrefManualBean.setCardType(result.getCardType());
					trscreDitrefManualBean.setaMount(result.getaMount());
					trscreDitrefManualBean.setUpdateDttm(result.getUpdateDttm());
					trscreDitrefManualBean.setUpdateSystem(result.getUpdateSystem());
					trscreDitrefManualBean.setUpdateUser(result.getUpdateUser());
					trscreDitrefManualBean.setVersionStamp(result.getVersionStamp());
					trscreDitrefManualBean.setMethodManualId(result.getMethodManualId());
					trscreDitrefManualDao.insertTrscreDitrefManua(trscreDitrefManualBean);
				}
				
			}
			//insert trsMethodManual
			List<TrsMethodManualBean> resultTrsMethodManual = trsMethodManualDao.findTrsMethodManualFromManualId(paymentMMapPaymentInvBean.getManualId());
			if(!resultTrsMethodManual.isEmpty()) {
				for(TrsMethodManualBean result : resultTrsMethodManual) {
					TrsMethodManualBean trsMethodManualBean = new TrsMethodManualBean();
					trsMethodManualBean.setCode(result.getCode());
					trsMethodManualBean.setName(result.getName());
					trsMethodManualBean.setChequeNo(result.getChequeNo());
					trsMethodManualBean.setAccountNo(result.getAccountNo());
					trsMethodManualBean.setAmount(result.getAmount());
					trsMethodManualBean.setUpdateDttm(result.getUpdateDttm());
					trsMethodManualBean.setUpdateSystem(result.getUpdateSystem());
					trsMethodManualBean.setUpdateUser(result.getUpdateUser());
					trsMethodManualBean.setVersionStamp(result.getVersionStamp());
					trsMethodManualBean.setOffsetDocumentNo(result.getOffsetDocumentNo());
					trsMethodManualBean.setOffsetAccountCode(result.getOffsetAccountCode());
					trsMethodManualBean.setOffsetAccountName(result.getOffsetAccountName());
					trsMethodManualBean.setRemark(result.getRemark());
					trsMethodManualBean.setCreateBy(result.getCreateBy());
					trsMethodManualBean.setCreateDate(result.getCreateDate());
					trsMethodManualBean.setUpdateBy(result.getUpdateBy());
					trsMethodManualBean.setUpdateDate(result.getUpdateDate());
					trsMethodManualBean.setRecordStatus(result.getRecordStatus());
					trsMethodManualBean.setRefId(result.getRefId());
					trsMethodManualBean.setDeductionManualId(result.getDeductionManualId());
					trsMethodManualBean.setManualId(result.getManualId());
					
					trsMethodManualDao.insertTrsMethod(trsMethodManualBean);
				}
				//insert deduction manual
				List<DeductionManualBean> resultDeductionManual = deductionManualDao.findDeductionManualFromManualId(paymentMMapPaymentInvBean.getManualId());
				if(!resultDeductionManual.isEmpty()) {
					for(DeductionManualBean result : resultDeductionManual) {
						DeductionManualBean deductionManualBean = new DeductionManualBean();
						deductionManualBean.setDeDuctionNo(result.getDeDuctionNo());
						deductionManualBean.setDeDuctionType(result.getDeDuctionType());
						deductionManualBean.setaMount(result.getaMount());
						deductionManualBean.setPaymentDate(result.getPaymentDate());
						deductionManualBean.setUpdateDttm(result.getUpdateDttm());
						deductionManualBean.setUpdateSystem(result.getUpdateSystem());
						deductionManualBean.setUpdateUser(result.getUpdateUser());
						deductionManualBean.setVersionStamp(result.getVersionStamp());
						deductionManualBean.setInvoiceNo(result.getInvoiceNo());
						deductionManualBean.setRemark(result.getRemark());
						deductionManualBean.setCreateBy(result.getCreateBy());
						deductionManualBean.setCreateDate(result.getCreateDate());
						deductionManualBean.setUpdateBy(result.getUpdateBy());
						deductionManualBean.setUpdateDate(result.getUpdateDate());
						deductionManualBean.setRecordStatus(result.getRecordStatus());
						deductionManualBean.setManualId(result.getManualId());
						
						deductionManualDao.insert(deductionManualBean);
					}
				}
			}
		} 
	}

}
