package com.fdm.observer;

public class RunObserver {
	public static void main(String[] args) {
		TradeRepository repo = new TradeRepository();
		new PositionBlotter(repo);
		
		Trade trade = new Trade(1, "EUR", "AUD");
		repo.update(
				trade, 
				new Trade(2, "GBP", "AUD"),
				new Trade(3, "AUS", "USD")
		);
		System.out.println("Break between update");
		repo.update(trade);
	}
}
