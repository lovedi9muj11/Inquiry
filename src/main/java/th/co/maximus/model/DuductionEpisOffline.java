package th.co.maximus.model;

import java.math.BigDecimal;
import java.util.Date;

public class DuductionEpisOffline {

	private String deductionNo;
	private String deductionType;
	private BigDecimal amount;
	private Date paymentDate;
	private String invoiceNo;
	private String remark;
	
	public DuductionEpisOffline(){}
	public DuductionEpisOffline(String deductionNo,String deductionType,BigDecimal amount,Date paymentDate,String invoiceNo,String remark){
		this.deductionNo = deductionNo;
		this.deductionType = deductionType;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.invoiceNo = invoiceNo;
		this.remark = remark;
	}
	
	public String getDeductionNo() {
		return deductionNo;
	}
	public void setDeductionNo(String deductionNo) {
		this.deductionNo = deductionNo;
	}
	public String getDeductionType() {
		return deductionType;
	}
	public void setDeductionType(String deductionType) {
		this.deductionType = deductionType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}
