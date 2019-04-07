package com.fdm.observer;

@FunctionalInterface
public interface Subscription {
	void onUpdate();
}
