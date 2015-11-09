package com.example.mobilesafer.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
	public static String encode(String password) {
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest instance = MessageDigest.getInstance("MD5");
			byte[] digest = instance.digest(password.getBytes());
			
			
			for(byte b : digest) {
				int i = b & 0xff;//È¡µÍ°ËÎ»
				String hexString = Integer.toHexString(i);
				if(hexString.length() < 2) {
					hexString = "0" + hexString;
				}
				sb.append(hexString);
			}
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		return sb.toString();
		
	}
}
