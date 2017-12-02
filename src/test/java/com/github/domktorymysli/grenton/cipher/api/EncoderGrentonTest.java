package com.github.domktorymysli.grenton.cipher.api;

import com.github.domktorymysli.grenton.cipher.model.MessageDecoded;
import com.github.domktorymysli.grenton.cipher.model.MessageEncoded;
import junit.framework.Assert;
import junit.framework.TestCase;

public class EncoderGrentonTest extends TestCase {

    public void testEncode() throws Exception {

        EncoderGrenton encoderGrenton = new EncoderGrenton("KY1Ajg+pDBQcP2cHnIFNRQ==", "/gV+nXMOUlBbuc3uhkk/eA==");
        MessageDecoded messageDecoded = new MessageDecoded("Grenton");

        MessageEncoded messageEncoded = encoderGrenton.encode(messageDecoded);

        Assert.assertEquals("x+jIqB7ktCRi/57AJgZl0Q==", messageEncoded.encodeToString());

    }

    public void testDecode() throws Exception {

        EncoderGrenton encoderGrenton = new EncoderGrenton("KY1Ajg+pDBQcP2cHnIFNRQ==", "/gV+nXMOUlBbuc3uhkk/eA==");
        MessageEncoded messageEncoded = MessageEncoded.createFromBase64("x+jIqB7ktCRi/57AJgZl0Q==");

        MessageDecoded messageDecoded = encoderGrenton.decode(messageEncoded);

        Assert.assertEquals("Grenton", messageDecoded.toString());
    }

}