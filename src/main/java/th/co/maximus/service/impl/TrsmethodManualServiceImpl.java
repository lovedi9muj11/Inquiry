package th.co.maximus.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.bean.DeductionManualBean;
import th.co.maximus.bean.TrsChequeRefManualBean;
import th.co.maximus.bean.TrsMethodManualBean;
import th.co.maximus.bean.TrscreDitrefManualBean;
import th.co.maximus.dao.DeductionManualDao;
import th.co.maximus.dao.TrsChequeRefManualDao;
import th.co.maximus.dao.TrsMethodManualDao;
import th.co.maximus.dao.TrscreDitrefManualDao;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentTaxBean;
import th.co.maximus.payment.bean.PaymentTranPriceBean;
import th.co.maximus.service.TrsmethodManualService;

@Service
public class TrsmethodManualServiceImpl implements TrsmethodManualService{
	
	@Autowired TrsMethodManualDao trsMethodManualDao;
	@Autowired TrscreDitrefManualDao trscreDitrefManualDao;
	@Autowired TrsChequeRefManualDao trsChequeRefManualDao;
	@Autowired DeductionManualDao deductionManualDao;
	
	@Override
	public int insertTrsmethodManual(PaymentFirstBean paymentBean,int userId) {
		Date date = new Date();
		UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int idTrsMethod = 0;
		if(paymentBean.getPaymentTranPrice().size() >=0){
			for(int i=0; i < paymentBean.getPaymentTranPrice().size();i++){
				
				PaymentTranPriceBean paymentTranPriceBean = new PaymentTranPriceBean();
				TrsMethodManualBean trsMethodManualBean = new TrsMethodManualBean();
				TrscreDitrefManualBean trscreDitrefManualBean = new TrscreDitrefManualBean();
				TrsChequeRefManualBean trsChequeRefManualBean = new TrsChequeRefManualBean();

				paymentTranPriceBean = paymentBean.getPaymentTranPrice().get(i);
				trsMethodManualBean.setCode(paymentTranPriceBean.getTypePayment());
				trsMethodManualBean.setChequeNo(paymentBean.getPaymentTranPrice().get(i).getCheckNo());
				trsMethodManualBean.setAccountNo(paymentBean.getCustNo());
				trsMethodManualBean.setCreditId((paymentBean.getPaymentTranPrice().get(i).getCreditNo()));
				if(paymentTranPriceBean.getTypePayment().equals("CD")){
					
					trsMethodManualBean.setName("บัตรเครดิต");
					trsMethodManualBean.setAmount(paymentTranPriceBean.getCreditPrice());
				}else if(paymentTranPriceBean.getTypePayment().equals("CH")){
					trsMethodManualBean.setName("เช็ค");
					trsMethodManualBean.setAmount(paymentTranPriceBean.getMoneyCheck());
				}else{
					trsMethodManualBean.setName("เงินสด");
					trsMethodManualBean.setAmount(paymentTranPriceBean.getMoneyTran());
				}
				trsMethodManualBean.setUpdateDttm(new Timestamp(date.getTime()));
				trsMethodManualBean.setVersionStamp(1L);
				trsMethodManualBean.setRemark(paymentBean.getRemark());
				trsMethodManualBean.setCreateBy(profile.getUsername());	
				trsMethodManualBean.setCreateDate(new Timestamp(date.getTime()));
				trsMethodManualBean.setUpdateBy(profile.getUsername());
				trsMethodManualBean.setUpdateDate(new Timestamp(date.getTime()));
				trsMethodManualBean.setRecordStatus("A");
				trsMethodManualBean.setManualId(Long.valueOf(userId));
				try {
					 idTrsMethod = trsMethodManualDao.insertTrsMethod(trsMethodManualBean);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(idTrsMethod >0){
						if(paymentTranPriceBean.getTypePayment().equals("CD")){
							//insert Credit
							trscreDitrefManualBean.setaMount(paymentTranPriceBean.getCreditPrice());
							trscreDitrefManualBean.setCreditNo(paymentTranPriceBean.getCreditNo());
							trscreDitrefManualBean.setPublisherdec(paymentTranPriceBean.getTypePayment());
							trscreDitrefManualBean.setCardType(paymentTranPriceBean.getCreditType());
							trscreDitrefManualBean.setUpdateDttm(new Timestamp(date.getTime()));
							trscreDitrefManualBean.setVersionStamp(1L);
							trscreDitrefManualBean.setMethodManualId(String.valueOf(idTrsMethod));
							
							trscreDitrefManualDao.insertTrscreDitrefManua(trscreDitrefManualBean);
							
						}else if(paymentTranPriceBean.getTypePayment().equals("CH")){
							Date date1 = new Date(paymentTranPriceBean.getDateCheck());
							trsChequeRefManualBean.setChequeNo(paymentTranPriceBean.getCheckNo());
							trsChequeRefManualBean.setPublisherId(paymentTranPriceBean.getBankNo());
							trsChequeRefManualBean.setPublisher(paymentTranPriceBean.getBankName());
							trsChequeRefManualBean.setBranch(paymentTranPriceBean.getBranchCheck());
							trsChequeRefManualBean.setaMount(paymentTranPriceBean.getMoneyCheck());
							trsChequeRefManualBean.setUpdateDttm(new Timestamp(date.getTime()));
							trsChequeRefManualBean.setVersionStamp(1L);
//							trsChequeRefManualBean.setChequeDate(new Timestamp(paymentTranPriceBean.getDateCheck().getTime()));
							trsChequeRefManualBean.setCheDate(date1);
							trsChequeRefManualBean.setMethodManualId(Long.valueOf(idTrsMethod));
							
							trsChequeRefManualDao.insert(trsChequeRefManualBean);
							
					
					}
				}

				
				
				
			}
			
		} // END PAY
		
		if(paymentBean.getPaymentTax().size() >0){
			for(int i=0; i < paymentBean.getPaymentTax().size();i++){
				TrsMethodManualBean trsMethodManualBean = new TrsMethodManualBean();
				DeductionManualBean deductionManualBean= new DeductionManualBean();
				PaymentTaxBean paymentTaxBean = new PaymentTaxBean();
				paymentTaxBean = paymentBean.getPaymentTax().get(i);

				trsMethodManualBean.setCode("DEDUC");
				trsMethodManualBean.setName("ภาษีหัก ณ ที่จ่าย");
				trsMethodManualBean.setChequeNo("");
				trsMethodManualBean.setAccountNo(paymentBean.getCustNo());
				trsMethodManualBean.setCreditId("");
				trsMethodManualBean.setAmount(paymentTaxBean.getMoneyDed() *-1);
	
				
				trsMethodManualBean.setUpdateDttm(new Timestamp(date.getTime()));
				trsMethodManualBean.setVersionStamp(1L);
				trsMethodManualBean.setRemark(paymentBean.getRemark());
				trsMethodManualBean.setCreateBy(profile.getUsername());	
				trsMethodManualBean.setCreateDate(new Timestamp(date.getTime()));
				trsMethodManualBean.setUpdateBy(profile.getUsername());
				trsMethodManualBean.setUpdateDate(new Timestamp(date.getTime()));
				trsMethodManualBean.setRecordStatus("A");
				trsMethodManualBean.setManualId(Long.valueOf(userId));
				try {
					 idTrsMethod = trsMethodManualDao.insertTrsMethod(trsMethodManualBean);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				if(idTrsMethod >0){
					deductionManualBean.setDeDuctionNo("ภาษีหัก ณ ที่จ่าย");
					deductionManualBean.setDeDuctionType(paymentTaxBean.getRadioDed());
					deductionManualBean.setaMount(paymentTaxBean.getMoneyDed() *-1);
					deductionManualBean.setPaymentDate(new Timestamp(date.getTime()));
					deductionManualBean.setUpdateDttm(new Timestamp(date.getTime()));
					deductionManualBean.setVersionStamp(1L);
					deductionManualBean.setInvoiceNo(paymentBean.getInvoiceNo());
					deductionManualBean.setRemark(paymentBean.getRemark());
					deductionManualBean.setCreateBy(profile.getUsername());
					deductionManualBean.setCreateDate(new Timestamp(date.getTime()));
					deductionManualBean.setUpdateBy(profile.getUsername());
					deductionManualBean.setUpdateDate(new Timestamp(date.getTime()));
					deductionManualBean.setRecordStatus("A");
					deductionManualBean.setManualId(Long.valueOf(userId));
					deductionManualDao.insert(deductionManualBean);
				
				}
				

			}
		}
		return userId;
		
	}
	
	@Override
	public List<TrsMethodManualBean> TrsmethodManualAll() {
//		return jdbcTemplate.query("select * from trsmethod_manual", new TrsMethodManualJoin());
		return null;
	}

	

}
