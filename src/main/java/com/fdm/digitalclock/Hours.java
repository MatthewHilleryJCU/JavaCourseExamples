package com.fdm.digitalclock;

public class Hours implements Runnable {

	private int hourCount = 0;

	public int getHourCount() {
		return hourCount;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
				hourCount++;

				if (hourCount == 24) {
					hourCount = 0;
				}
			}
		}
	}
}
