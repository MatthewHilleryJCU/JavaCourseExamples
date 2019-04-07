package com.fdm.observer;

import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class PositionBlotter {
	
	private Subscription subscription;
	private TradeRepository tradeRepository;
	
	public PositionBlotter(TradeRepository tradeRepository) {
		this.tradeRepository = tradeRepository;
		subscription = new PositionBlotterSubscription(this, tradeRepository);
		
		tradeRepository.subscribe(subscription);
		
	}
	
	public void showPosition(List<Trade> trades) {
		trades.forEach(System.out::println);
	}
	
	public void destroy() {
		tradeRepository.unSubscribe(subscription);
	}
}
