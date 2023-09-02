package com.ram.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashGenerator {
	
	private MD5HashGenerator() {
		
	}
	
	public static String generate(String input) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(StandardCharsets.UTF_8.encode(input));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return String.format("%032x", new BigInteger(1, md5.digest()));
	}
}
