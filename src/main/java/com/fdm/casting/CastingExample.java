package com.fdm.casting;

public class CastingExample {
	public static void main(String[] args) {
		accessTrades(new Trade(), new FXTrade());
	}
	
	private static void accessTrades(Trade...trades) {
		for(Trade trade : trades) {
			trade.methodInTrade();
			if(trade instanceof FXTrade) {
			FXTrade fx = (FXTrade) trade;
			fx.methodInFXTrade();	
			}
			
		}
	}
}
