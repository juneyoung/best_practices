package org.owls.tfarm.utils.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoUtils {
	
	public static String MD5(String str) throws NoSuchAlgorithmException {
		return MD5(str, false);
	}
	
	public static String MD5(String str, boolean spaceAllow) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		if(!spaceAllow) str = str.trim();
		
		digest.update(str.getBytes());
		byte bytes[] = digest.digest();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i]&0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

};