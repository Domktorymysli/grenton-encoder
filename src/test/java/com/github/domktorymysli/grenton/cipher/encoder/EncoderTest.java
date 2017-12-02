package com.github.domktorymysli.grenton.cipher.encoder;

import com.github.domktorymysli.grenton.cipher.model.CipherKey;
import com.github.domktorymysli.grenton.cipher.model.MessageDecoded;
import com.github.domktorymysli.grenton.cipher.model.MessageEncoded;
import junit.framework.Assert;
import junit.framework.TestCase;

public class EncoderTest extends TestCase {

    public void testEncode() throws Exception {

        CipherKey cipherKey = CipherKey.createFromString("KY1Ajg+pDBQcP2cHnIFNRQ==", "/gV+nXMOUlBbuc3uhkk/eA==");

        Encoder encoder = new Encoder(cipherKey);
        Decoder decoder = new Decoder(cipherKey);

        MessageDecoded messageDecodedSource = new MessageDecoded("Grenton");
        MessageEncoded messageEncoded = encoder.encode(messageDecodedSource);
        MessageDecoded messageDecodedResult = decoder.decode(messageEncoded);

        Assert.assertEquals(messageDecodedSource.toString(), messageDecodedResult.toString());
    }

}
