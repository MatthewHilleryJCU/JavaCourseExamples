package com.fdm.observer;

import java.util.List;

public class PositionBlotterSubscription implements Subscription {

	private final PositionBlotter positionBlotter;
	private final TradeRepository tradeRepository;

	public PositionBlotterSubscription(PositionBlotter positionBlotter, TradeRepository tradeRepository) {
		this.positionBlotter = positionBlotter;
		this.tradeRepository = tradeRepository;
		
	}

	@Override
	public void onUpdate() {
		List<Trade> trades = tradeRepository.getTrades();
		positionBlotter.showPosition(trades);
	}
	
}
