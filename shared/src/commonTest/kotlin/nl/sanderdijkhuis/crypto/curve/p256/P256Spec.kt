package nl.sanderdijkhuis.crypto.curve.p256

import nl.sanderdijkhuis.crypto.hash.sha2.sha256
import kotlin.test.Test
import kotlin.test.assertTrue

class P256Spec {

    @Test
    fun `sign and verify`() {
        val key = generate()
        val message = "Hello, World!".encodeToByteArray()
        val signature = key.ecdsa(message.sha256())
        assertTrue { signature.isEcdsa(message.sha256(), key.verifier()) }
    }
}
