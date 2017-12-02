package com.github.domktorymysli.grenton.cipher.encoder;

import com.github.domktorymysli.grenton.cipher.model.CipherKey;
import com.github.domktorymysli.grenton.cipher.model.MessageDecoded;
import com.github.domktorymysli.grenton.cipher.model.MessageEncoded;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import java.security.*;

public class Encoder {

    private CipherKey cipherKey;

    public Encoder(CipherKey cipherKey) {
        this.cipherKey = cipherKey;
    }

    public MessageEncoded encode(MessageDecoded message) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, this.cipherKey.getSecretKey(), this.cipherKey.getIvSpec());

        byte[] result = new byte[cipher.getOutputSize(message.getLength())];

        int tmp = cipher.update(message.getMsg(), 0, message.getLength(), result, 0);
        cipher.doFinal(result, tmp);

        return new MessageEncoded(result, result.length);
    }
}
