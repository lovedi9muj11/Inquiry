package th.co.maximus.payment.bean;

import java.io.Serializable;

public class PaymentTaxBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String invoiceNo;
	private String radioDed;
	private String docDed;
	private double moneyDed;
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getRadioDed() {
		return radioDed;
	}
	public void setRadioDed(String radioDed) {
		this.radioDed = radioDed;
	}
	public String getDocDed() {
		return docDed;
	}
	public void setDocDed(String docDed) {
		this.docDed = docDed;
	}
	public double getMoneyDed() {
		return moneyDed;
	}
	public void setMoneyDed(double moneyDed) {
		this.moneyDed = moneyDed;
	}

	
}
