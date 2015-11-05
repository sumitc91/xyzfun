package com.funoverflowwebservices.common.core.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;

public class AdvancedEncryptionStandard {
	private static final String ALGO = "AES";
	private static final byte[] salt = new byte[] { 'T', 'h', 'e', 'B', 'e',
			's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };

	public static String encrypt(String Data) throws FunOverflowBaseException {
		
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(Data.getBytes());
			String encryptedValue = new BASE64Encoder().encode(encVal);
			return encryptedValue;
		} catch (InvalidKeyException e) {
			throw new FunOverflowBaseException(" AES Encryption Exception", "", e, false);
		} catch (NoSuchAlgorithmException e) {
			throw new FunOverflowBaseException(" AES Encryption Exception", "", e, false);
		} catch (NoSuchPaddingException e) {
			throw new FunOverflowBaseException(" AES Encryption Exception", "", e, false);
		} catch (IllegalBlockSizeException e) {
			throw new FunOverflowBaseException(" AES Encryption Exception", "", e, false);
		} catch (BadPaddingException e) {
			throw new FunOverflowBaseException(" AES Encryption Exception", "", e, false);
		} catch (Exception e) {
			throw new FunOverflowBaseException(" AES Encryption Exception", "", e, false);
		}
	}

	public static String decrypt(String encryptedData) throws FunOverflowBaseException {
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
			byte[] decValue = c.doFinal(decordedValue);
			String decryptedValue = new String(decValue);
			return decryptedValue;
		} catch (Exception e) {
			throw new FunOverflowBaseException(" AES Decryption Exception", "", e, false);
		}
	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(salt, ALGO);
		return key;
	}

}
