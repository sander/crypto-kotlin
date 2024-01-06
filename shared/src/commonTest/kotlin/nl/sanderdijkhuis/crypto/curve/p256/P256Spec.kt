package nl.sanderdijkhuis.crypto.curve.p256

import nl.sanderdijkhuis.crypto.hash.sha2.sha256
import kotlin.test.Test
import kotlin.test.assertTrue

class P256Spec {

    @Test
    fun `sign and verify`() {
        val key = generate()
        val message = "Hello, World!".encodeToByteArray()
        val digest = sequenceOf(message).sha256()
        val signature = key.ecdsa(digest)
        assertTrue { signature.isEcdsa(digest, key.verifier()) }
    }
}
