package com.fdm.deadlock;

public class Pen {
	private boolean available = true;

	public synchronized void finished() {
		available = true;
	}

	public boolean isAvailable() {
		if (available) {
			synchronized (this) {
				available = false;
				return true;
			}
		}
		return false;
	}

}
