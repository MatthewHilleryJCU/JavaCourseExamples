package com.fdm.observer;

import java.util.*;

public class TradeRepository {
	
	private final List<Subscription> subscribers = new ArrayList<>();
	private final List<Trade> trades = new ArrayList<>();
	
	public void update (Trade...trades) {
		boolean hasNewTrade = false;
		for(Trade trade : trades) {
			if (!this.trades.contains(trade)) {
				hasNewTrade = true;
				this.trades.add(trade);
				
			}
		}
		if (hasNewTrade) {
			notifySubscribers();
		}
	}
	
	
	
	public List<Trade> getTrades() {
		return trades;
	}



	private void notifySubscribers() {
		subscribers.forEach(Subscription::onUpdate);
		 
//		subscribers.forEach((s) -> {s.onUpdate();});         //Lambda
	
	}

	public void subscribe(Subscription subscription) {
		subscribers.add(subscription);
	}
	
	public void unSubscribe(Subscription subscription) {
		subscribers.remove(subscription);
	}
	
}
