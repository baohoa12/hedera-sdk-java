package com.hedera.hashgraph.sdk;

import org.junit.jupiter.api.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

class KeyTest {
    @Test
    void signatureVerified() {
        byte[] message = "Hello, World".getBytes(UTF_8);
        PrivateKey privateKey = PrivateKey.generateEd25519();
        PublicKey publicKey = privateKey.getPublicKey();
        byte[] signature = privateKey.sign(message);

        assertThat(publicKey.verify(message, signature)).isTrue();
    }
}
