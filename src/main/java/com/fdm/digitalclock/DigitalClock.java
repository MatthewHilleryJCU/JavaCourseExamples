package com.fdm.digitalclock;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DigitalClock {

	public static void main(String[] args) {
		Hours hours = new Hours();
		Minutes minutes = new Minutes(hours);
		Seconds seconds = new Seconds(minutes);

		Thread tH = new Thread(hours);
		Thread tM = new Thread(minutes);
		Thread tS = new Thread(seconds);
		
		tH.start();
		tM.start();
		tS.start();

		while (true) {
			try {
				Thread.sleep(950);
				synchronized (seconds) {
					seconds.notify();
					System.out.println(
							hours.getHourCount() + ":" + minutes.getMinuteCount() + ":" + seconds.getSecondCount());
				}
			} catch (InterruptedException e) {
			}
		}
	}
}
