package com.fdm.serialization;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class UserSerializer {
	
	public static void main(String[] args) throws IOException {
		User user = new User("Matt", 12, new Portfolio(13));
		
		UserSerializer serializer = new UserSerializer();
		serializer.serialize(user);
		
		User deserializer = serializer.deserialize();
		System.out.println(deserializer.getUsername());
		System.out.println(deserializer.getAge());
		System.out.println(deserializer.getPortfolio().getPortfolioId());
		
	}

	public void serialize(User user) throws IOException {
		File file = new File("C:\\Users\\local.user\\users.bin");
		FileOutputStream fos = new FileOutputStream(file, true);
		DataOutputStream dos = new DataOutputStream(fos);

		boolean isNull = user == null;
		dos.writeBoolean(isNull);
		if (!isNull) {
			if (user.getUsername() == null) {
				dos.writeBoolean(true);
			} else {
				dos.writeBoolean(false);
				dos.writeUTF(user.getUsername());
			}
			dos.writeInt(user.getAge());
			if (user.getPortfolio() == null) {
				dos.writeBoolean(true);
			} else {
				dos.writeBoolean(false);
				dos.writeInt(user.getPortfolio().getPortfolioId());

			}

		}
		dos.flush();
		dos.close();

	}

	
	public User deserialize() throws IOException {
		File file = new File("C:\\Users\\local.user\\users.bin");
		FileInputStream fis = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(fis);
		String username = null;
		int age = 0;
		int portfolioID = 0;
		Portfolio portfolio = null;
		
		if(!dis.readBoolean()) {
			if (!dis.readBoolean()) {
				username = dis.readUTF();
			}
			age = dis.readInt();
			if(!dis.readBoolean()) {
				portfolioID = dis.readInt();
				portfolio = new Portfolio(portfolioID);
			}
			dis.close();
			return new User(username, age, portfolio);
		}
		
		dis.close();
		return null;
	}
}
