package com.fdm.digitalclock;

public class Minutes implements Runnable {
	private int minuteCount = 0;
	private Hours hours;

	public Minutes(Hours hours) {
		super();
		this.hours = hours;
	}

	public int getMinuteCount() {
		return minuteCount;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
				}

				minuteCount++;
				if (minuteCount == 60) {
					minuteCount = 0;
					synchronized (hours) {
						hours.notify();
					}
				}
			}
		}
	}

}
