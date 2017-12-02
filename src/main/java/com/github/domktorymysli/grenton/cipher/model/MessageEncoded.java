package com.github.domktorymysli.grenton.cipher.model;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.util.Arrays;
import java.util.Base64;

public class MessageEncoded {

    private byte[] msg;

    private int length = 0;

    public MessageEncoded(byte[] msg, int msgLength) {
        this.msg = msg;
        this.length = msgLength;
    }

    public byte[] getMsg() {
        return this.msg;
    }

    public int getLength() {
        return this.length;
    }

    public String encodeToString() {
        return Base64.getEncoder().encodeToString(this.msg);
    }

    public static MessageEncoded createFromBase64(String msg) throws DecoderException {
        byte[] byteMessage = Base64.getDecoder().decode(msg);
        byte[] messageHolder = new byte[2048];
        System.arraycopy(byteMessage, 0, messageHolder, 0, byteMessage.length);

        return new MessageEncoded(messageHolder, byteMessage.length);
    }

    public static MessageEncoded createFromString(String msg) throws DecoderException {
        byte[] byteMessage = Hex.decodeHex(msg.toCharArray());
        byte[] messageHolder = new byte[2048];
        System.arraycopy(byteMessage, 0, messageHolder, 0, byteMessage.length);

        return new MessageEncoded(messageHolder, byteMessage.length);
    }

    @Override
    public String toString() {
        return "MessageEncoded{" +
                "\nstr=" + new String(this.msg) +
                "\nmsg=" + Arrays.toString(this.msg) +
                "\nlength=" + this.length +
                '}';
    }
}
