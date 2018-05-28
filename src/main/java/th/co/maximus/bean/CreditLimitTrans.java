package th.co.maximus.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by imake on 01/03/2017
 */
public class CreditLimitTrans implements Serializable {

    private static final long serialVersionUID = -8731913204064347537L;
    private String contract;
    private String arRef;
    private String payType;
    private String amountIncVat;
    private String payDate;
    private String msisdn;
    private String receiptId;
    private String vatAmount;
    private String amountExVat;
    private String postDate;
    private String accountNo;
    private String arInvdate;
    private String arDuedate;
    private String received;
    private String msisdnSize;
    private List<String> msisdnList;
    private String status;

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getArRef() {
        return arRef;
    }

    public void setArRef(String arRef) {
        this.arRef = arRef;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAmountIncVat() {
        return amountIncVat;
    }

    public void setAmountIncVat(String amountIncVat) {
        this.amountIncVat = amountIncVat;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public String getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(String vatAmount) {
        this.vatAmount = vatAmount;
    }

    public String getAmountExVat() {
        return amountExVat;
    }

    public void setAmountExVat(String amountExVat) {
        this.amountExVat = amountExVat;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getArInvdate() {
        return arInvdate;
    }

    public void setArInvdate(String arInvdate) {
        this.arInvdate = arInvdate;
    }

    public String getArDuedate() {
        return arDuedate;
    }

    public void setArDuedate(String arDuedate) {
        this.arDuedate = arDuedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getMsisdnSize() {
        return msisdnSize;
    }

    public void setMsisdnSize(String msisdnSize) {
        this.msisdnSize = msisdnSize;
    }

    public List<String> getMsisdnList() {
        return msisdnList;
    }

    public void setMsisdnList(List<String> msisdnList) {
        this.msisdnList = msisdnList;
    }
}
