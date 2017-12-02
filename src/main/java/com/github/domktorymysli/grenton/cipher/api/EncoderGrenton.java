package com.github.domktorymysli.grenton.cipher.api;

import com.github.domktorymysli.grenton.cipher.api.exception.GrentonEncoderException;
import com.github.domktorymysli.grenton.cipher.encoder.Decoder;
import com.github.domktorymysli.grenton.cipher.model.CipherKey;
import com.github.domktorymysli.grenton.cipher.model.MessageDecoded;
import com.github.domktorymysli.grenton.cipher.model.MessageEncoded;

public class EncoderGrenton implements Encoder {

    private CipherKey cipherKey;

    private Decoder decoder;

    private com.github.domktorymysli.grenton.cipher.encoder.Encoder encoder;

    public EncoderGrenton(String key, String iv) {
        this.cipherKey = CipherKey.createFromString(key, iv);
        this.decoder = new Decoder(this.cipherKey);
        this.encoder = new com.github.domktorymysli.grenton.cipher.encoder.Encoder(this.cipherKey);
    }

    @Override
    public MessageDecoded decode(MessageEncoded message) throws GrentonEncoderException {

        try {
            return this.decoder.decode(message);
        } catch (Exception e) {
            throw new GrentonEncoderException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public MessageEncoded encode(MessageDecoded message) throws GrentonEncoderException {
        try {
            return this.encoder.encode(message);
        } catch (Exception e) {
            throw new GrentonEncoderException(e.getMessage(), e.getCause());
        }
    }
}

