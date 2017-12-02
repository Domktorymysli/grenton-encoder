package com.github.domktorymysli.grenton.cipher.model;

import junit.framework.TestCase;

public class MessageTest extends TestCase {

    public void testGetMsg() throws Exception {
        String encodedMessage = "10636185295a6dbd45670d1e05db7d457e24a04c720d1789216194593bfcb84b66464f1d3e668a8baf785b5d3c555058c213ab72dfc853aec3a52e98e1c91204297feeeb6d21f35c5db2d5a87a26a4e67efbcce895d7aa790377ddb8051131c866759d5ed579be08f0fe52d815582273b24f7a01bfb6f925323624e2e77c30de1d9f3b8eed230478786540104f4d98ac4fba3dfba41912b28139b1d92d106d867e27c152c70a395c4e19965185ee01290170a1ea0ba7e6fef8bdee7267f69cf9";
        MessageEncoded msg = MessageEncoded.createFromString(encodedMessage);

        assertEquals(msg.getLength(), 192);
        junit.framework.Assert.assertTrue(msg.getMsg() instanceof byte[]);
    }
}