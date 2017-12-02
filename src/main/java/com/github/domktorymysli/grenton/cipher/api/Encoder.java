package com.github.domktorymysli.grenton.cipher.api;

import com.github.domktorymysli.grenton.cipher.api.exception.GrentonEncoderException;
import com.github.domktorymysli.grenton.cipher.model.MessageDecoded;
import com.github.domktorymysli.grenton.cipher.model.MessageEncoded;

public interface Encoder {

    MessageDecoded decode(MessageEncoded message) throws GrentonEncoderException;

    MessageEncoded encode(MessageDecoded message) throws GrentonEncoderException;

}
