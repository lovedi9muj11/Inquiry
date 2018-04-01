package th.co.maximus.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import th.co.maximus.core.utils.converter.CustomDateDeserializer;
import th.co.maximus.core.utils.converter.CustomDateSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SettlePaymentDTO implements Serializable{
    private static final long serialVersionUID = 399601672955902056L;

    public static class Customer {
        private String custNo;
        private String custName;
        private String souceType;
        private String epNameCode;
        private Date paymentDate;
        private String inputPayCashBP;
        private String inputPayCashBA;
        private String custType;
        private String custNameEdit;
        private String taxNo;
        private String custBranch;
        private String billGroup;
        private String collectionUnit;
        private BigDecimal outstanding;
        private String address1;
        private String address2;
        private String remark;
        private Boolean split = false;
        private List<Invoice> invoices = new ArrayList<Invoice>();
        private List<Service> services = new ArrayList<Service>();
        private String custSubNo;

        private String egpNo;
        private String egpContract;
        private String currencyCode;
        private BigDecimal currencyRate;
        private String agentAddressCode; //by NSD 01-03-2017
        private String acctCatLkp;//by NSD 02-03-2017
        private String catCustomerSegment;
        private String custCategoryDesc;//by NSD 08-03-2017
        private String ref1;
        private String invoiceDisplay;//by NSD 24-03-2017
        private BigDecimal excDiscount;
        private BigDecimal afterSaleDiscVat;
        private String receiptFormat;
        private String agentTaxNo; // by W3P 03-07-2017
        private BigDecimal feesIncome; // by W3P 04-07-2017
        private BigDecimal specialDiscount;
        private BigDecimal deduction;
        private BigDecimal wtAmt;
        private BigDecimal retentionAmt;
        private String checkType;// chk นิติบุคคล
        private BigDecimal exchangeRate;
        private String receipttype;
        private String attributes;
        
        
        
        public String getAttributes() {
			return attributes;
		}

		public void setAttributes(String attributes) {
			this.attributes = attributes;
		}

		public String getReceipttype() {
			return receipttype;
		}

		public void setReceipttype(String receipttype) {
			this.receipttype = receipttype;
		}

		public String getCheckType() {
			return checkType;
		}

		public void setCheckType(String checkType) {
			this.checkType = checkType;
		}

		public String getCustNo() {
            return custNo;
        }

        public String getCustNameEdit() {
            return custNameEdit;
        }

        public void setCustNameEdit(String custNameEdit) {
            this.custNameEdit = custNameEdit;
        }

        public String getInputPayCashBP() {
            return inputPayCashBP;
        }

        public void setInputPayCashBP(String inputPayCashBP) {
            this.inputPayCashBP = inputPayCashBP;
        }

        public String getInputPayCashBA() {
            return inputPayCashBA;
        }

        public void setInputPayCashBA(String inputPayCashBA) {
            this.inputPayCashBA = inputPayCashBA;
        }

        public String getEpNameCode() {
            return epNameCode;
        }

        public void setEpNameCode(String epNameCode) {
            this.epNameCode = epNameCode;
        }

        public Date getPaymentDate() {
            return paymentDate;
        }      
        public void setPaymentDate(Date paymentDate) {
            this.paymentDate = paymentDate;
        }

        public void setCustNo(String custNo) {
            this.custNo = custNo;
        }
        public String getSouceType() {
            return souceType;
        }
        public void setSouceType(String souceType) {
            this.souceType = souceType;
        }
        public String getCustSubNo() {
            return custSubNo;
        }
        public void setCustSubNo(String custSubNo) {
            this.custSubNo = custSubNo;
        }
        public String getCustName() {
            return custName;
        }
        public void setCustName(String custName) {
            this.custName = custName;
        }
        public String getCustType() {
            return custType;
        }
        public void setCustType(String custType) {
            this.custType = custType;
        }
        public String getTaxNo() {
            return taxNo;
        }
        public void setTaxNo(String taxNo) {
            this.taxNo = taxNo;
        }
        public String getCustBranch() {
            return custBranch;
        }
        public void setCustBranch(String custBranch) {
            this.custBranch = custBranch;
        }
        public String getBillGroup() {
            return billGroup;
        }
        public void setBillGroup(String billGroup) {
            this.billGroup = billGroup;
        }
        public String getCollectionUnit() {
            return collectionUnit;
        }
        public void setCollectionUnit(String collectionUnit) {
            this.collectionUnit = collectionUnit;
        }
        public BigDecimal getOutstanding() {
            return outstanding;
        }
        public void setOutstanding(BigDecimal outstanding) {
            this.outstanding = outstanding;
        }
        public String getAddress1() {
            return address1;
        }
        public void setAddress1(String address1) {
            this.address1 = address1;
        }
        public String getAddress2() {
            return address2;
        }
        public void setAddress2(String address2) {
            this.address2 = address2;
        }
        public String getRemark() {
            return remark;
        }
        public void setRemark(String remark) {
            this.remark = remark;
        }
        public Boolean getSplit() {
            return split;
        }
        public void setSplit(Boolean split) {
            this.split = split;
        }
        public List<Invoice> getInvoices() {
            return invoices;
        }
        public void setInvoices(List<Invoice> invoices) {
            this.invoices = invoices;
        }
        public List<Service> getServices() {
            return services;
        }
        public void setServices(List<Service> services) {
            this.services = services;
        }
        /*
        public String getBillingGroup() {
            return billingGroup;
        }
        public void setBillingGroup(String billingGroup) {
            this.billingGroup = billingGroup;
        }
        */
        public String getEgpNo() {
            return egpNo;
        }
        public void setEgpNo(String egpNo) {
            this.egpNo = egpNo;
        }
        public String getEgpContract() {
            return egpContract;
        }
        public void setEgpContract(String egpContract) {
            this.egpContract = egpContract;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public BigDecimal getCurrencyRate() {
            return currencyRate;
        }

        public void setCurrencyRate(BigDecimal currencyRate) {
            this.currencyRate = currencyRate;
        }

        public String getAgentAddressCode() {
            return agentAddressCode;
        }

        public void setAgentAddressCode(String agentAddressCode) {
            this.agentAddressCode = agentAddressCode;
        }

        public String getAcctCatLkp() {
            return acctCatLkp;
        }

        public void setAcctCatLkp(String acctCatLkp) {
            this.acctCatLkp = acctCatLkp;
        }

        public String getCatCustomerSegment() {
            return catCustomerSegment;
        }

        public void setCatCustomerSegment(String catCustomerSegment) {
            this.catCustomerSegment = catCustomerSegment;
        }

        public String getCustCategoryDesc() {
            return custCategoryDesc;
        }

        public void setCustCategoryDesc(String custCategoryDesc) {
            this.custCategoryDesc = custCategoryDesc;
        }

        public String getRef1() {
            return ref1;
        }

        public void setRef1(String ref1) {
            this.ref1 = ref1;
        }

        public String getInvoiceDisplay() {
            return invoiceDisplay;
        }

        public void setInvoiceDisplay(String invoiceDisplay) {
            this.invoiceDisplay = invoiceDisplay;
        }

        public BigDecimal getExcDiscount() {
            return excDiscount;
        }

        public void setExcDiscount(BigDecimal excDiscount) {
            this.excDiscount = excDiscount;
        }

        public BigDecimal getAfterSaleDiscVat() {
            return afterSaleDiscVat;
        }

        public void setAfterSaleDiscVat(BigDecimal afterSaleDiscVat) {
            this.afterSaleDiscVat = afterSaleDiscVat;
        }

        public String getReceiptFormat() {
            return receiptFormat;
        }

        public void setReceiptFormat(String receiptFormat) {
            this.receiptFormat = receiptFormat;
        }

        public String getAgentTaxNo() {	
        	return agentTaxNo; 
        }

        public void setAgentTaxNo(String agentTaxNo) { 
        	this.agentTaxNo = agentTaxNo; 
        }

        public BigDecimal getFeesIncome() {	
        	return feesIncome; 
        }

        public void setFeesIncome(BigDecimal feesIncome) { 
        	this.feesIncome = feesIncome; 
        }

        public BigDecimal getSpecialDiscount() { 
        	return specialDiscount; 
        }

        public void setSpecialDiscount(BigDecimal specialDiscount) { 
        	this.specialDiscount = specialDiscount; 
        }

		public BigDecimal getDeduction() {
			return deduction;
		}

		public void setDeduction(BigDecimal deduction) {
			this.deduction = deduction;
		}

		public BigDecimal getWtAmt() {
			return wtAmt;
		}

		public void setWtAmt(BigDecimal wtAmt) {
			this.wtAmt = wtAmt;
		}

		public BigDecimal getRetentionAmt() {
			return retentionAmt;
		}

		public void setRetentionAmt(BigDecimal retentionAmt) {
			this.retentionAmt = retentionAmt;
		}

		public BigDecimal getExchangeRate() {
			return exchangeRate;
		}

		public void setExchangeRate(BigDecimal exchangeRate) {
			this.exchangeRate = exchangeRate;
		}
		

    }
    
    public static class Invoice {
        private String no;
        private String currencyCode;
        private BigDecimal amount;
        private BigDecimal amountBath;
        private BigDecimal discount;
        private BigDecimal charge;
        private BigDecimal vatRate;
        private BigDecimal vat;
        private BigDecimal totalCharge;
        private BigDecimal deduction;
        private BigDecimal afterSaleDiscount;
        private BigDecimal balanceDue;
        private BigDecimal received;
        private BigDecimal change;
        private BigDecimal advanced;
        private String billCycle;
        private String withholdingTaxNo;
        private Date issueDt;
        private Date dueDt;
        private String kenan;
        private String status;
        private String paymentCase;
        private List<String> subNoList;
        private List<InvoiceVatDetail> invoiceVatDetails;
        private String discountType;//by NSD 04-04-2017
        private BigDecimal afterSaleDiscVat;
        private String discApprUser;
        private String taxTypeCode;
        private String source;
        private String serviceName;
        private BigDecimal foreignExchangeRate;
        private Integer year;
        private String docNo;
        private String message;
        private String type;
        private Date exchRateDateAr;
        private String currencyAr;
        
        public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getWithholdingTaxNo() {
            return withholdingTaxNo;
        }
        public void setWithholdingTaxNo(String withholdingTaxNo) {
            this.withholdingTaxNo = withholdingTaxNo;
        }
        public String getNo() {
            return no;
        }
        public void setNo(String no) {
            this.no = no;
        }
        public String getCurrencyCode() {
            return currencyCode;
        }
        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }
        public BigDecimal getAmount() {
            return amount;
        }
        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
        public BigDecimal getDiscount() {
            return discount;
        }
        public void setDiscount(BigDecimal discount) {
            this.discount = discount;
        }
        public BigDecimal getCharge() {
            return charge;
        }
        public void setCharge(BigDecimal charge) {
            this.charge = charge;
        }
        public BigDecimal getVatRate() {
            return vatRate;
        }
        public void setVatRate(BigDecimal vatRate) {
            this.vatRate = vatRate;
        }
        public BigDecimal getVat() {
            return vat;
        }
        public void setVat(BigDecimal vat) {
            this.vat = vat;
        }
        public BigDecimal getTotalCharge() {
            return totalCharge;
        }
        public void setTotalCharge(BigDecimal totalCharge) {
            this.totalCharge = totalCharge;
        }
        public BigDecimal getDeduction() {
            return deduction;
        }
        public void setDeduction(BigDecimal deduction) {
            this.deduction = deduction;
        }
        public BigDecimal getAfterSaleDiscount() {
            return afterSaleDiscount;
        }
        public void setAfterSaleDiscount(BigDecimal afterSaleDiscount) {
            this.afterSaleDiscount = afterSaleDiscount;
        }
        public BigDecimal getBalanceDue() {
            return balanceDue;
        }
        public void setBalanceDue(BigDecimal balanceDue) {
            this.balanceDue = balanceDue;
        }
        public BigDecimal getReceived() {
            return received;
        }
        public void setReceived(BigDecimal received) {
            this.received = received;
        }
        public BigDecimal getChange() {
            return change;
        }
        public void setChange(BigDecimal change) {
            this.change = change;
        }
        public BigDecimal getAdvanced() {
            return advanced;
        }
        public void setAdvanced(BigDecimal advanced) {
            this.advanced = advanced;
        }
        public String getBillCycle() {
            return billCycle;
        }
        public void setBillCycle(String billCycle) {
            this.billCycle = billCycle;
        }
        public Date getIssueDt() {
            return issueDt;
        }
        public void setIssueDt(Date issueDt) {
            this.issueDt = issueDt;
        }
        public Date getDueDt() {
            return dueDt;
        }
        public void setDueDt(Date dueDt) {
            this.dueDt = dueDt;
        }
        public String getKenan() {
            return kenan;
        }
        public void setKenan(String kenan) {
            this.kenan = kenan;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public String getPaymentCase() {
            return paymentCase;
        }
        public void setPaymentCase(String paymentCase) {
            this.paymentCase = paymentCase;
        }

        public List<String> getSubNoList() {
            return subNoList;
        }

        public void setSubNoList(List<String> subNoList) {
            this.subNoList = subNoList;
        }

        public String getDiscountType() {
            return discountType;
        }

        public void setDiscountType(String discountType) {
            this.discountType = discountType;
        }

        public BigDecimal getAfterSaleDiscVat() {
            return afterSaleDiscVat;
        }

        public void setAfterSaleDiscVat(BigDecimal afterSaleDiscVat) {
            this.afterSaleDiscVat = afterSaleDiscVat;
        }

        public String getDiscApprUser() {
            return discApprUser;
        }

        public void setDiscApprUser(String discApprUser) {
            this.discApprUser = discApprUser;
        }

        public List<InvoiceVatDetail> getInvoiceVatDetails() {
            return invoiceVatDetails;
        }

        public void setInvoiceVatDetails(List<InvoiceVatDetail> invoiceVatDetails) {
            this.invoiceVatDetails = invoiceVatDetails;
        }

        public String getTaxTypeCode() {
            return taxTypeCode;
        }

        public void setTaxTypeCode(String taxTypeCode) {
            this.taxTypeCode = taxTypeCode;
        }
		public BigDecimal getAmountBath() {
			return amountBath;
		}
		public void setAmountBath(BigDecimal amountBath) {
			this.amountBath = amountBath;
		}
		public String getServiceName() {
			return serviceName;
		}
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}
		public BigDecimal getForeignExchangeRate() {
			return foreignExchangeRate;
		}
		public void setForeignExchangeRate(BigDecimal foreignExchangeRate) {
			this.foreignExchangeRate = foreignExchangeRate;
		}
		public Integer getYear() {
			return year;
		}
		public void setYear(Integer year) {
			this.year = year;
		}
		public String getDocNo() {
			return docNo;
		}
		public void setDocNo(String docNo) {
			this.docNo = docNo;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Date getExchRateDateAr() {
			return exchRateDateAr;
		}
		public void setExchRateDateAr(Date exchRateDateAr) {
			this.exchRateDateAr = exchRateDateAr;
		}
		public String getCurrencyAr() {
			return currencyAr;
		}
		public void setCurrencyAr(String currencyAr) {
			this.currencyAr = currencyAr;
		}
		
        
    }
    public static class Service {
        private String no;
        private String type;
        private String code;
        private String name;
        private String promotion;
        private String subscriber;
        private String moreData;
        private String unit;
        private String refTransId;
        private String mdn;
        private String iccid;
        private BigDecimal amount;
        private BigDecimal discount;
        private BigDecimal charge;
        private BigDecimal vat;
        private BigDecimal vatRate;
        private BigDecimal totalCharge;
        private BigDecimal Deduction;
        private String serviceTypeName;//by NSD 16-02-2017
        private BigDecimal amtIncVat;
        private String serviceName;
        private String ref1;
        private String ref2;
        private String feeFlg; // by W3P 03-07-2017
        private BigDecimal costPerUnit; // by W3P 25-07-2017
        private String profitCode;
        private String profitName;
        private String productCode;
        private String productName;
        private String subProductCode;
        private String subProductName;
        private Long segmentCode;
        private String segmentName;
        private String glAccount;
        private String revenueTypeCode;
        private String revenueTypeName;
        private BigDecimal specialDiscount;
        private String orderId;
        private String refOrderId;
        private String groupCode;
        private String groupName;
        private String currencyCode;
        private BigDecimal currencyRate;
        private boolean flgOtherIncomeNonVat;

        public String getNo() {
            return no;
        }
        public void setNo(String no) {
            this.no = no;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPromotion() {
            return promotion;
        }
        public void setPromotion(String promotion) {
            this.promotion = promotion;
        }
        public String getSubscriber() {
            return subscriber;
        }
        public void setSubscriber(String subscriber) {
            this.subscriber = subscriber;
        }
        public String getMoreData() {
            return moreData;
        }
        public void setMoreData(String moreData) {
            this.moreData = moreData;
        }
        public String getUnit() {
            return unit;
        }
        public void setUnit(String unit) {
            this.unit = unit;
        }
        public String getRefTransId() {
            return refTransId;
        }
        public void setRefTransId(String refTransId) {
            this.refTransId = refTransId;
        }
        public String getMdn() {
            return mdn;
        }
        public void setMdn(String mdn) {
            this.mdn = mdn;
        }
        public String getIccid() {
            return iccid;
        }
        public void setIccid(String iccid) {
            this.iccid = iccid;
        }
        public BigDecimal getAmount() {
            return amount;
        }
        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
        public BigDecimal getDiscount() {
            return discount;
        }
        public void setDiscount(BigDecimal discount) {
            this.discount = discount;
        }
        public BigDecimal getCharge() {
            return charge;
        }
        public void setCharge(BigDecimal charge) {
            this.charge = charge;
        }
        public BigDecimal getVat() {
            return vat;
        }
        public void setVat(BigDecimal vat) {
            this.vat = vat;
        }
        public BigDecimal getVatRate() {
            return vatRate;
        }
        public void setVatRate(BigDecimal vatRate) {
            this.vatRate = vatRate;
        }
        public BigDecimal getTotalCharge() {
            return totalCharge;
        }
        public void setTotalCharge(BigDecimal totalCharge) {
            this.totalCharge = totalCharge;
        }
        public BigDecimal getDeduction() {
            return Deduction;
        }
        public void setDeduction(BigDecimal deduction) {
            Deduction = deduction;
        }

        public String getServiceTypeName() {
            return serviceTypeName;
        }

        public void setServiceTypeName(String serviceTypeName) {
            this.serviceTypeName = serviceTypeName;
        }

        public BigDecimal getAmtIncVat() {
            return amtIncVat;
        }

        public void setAmtIncVat(BigDecimal amtIncVat) {
            this.amtIncVat = amtIncVat;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getRef1() {
            return ref1;
        }

        public void setRef1(String ref1) {
            this.ref1 = ref1;
        }

        public String getRef2() {
            return ref2;
        }

        public void setRef2(String ref2) {
            this.ref2 = ref2;
        }

        public String getFeeFlg() {	return feeFlg; }

        public void setFeeFlg(String feeFlg) { this.feeFlg = feeFlg; }
        public BigDecimal getCostPerUnit() { return costPerUnit; }
        public void setCostPerUnit(BigDecimal costPerUnit) { this.costPerUnit = costPerUnit;}
        public String getProfitCode() { return profitCode; }
        public void setProfitCode(String profitCode) { this.profitCode = profitCode; }
        public String getProfitName() { return profitName; }
        public void setProfitName(String profitName) { this.profitName = profitName; }
        public String getProductCode() { return productCode; }
        public void setProductCode(String productCode) { this.productCode = productCode; }
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
        public String getSubProductCode() { return subProductCode; }
        public void setSubProductCode(String subProductCode) { this.subProductCode = subProductCode; }
        public String getSubProductName() { return subProductName; }
        public void setSubProductName(String subProductName) { this.subProductName = subProductName; }
        public Long getSegmentCode() { return segmentCode; }
        public void setSegmentCode(Long segmentCode) { this.segmentCode = segmentCode; }
        public String getSegmentName() { return segmentName; }
        public void setSegmentName(String segmentName) { this.segmentName = segmentName; }
        public String getGlAccount() { return glAccount; }
        public void setGlAccount(String glAccount) { this.glAccount = glAccount; }
        public String getRevenueTypeCode() { return revenueTypeCode; }
        public void setRevenueTypeCode(String revenueTypeCode) { this.revenueTypeCode = revenueTypeCode; }
        public String getRevenueTypeName() { return revenueTypeName; }
        public void setRevenueTypeName(String revenueTypeName) { this.revenueTypeName = revenueTypeName;}
        public BigDecimal getSpecialDiscount() { return specialDiscount; }
        public void setSpecialDiscount(BigDecimal specialDiscount) { this.specialDiscount = specialDiscount; }
		
        public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public String getRefOrderId() {
			return refOrderId;
		}
		public void setRefOrderId(String refOrderId) {
			this.refOrderId = refOrderId;
		}
		public String getGroupCode() {
			return groupCode;
		}
		public void setGroupCode(String groupCode) {
			this.groupCode = groupCode;
		}
		public String getGroupName() {
			return groupName;
		}
		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}
		public String getCurrencyCode() {
			return currencyCode;
		}
		public void setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
		}
		public BigDecimal getCurrencyRate() {
			return currencyRate;
		}
		public void setCurrencyRate(BigDecimal currencyRate) {
			this.currencyRate = currencyRate;
		}
		public boolean isFlgOtherIncomeNonVat() {
			return flgOtherIncomeNonVat;
		}
		public void setFlgOtherIncomeNonVat(boolean flgOtherIncomeNonVat) {
			this.flgOtherIncomeNonVat = flgOtherIncomeNonVat;
		}

        

    }
    public static class Advanced {
        private String custNo;
        private String custType;
        private String invoiceNo;
        private String kenan;
        private String currencyCode;
        private BigDecimal amount;
        private BigDecimal discount;
        private BigDecimal charge;
        private BigDecimal vatRate;
        private BigDecimal vat;
        private BigDecimal totalCharge;
        private BigDecimal deduction;
        private BigDecimal balanceDue;
        private BigDecimal totalPaid;
        private BigDecimal received;
        private BigDecimal change;
        private BigDecimal advanced;
        private String billCycle;//by NSD 24-03-2017
        private String invoiceDisplay;
        private String payType;
        private String payCode;
        private String payName;
        private String type;// 1 = intend , 0 = Inattentive
        public String getCustNo() {
            return custNo;
        }
        public void setCustNo(String custNo) {
            this.custNo = custNo;
        }
        public String getCustType() {
            return custType;
        }
        public void setCustType(String custType) {
            this.custType = custType;
        }
        public String getInvoiceNo() {
            return invoiceNo;
        }
        public void setInvoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
        }
        public String getKenan() {
            return kenan;
        }
        public void setKenan(String kenan) {
            this.kenan = kenan;
        }
        public String getCurrencyCode() {
            return currencyCode;
        }
        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }
        public BigDecimal getAmount() {
            return amount;
        }
        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
        public BigDecimal getDiscount() {
            return discount;
        }
        public void setDiscount(BigDecimal discount) {
            this.discount = discount;
        }
        public BigDecimal getCharge() {
            return charge;
        }
        public void setCharge(BigDecimal charge) {
            this.charge = charge;
        }
        public BigDecimal getVatRate() {
            return vatRate;
        }
        public void setVatRate(BigDecimal vatRate) {
            this.vatRate = vatRate;
        }
        public BigDecimal getVat() {
            return vat;
        }
        public void setVat(BigDecimal vat) {
            this.vat = vat;
        }
        public BigDecimal getTotalCharge() {
            return totalCharge;
        }
        public void setTotalCharge(BigDecimal totalCharge) {
            this.totalCharge = totalCharge;
        }
        public BigDecimal getDeduction() {
            return deduction;
        }
        public void setDeduction(BigDecimal deduction) {
            this.deduction = deduction;
        }
        public BigDecimal getBalanceDue() {
            return balanceDue;
        }
        public void setBalanceDue(BigDecimal balanceDue) {
            this.balanceDue = balanceDue;
        }
        public BigDecimal getTotalPaid() {
            return totalPaid;
        }
        public void setTotalPaid(BigDecimal totalPaid) {
            this.totalPaid = totalPaid;
        }
        public BigDecimal getReceived() {
            return received;
        }
        public void setReceived(BigDecimal received) {
            this.received = received;
        }
        public BigDecimal getChange() {
            return change;
        }
        public void setChange(BigDecimal change) {
            this.change = change;
        }
        public BigDecimal getAdvanced() {
            return advanced;
        }
        public void setAdvanced(BigDecimal advanced) {
            this.advanced = advanced;
        }
        public String getBillCycle() {
            return billCycle;
        }
        public void setBillCycle(String billCycle) {
            this.billCycle = billCycle;
        }

        public String getInvoiceDisplay() {
            return invoiceDisplay;
        }
        public void setInvoiceDisplay(String invoiceDisplay) {
            this.invoiceDisplay = invoiceDisplay;
        }
        public String getPayType() {
            return payType;
        }
        public void setPayType(String payType) {
            this.payType = payType;
        }
        public String getPayCode() {
            return payCode;
        }
        public void setPayCode(String payCode) {
            this.payCode = payCode;
        }
        public String getPayName() {
            return payName;
        }
        public void setPayName(String payName) {
            this.payName = payName;
        }
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}

    }
    public static class Method {
        private String code;
        private String name;
        private String type;
        private BigDecimal amount;
        private String bankCode;
        private String bankName;
        private String bankBrnh;
        private String bankAcct;
        private Date transferDt;
        private String bankAcCd;
        private String chequeNo;
        private String chequeDt;
        private String cardNo;
        private String cardType;
        private String mnyOrderNo;
        private String mnyOrderCd;
        private Date mnyOrderDt;
        private String billExNo;
        private String billExCd;
        private String billExDt;
        private String couponNo;
        private String trnfNo;
        private Boolean isBackDt;
        private String offsetDocumentNo;
        private String offsetAccountCode;
        private String offsetAccountName;
        private String payChqBankCode;
        private String payChqBankName;
        private String payChqBranch;
        private Date payChqDate;
        private Date chequeDate;
        private String postCode;
        private Date updateDttm;
        private String updateUser;
        private String otherType;
        private String otherNo;
        private Date otherDt;
        private String methodCase;
        private String currencyCode;
		private BigDecimal currencyRate;
		private BigDecimal foreignAmount;
		private String bankAcctNo;
		private String refNo;
		private String docNo;

        @JsonSerialize(using = CustomDateSerializer.class)
        public Date getChequeDate() {
            return chequeDate;
        }

        @JsonDeserialize(using = CustomDateDeserializer.class)
        public void setChequeDate(Date chequeDate) {
            this.chequeDate = chequeDate;
        }

        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public BigDecimal getAmount() {
            return amount;
        }
        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
        public String getBankCode() {
            return bankCode;
        }
        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }
        public String getBankName() {
            return bankName;
        }
        public void setBankName(String bankName) {
            this.bankName = bankName;
        }
        public String getBankBrnh() {
            return bankBrnh;
        }
        public void setBankBrnh(String bankBrnh) {
            this.bankBrnh = bankBrnh;
        }
        public String getBankAcct() {
            return bankAcct;
        }
        public void setBankAcct(String bankAcct) {
            this.bankAcct = bankAcct;
        }
        public Date getTransferDt() {
            return transferDt;
        }
        public void setTransferDt(Date transferDt) {
            this.transferDt = transferDt;
        }
        public String getBankAcCd() {
            return bankAcCd;
        }
        public void setBankAcCd(String bankAcCd) {
            this.bankAcCd = bankAcCd;
        }
        public String getChequeNo() {
            return chequeNo;
        }
        public void setChequeNo(String chequeNo) {
            this.chequeNo = chequeNo;
        }
        public String getChequeDt() {
            return chequeDt;
        }
        public void setChequeDt(String chequeDt) {
            this.chequeDt = chequeDt;
        }
        public String getCardNo() {
            return cardNo;
        }
        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }
        public String getCardType() {
            return cardType;
        }
        public void setCardType(String cardType) {
            this.cardType = cardType;
        }
        public String getMnyOrderNo() {
            return mnyOrderNo;
        }
        public void setMnyOrderNo(String mnyOrderNo) {
            this.mnyOrderNo = mnyOrderNo;
        }
        public String getMnyOrderCd() {
            return mnyOrderCd;
        }
        public void setMnyOrderCd(String mnyOrderCd) {
            this.mnyOrderCd = mnyOrderCd;
        }
        public Date getMnyOrderDt() {
            return mnyOrderDt;
        }
        public void setMnyOrderDt(Date mnyOrderDt) {
            this.mnyOrderDt = mnyOrderDt;
        }
        public String getBillExNo() {
            return billExNo;
        }
        public void setBillExNo(String billExNo) {
            this.billExNo = billExNo;
        }
        public String getBillExCd() {
            return billExCd;
        }
        public void setBillExCd(String billExCd) {
            this.billExCd = billExCd;
        }
        public String getBillExDt() {
            return billExDt;
        }
        public void setBillExDt(String billExDt) {
            this.billExDt = billExDt;
        }
        public String getCouponNo() {
            return couponNo;
        }
        public void setCouponNo(String couponNo) {
            this.couponNo = couponNo;
        }
        public String getTrnfNo() {
            return trnfNo;
        }
        public void setTrnfNo(String trnfNo) {
            this.trnfNo = trnfNo;
        }
        public Boolean isBackDt() {
            return isBackDt;
        }
        public void setIsBackDt(Boolean isBackDt) {
            this.isBackDt = isBackDt;
        }
        public String getOffsetDocumentNo() {
            return offsetDocumentNo;
        }
        public void setOffsetDocumentNo(String offsetDocumentNo) {
            this.offsetDocumentNo = offsetDocumentNo;
        }
        public String getOffsetAccountCode() {
            return offsetAccountCode;
        }
        public void setOffsetAccountCode(String offsetAccountCode) {
            this.offsetAccountCode = offsetAccountCode;
        }
        public String getOffsetAccountName() {
            return offsetAccountName;
        }
        public void setOffsetAccountName(String offsetAccountName) {
            this.offsetAccountName = offsetAccountName;
        }
        public String getPayChqBankCode() {
            return payChqBankCode;
        }
        public void setPayChqBankCode(String payChqBankCode) {
            this.payChqBankCode = payChqBankCode;
        }
        public String getPayChqBankName() {
            return payChqBankName;
        }
        public void setPayChqBankName(String payChqBankName) {
            this.payChqBankName = payChqBankName;
        }
        public String getPayChqBranch() {
            return payChqBranch;
        }
        public void setPayChqBranch(String payChqBranch) {
            this.payChqBranch = payChqBranch;
        }
        public Date getPayChqDate() {
            return payChqDate;
        }
        public void setPayChqDate(Date payChqDate) {
            this.payChqDate = payChqDate;
        }
        public Boolean getIsBackDt() {
            return isBackDt;
        }
		public String getPostCode() {
			return postCode;
		}

		public void setPostCode(String postCode) {
			this.postCode = postCode;
		}
		

		public Date getUpdateDttm() {
			return updateDttm;
		}

		public void setUpdateDttm(Date updateDttm) {
			this.updateDttm = updateDttm;
		}
		
		public String getUpdateUser() {
			return updateUser;
		}

		public void setUpdateUser(String updateUser) {
			this.updateUser = updateUser;
		}

		public String getOtherType() {
			return otherType;
		}
		public void setOtherType(String otherType) {
			this.otherType = otherType;
		}
		public String getOtherNo() {
			return otherNo;
		}
		public void setOtherNo(String otherNo) {
			this.otherNo = otherNo;
		}
		public Date getOtherDt() {
			return otherDt;
		}
		public void setOtherDt(Date otherDt) {
			this.otherDt = otherDt;
		}

		public String getMethodCase() {
			return methodCase;
		}

		public void setMethodCase(String methodCase) {
			this.methodCase = methodCase;
		}

		public String getCurrencyCode() {
			return currencyCode;
		}

		public void setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
		}

		public BigDecimal getCurrencyRate() {
			return currencyRate;
		}

		public void setCurrencyRate(BigDecimal currencyRate) {
			this.currencyRate = currencyRate;
		}

		public BigDecimal getForeignAmount() {
			return foreignAmount;
		}

		public void setForeignAmount(BigDecimal foreignAmount) {
			this.foreignAmount = foreignAmount;
		}

		public String getBankAcctNo() {
			return bankAcctNo;
		}

		public void setBankAcctNo(String bankAcctNo) {
			this.bankAcctNo = bankAcctNo;
		}

		public String getRefNo() {
			return refNo;
		}

		public void setRefNo(String refNo) {
			this.refNo = refNo;
		}
		
		public String getDocNo() {
			return docNo;
		}

		public void setDocNo(String docNo) {
			this.docNo = docNo;
		}

		@Override
		public String toString() {
			return "Method [code=" + code + ", name=" + name + ", type=" + type + ", amount=" + amount + ", bankCode="
					+ bankCode + ", bankName=" + bankName + ", bankBrnh=" + bankBrnh + ", bankAcct=" + bankAcct
					+ ", transferDt=" + transferDt + ", bankAcCd=" + bankAcCd + ", chequeNo=" + chequeNo + ", chequeDt="
					+ chequeDt + ", cardNo=" + cardNo + ", cardType=" + cardType + ", mnyOrderNo=" + mnyOrderNo
					+ ", mnyOrderCd=" + mnyOrderCd + ", mnyOrderDt=" + mnyOrderDt + ", billExNo=" + billExNo
					+ ", billExCd=" + billExCd + ", billExDt=" + billExDt + ", couponNo=" + couponNo + ", trnfNo="
					+ trnfNo + ", isBackDt=" + isBackDt + ", offsetDocumentNo=" + offsetDocumentNo
					+ ", offsetAccountCode=" + offsetAccountCode + ", offsetAccountName=" + offsetAccountName
					+ ", payChqBankCode=" + payChqBankCode + ", payChqBankName=" + payChqBankName + ", payChqBranch="
					+ payChqBranch + ", payChqDate=" + payChqDate + ", chequeDate=" + chequeDate + ", postCode="
					+ postCode + ", updateDttm=" + updateDttm + ", updateUser=" + updateUser + ", otherType="
					+ otherType + ", otherNo=" + otherNo + ", otherDt=" + otherDt + ", methodCase=" + methodCase + "]";
		}
		
    }

    public static class DeductTax {
        private String type;
        private BigDecimal amount;
        private String withholdingType;
        private String withholdingDocNo;
        private String otherType;
        private String otherDepartment;
        private BigDecimal otherTaxAmount;
        private BigDecimal otherBuyTax;
        private String offsetDocNo;
        private String invoiceNo;
        private String customerNo;
        
        private String costCenter;
    	private BigDecimal withHoldingTax;
    	private BigDecimal taxAmt;
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public BigDecimal getAmount() {
            return amount;
        }
        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
        public String getWithholdingType() {
            return withholdingType;
        }
        public void setWithholdingType(String withholdingType) {
            this.withholdingType = withholdingType;
        }
        public String getWithholdingDocNo() {
            return withholdingDocNo;
        }
        public void setWithholdingDocNo(String withholdingDocNo) {
            this.withholdingDocNo = withholdingDocNo;
        }
        public String getOtherType() {
            return otherType;
        }
        public void setOtherType(String otherType) {
            this.otherType = otherType;
        }
        public String getOtherDepartment() {
            return otherDepartment;
        }
        public void setOtherDepartment(String otherDepartment) {
            this.otherDepartment = otherDepartment;
        }
        public BigDecimal getOtherTaxAmount() {
            return otherTaxAmount;
        }
        public void setOtherTaxAmount(BigDecimal otherTaxAmount) {
            this.otherTaxAmount = otherTaxAmount;
        }
        public BigDecimal getOtherBuyTax() {
            return otherBuyTax;
        }
        public void setOtherBuyTax(BigDecimal otherBuyTax) {
            this.otherBuyTax = otherBuyTax;
        }
        public String getOffsetDocNo() {
            return offsetDocNo;
        }
        public void setOffsetDocNo(String offsetDocNo) {
            this.offsetDocNo = offsetDocNo;
        }
        public String getInvoiceNo() {
            return invoiceNo;
        }
        public void setInvoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
        }
		public String getCustomerNo() {
			return customerNo;
		}
		public void setCustomerNo(String customerNo) {
			this.customerNo = customerNo;
		}
		public String getCostCenter() {
			return costCenter;
		}
		public void setCostCenter(String costCenter) {
			this.costCenter = costCenter;
		}
		public BigDecimal getWithHoldingTax() {
			return withHoldingTax;
		}
		public void setWithHoldingTax(BigDecimal withHoldingTax) {
			this.withHoldingTax = withHoldingTax;
		}
		public BigDecimal getTaxAmt() {
			return taxAmt;
		}
		public void setTaxAmt(BigDecimal taxAmt) {
			this.taxAmt = taxAmt;
		}
        

    }

    public static class InvoiceVatDetail{
        private Long id;
        private Long invoiceId;
        private String invoiceNo;
        private String accountNo;
        private BigDecimal amount;
        private BigDecimal vat;
        private Date issueDt;
        private Date dueDt;
        private Date chargeFromDt;
        private Date chargeToDt;
        private String taxTypeCode;
        private Date updateDttm;
        private String updateUser;
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getInvoiceId() {
            return invoiceId;
        }

        public void setInvoiceId(Long invoiceId) {
            this.invoiceId = invoiceId;
        }

        public String getInvoiceNo() {
            return invoiceNo;
        }

        public void setInvoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public BigDecimal getVat() {
            return vat;
        }

        public void setVat(BigDecimal vat) {
            this.vat = vat;
        }

        public Date getIssueDt() {
            return issueDt;
        }

        public void setIssueDt(Date issueDt) {
            this.issueDt = issueDt;
        }

        public Date getDueDt() {
            return dueDt;
        }

        public void setDueDt(Date dueDt) {
            this.dueDt = dueDt;
        }

        public Date getChargeFromDt() {
            return chargeFromDt;
        }

        public void setChargeFromDt(Date chargeFromDt) {
            this.chargeFromDt = chargeFromDt;
        }

        public Date getChargeToDt() {
            return chargeToDt;
        }

        public void setChargeToDt(Date chargeToDt) {
            this.chargeToDt = chargeToDt;
        }

        public String getTaxTypeCode() {
            return taxTypeCode;
        }

        public void setTaxTypeCode(String taxTypeCode) {
            this.taxTypeCode = taxTypeCode;
        }

        public Date getUpdateDttm() {
            return updateDttm;
        }

        public void setUpdateDttm(Date updateDttm) {
            this.updateDttm = updateDttm;
        }

        public String getUpdateUser() {
            return updateUser;
        }

        public void setUpdateUser(String updateUser) {
            this.updateUser = updateUser;
        }
    }

    public static class AdvancesCase {
    	private String payType;
    	private BigDecimal payAmount;
    	private String payCode;
    	private String payName;
    	private String docNo;
    	
		public String getPayType() {
			return payType;
		}
		public void setPayType(String payType) {
			this.payType = payType;
		}
		public BigDecimal getPayAmount() {
			return payAmount;
		}
		public void setPayAmount(BigDecimal payAmount) {
			this.payAmount = payAmount;
		}
		public String getPayCode() {
			return payCode;
		}
		public void setPayCode(String payCode) {
			this.payCode = payCode;
		}
		public String getPayName() {
			return payName;
		}
		public void setPayName(String payName) {
			this.payName = payName;
		}
		public String getDocNo() {
			return docNo;
		}
		public void setDocNo(String docNo) {
			this.docNo = docNo;
		}

    	
    }

    private BigDecimal amount;
    private BigDecimal payAmount;
    private BigDecimal discount;
    private BigDecimal vatAmount;
    private BigDecimal totalPaid;
    private BigDecimal wtAmount;
    private BigDecimal receiveAmount;
    private BigDecimal remainAmount;
    private String paymentCase;
    private String remark;
    private String language;
    private List<Customer> customers = new ArrayList<Customer>();
    private List<Method> methods = new ArrayList<Method>();
    private List<DeductTax> deducts = new ArrayList<DeductTax>();
    private List<Advanced> advances = new ArrayList<Advanced>();
    private String creditLimitData;
    private String note;
    private String checkSpecial;
    private String genCreditLimit;
    private List<CreditLimitTrans> creditLimitTransList =  new ArrayList<CreditLimitTrans>();
    private String updaetBy;
    private Date updateDate;
    private List<AdvancesCase> advancesCase = new ArrayList<AdvancesCase>();
    private boolean backDateFlag;
    private Date transferDt;
    

    public String getUpdaetBy() {
		return updaetBy;
	}
	public void setUpdaetBy(String updaetBy) {
		this.updaetBy = updaetBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getPayAmount() {
        return payAmount;
    }
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }
    public BigDecimal getDiscount() {
        return discount;
    }
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    public BigDecimal getVatAmount() {
        return vatAmount;
    }
    public void setVatAmount(BigDecimal vatAmount) {
        this.vatAmount = vatAmount;
    }
    public BigDecimal getTotalPaid() {
        return totalPaid;
    }
    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }
    public BigDecimal getWtAmount() {
        return wtAmount;
    }
    public void setWtAmount(BigDecimal wtAmount) {
        this.wtAmount = wtAmount;
    }
    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }
    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }
    public BigDecimal getRemainAmount() {
        return remainAmount;
    }
    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }
    public String getPaymentCase() {
        return paymentCase;
    }
    public void setPaymentCase(String paymentCase) {
        this.paymentCase = paymentCase;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    public List<Method> getMethods() {
        return methods;
    }
    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }
    public List<DeductTax> getDeducts() {
        return deducts;
    }
    public void setDeducts(List<DeductTax> deducts) {
        this.deducts = deducts;
    }
    public List<Advanced> getAdvances() {
        return advances;
    }
    public void setAdvances(List<Advanced> advances) {
        this.advances = advances;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getCreditLimitData() {
        return creditLimitData;
    }
    public void setCreditLimitData(String creditLimitData) {
        this.creditLimitData = creditLimitData;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getCheckSpecial() {
        return checkSpecial;
    }
    public void setCheckSpecial(String checkSpecial) {
        this.checkSpecial = checkSpecial;
    }

    public List<CreditLimitTrans> getCreditLimitTransList() {
        return creditLimitTransList;
    }

    public void setCreditLimitTransList(List<CreditLimitTrans> creditLimitTransList) {
        this.creditLimitTransList = creditLimitTransList;
    }

    public String getGenCreditLimit() {
        return genCreditLimit;
    }

    public void setGenCreditLimit(String genCreditLimit) {
        this.genCreditLimit = genCreditLimit;
    }
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<AdvancesCase> getAdvancesCase() {
		return advancesCase;
	}
	public void setAdvancesCase(List<AdvancesCase> advancesCase) {
		this.advancesCase = advancesCase;
	}
	public boolean isBackDateFlag() {
		return backDateFlag;
	}
	public void setBackDateFlag(boolean backDateFlag) {
		this.backDateFlag = backDateFlag;
	}
	public Date getTransferDt() {
		return transferDt;
	}
	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}
    
	
	
}