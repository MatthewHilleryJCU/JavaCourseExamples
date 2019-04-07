package com.fdm.observer;

public class Trade {
	private int tradeId;
	private String ccy1;
	private String ccy2;
	
	
	
	
	public Trade(int tradeId, String ccy1, String ccy2) {
		super();
		this.tradeId = tradeId;
		this.ccy1 = ccy1;
		this.ccy2 = ccy2;
	}




	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", ccy1=" + ccy1 + ", ccy2=" + ccy2 + "]";
	}
	
	
}
