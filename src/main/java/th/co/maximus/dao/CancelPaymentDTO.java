package th.co.maximus.dao;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelPaymentDTO {

	public static class Receipt {
		private Long id;
		private String no;
		private String reasonCode;
		private String reasonDesc;
		private String accountName;
		private String addrLine1;
		private String canceldate;
		private String cancelBy;
		private String accountNo;
		private String canceluserAuthen;
		private String cancelReason;
		private String cancelCode;
		private String isIbaiss;
		private String cancelTaxId;
		private String cancelBranch;
		
		public String getCancelBy() {
			return cancelBy;
		}
		public void setCancelBy(String cancelBy) {
			this.cancelBy = cancelBy;
		}
		public String getCancelCode() {
			return cancelCode;
		}
		public void setCancelCode(String cancelCode) {
			this.cancelCode = cancelCode;
		}
		public String getCancelReason() {
			return cancelReason;
		}
		public void setCancelReason(String cancelReason) {
			this.cancelReason = cancelReason;
		}
		public String getCanceluserAuthen() {
			return canceluserAuthen;
		}
		public void setCanceluserAuthen(String canceluserAuthen) {
			this.canceluserAuthen = canceluserAuthen;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNo() {
			return no;
		}
		public void setNo(String no) {
			this.no = no;
		}
		public String getReasonCode() {
			return reasonCode;
		}
		public void setReasonCode(String reasonCode) {
			this.reasonCode = reasonCode;
		}
		public String getReasonDesc() {
			return reasonDesc;
		}
		public void setReasonDesc(String reasonDesc) {
			this.reasonDesc = reasonDesc;
		}

		public String getCancelTaxId() {
			return cancelTaxId;
		}
		public void setCancelTaxId(String cancelTaxId) {
			this.cancelTaxId = cancelTaxId;
		}
		public String getCancelBranch() {
			return cancelBranch;
		}
		public void setCancelBranch(String cancelBranch) {
			this.cancelBranch = cancelBranch;
		}
		public String getAccountName() { return accountName; }

		public void setAccountName(String accountName) { this.accountName = accountName; }

		public String getAddrLine1() { return addrLine1; }

		public void setAddrLine1(String addrLine1) { this.addrLine1 = addrLine1; }
		
		public String getCanceldate() {return canceldate;		}
		public void setCanceldate(String canceldate) {this.canceldate = canceldate;	}
		/**
		 * @return the accountNo
		 */
		public String getAccountNo() {
			return accountNo;
		}
		/**
		 * @param accountNo the accountNo to set
		 */
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}
		public String getIsIbaiss() {
			return isIbaiss;
		}
		public void setIsIbaiss(String isIbaiss) {
			this.isIbaiss = isIbaiss;
		}

	}
	private String cancelflagOffline;
	private String bankaccountName;
	private String bankaccountNo;
	private String bankName;
	private String branch;
	private String serviceNo;
	private String reverseType;
	private String oderId;
	private String property4;
	private String reasonCode;
	private String reasonDesc;
	private List<Receipt> receipts = new ArrayList<Receipt>();
	private String userAuthen;
	private boolean flgNewReceipt;
	private String flagCancel;
	private boolean flagEndDayCloseAcc;
	private boolean flgNewReceiptABVR;
	private boolean flagBackDate;
	private boolean flagCloseAcc;
	
	
	public String getCancelflagOffline() {
		return cancelflagOffline;
	}
	public void setCancelflagOffline(String cancelflagOffline) {
		this.cancelflagOffline = cancelflagOffline;
	}
	public boolean isFlagBackDate() {
		return flagBackDate;
	}
	public void setFlagBackDate(boolean flagBackDate) {
		this.flagBackDate = flagBackDate;
	}
	public String getProperty4() {
		return property4;
	}
	public void setProperty4(String property4) {
		this.property4 = property4;
	}
	public boolean isFlgNewReceiptABVR() {
		return flgNewReceiptABVR;
	}
	public void setFlgNewReceiptABVR(boolean flgNewReceiptABVR) {
		this.flgNewReceiptABVR = flgNewReceiptABVR;
	}
	public boolean isFlagEndDayCloseAcc() {
		return flagEndDayCloseAcc;
	}
	public void setFlagEndDayCloseAcc(boolean flagEndDayCloseAcc) {
		this.flagEndDayCloseAcc = flagEndDayCloseAcc;
	}
	public String getFlagCancel() {
		return flagCancel;
	}
	public void setFlagCancel(String flagCancel) {
		this.flagCancel = flagCancel;
	}
	/**
	 * @return the bankaccountName
	 */
	public String getBankaccountName() {
		return bankaccountName;
	}
	/**
	 * @param bankaccountName the bankaccountName to set
	 */
	public void setBankaccountName(String bankaccountName) {
		this.bankaccountName = bankaccountName;
	}
	/**
	 * @return the bankaccountNo
	 */
	public String getBankaccountNo() {
		return bankaccountNo;
	}
	/**
	 * @param bankaccountNo the bankaccountNo to set
	 */
	public void setBankaccountNo(String bankaccountNo) {
		this.bankaccountNo = bankaccountNo;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * @return the serviceNo
	 */
	public String getServiceNo() {
		return serviceNo;
	}
	/**
	 * @param serviceNo the serviceNo to set
	 */
	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}
	/**
	 * @return the reverseType
	 */
	public String getReverseType() {
		return reverseType;
	}
	/**
	 * @param reverseType the reverseType to set
	 */
	public void setReverseType(String reverseType) {
		this.reverseType = reverseType;
	}
	/**
	 * @return the oderId
	 */
	public String getOderId() {
		return oderId;
	}
	/**
	 * @param oderId the oderId to set
	 */
	public void setOderId(String oderId) {
		this.oderId = oderId;
	}
	/**
	 * @return the reasonCode
	 */
	public String getReasonCode() {
		return reasonCode;
	}
	/**
	 * @param reasonCode the reasonCode to set
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	/**
	 * @return the reasonDesc
	 */
	public String getReasonDesc() {
		return reasonDesc;
	}
	/**
	 * @param reasonDesc the reasonDesc to set
	 */
	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}
	/**
	 * @return the receipts
	 */
	public List<Receipt> getReceipts() {
		return receipts;
	}
	/**
	 * @param receipts the receipts to set
	 */
	public void setReceipts(List<Receipt> receipts) {
		this.receipts = receipts;
	}
	/**
	 * @return the userAuthen
	 */
	public String getUserAuthen() {
		return userAuthen;
	}
	/**
	 * @param userAuthen the userAuthen to set
	 */
	public void setUserAuthen(String userAuthen) {
		this.userAuthen = userAuthen;
	}
	/**
	 * @return the flgNewReceipt
	 */
	public boolean isFlgNewReceipt() {
		return flgNewReceipt;
	}
	/**
	 * @param flgNewReceipt the flgNewReceipt to set
	 */
	public void setFlgNewReceipt(boolean flgNewReceipt) {
		this.flgNewReceipt = flgNewReceipt;
	}
	public boolean isFlagCloseAcc() {
		return flagCloseAcc;
	}
	public void setFlagCloseAcc(boolean flagCloseAcc) {
		this.flagCloseAcc = flagCloseAcc;
	}

	
	
	
}