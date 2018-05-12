package th.co.maximus.model;

import java.math.BigDecimal;
import java.util.List;

public class TrsMethodEpisOffline {
	private Long id;
	private String code;
	private String name;
	private String chequeNo;
	private String creditNo;
	private String accountNo;
	private BigDecimal amount;
	private List<TrsCreditrefEpisOffline> trsCreditrefEpisOffline;
	private List<TrsChequerefEpisOffline> trsChequerefEpisOffline;
	public TrsMethodEpisOffline(){}
	public TrsMethodEpisOffline(String code,String name,String creditNo,String chequeNo,String accountNo,BigDecimal amount,Long id){
		
		this.code = code;
		this.name = name;
		this.chequeNo = chequeNo;
		this.creditNo = creditNo;
		this.accountNo = accountNo;
		this.amount = amount;
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getCreditNo() {
		return creditNo;
	}
	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
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
	public List<TrsCreditrefEpisOffline> getTrsCreditrefEpisOffline() {
		return trsCreditrefEpisOffline;
	}
	public void setTrsCreditrefEpisOffline(List<TrsCreditrefEpisOffline> trsCreditrefEpisOffline) {
		this.trsCreditrefEpisOffline = trsCreditrefEpisOffline;
	}
	public List<TrsChequerefEpisOffline> getTrsChequerefEpisOffline() {
		return trsChequerefEpisOffline;
	}
	public void setTrsChequerefEpisOffline(List<TrsChequerefEpisOffline> trsChequerefEpisOffline) {
		this.trsChequerefEpisOffline = trsChequerefEpisOffline;
	}


	
	
	
}
