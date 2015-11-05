package com.funoverflowwebservices.common.core.utils;

import com.funoverflowwebservices.common.core.exception.FunOverflowBaseException;

public class EncryptionUtil {
	public String encrypt(String plainText) throws FunOverflowBaseException {
		if (plainText == null)
			return null;
		return AdvancedEncryptionStandard.encrypt(plainText);
	}

	public String decrypt(String encryptedText) throws FunOverflowBaseException {
		if (encryptedText == null)
			return null;
		return AdvancedEncryptionStandard.decrypt(encryptedText);
	}

	public String SHA1Encryption(String plainText) throws FunOverflowBaseException {
		if (plainText == null)
			return null;
		return SimpleSHA1.SHA1(plainText);
	}

	public String profileIdEncryption(String profileId)
			throws FunOverflowBaseException {
		return encrypt(profileId);
		//return profileId;
	}

	public String profileIdDecryption(String encryptedProfileId)
			throws FunOverflowBaseException {
		return decrypt(encryptedProfileId);
		//return encryptedProfileId;
	}
}
