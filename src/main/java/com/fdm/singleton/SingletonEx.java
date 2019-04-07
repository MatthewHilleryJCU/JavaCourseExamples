package com.fdm.singleton;

public class SingletonEx {

	public static void main(String[] args) {
		new Thread(
			() -> {
				FilingCabinet  instance = FilingCabinet.getInstance();
				System.out.println(instance);
			}
				
		).start();
		
		new Thread(
				() -> {
					FilingCabinet  instance = FilingCabinet.getInstance();
					System.out.println(instance);
				}
					
			).start();
		
		FilingCabinet  instance = FilingCabinet.getInstance();
		System.out.println(instance);

	}

}
