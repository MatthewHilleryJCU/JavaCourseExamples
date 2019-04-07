package com.fdm.singleton;


public class FilingCabinet {
	
	private static FilingCabinet instance;
	private static final Object key = new Object();
	private FilingCabinet() {}
		
	public static FilingCabinet getInstance() {
		if(instance == null) {
			synchronized (key) {
				if (instance == null) {
					instance = new FilingCabinet();
				}
			}
		}
		return instance;
	}

}
