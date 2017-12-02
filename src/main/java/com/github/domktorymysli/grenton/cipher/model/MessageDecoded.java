package com.github.domktorymysli.grenton.cipher.model;

public class MessageDecoded {

    private byte[] msg;

    private int length;

    public MessageDecoded(String msg) {
        this.msg = msg.getBytes();
        this.length = msg.getBytes().length;
    }

    public MessageDecoded(byte[] msg) {
        this.msg = msg;
        this.length = msg.length;
    }

    public byte[] getMsg() {
        return msg;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return new String(this.getMsg());
    }
}
