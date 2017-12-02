package com.github.domktorymysli.grenton.cipher.model;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CipherKey {

    private transient SecretKeySpec key;
    private transient IvParameterSpec ivSpec;

    public CipherKey(byte[] key, byte[] iv) {
        this.key = new SecretKeySpec(key, "AES");
        this.ivSpec = new IvParameterSpec(iv);
    }

    static public CipherKey createFromString(String key, String iv) {
        byte[] keyBytes = Base64.getDecoder().decode(key);
        byte[] ivBytes = Base64.getDecoder().decode(iv);

        return new CipherKey(keyBytes, ivBytes);
    }

    public SecretKeySpec getSecretKey() {
        return this.key;
    }

    public IvParameterSpec getIvSpec() {
        return this.ivSpec;
    }

}
