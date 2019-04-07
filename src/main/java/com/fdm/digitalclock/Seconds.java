package com.fdm.digitalclock;

public class Seconds implements Runnable {

	private Minutes minutes;
	private int secondCount = 0;

	public Seconds(Minutes minutes) {
		this.minutes = minutes;
	}

	public int getSecondCount() {
		return secondCount;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
				}

				secondCount++;
				if (secondCount == 60) {
					secondCount = 0;
					synchronized (minutes) {
						minutes.notify();
					}
				}
			}
		}
	}

}
