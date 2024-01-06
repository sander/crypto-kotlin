package nl.sanderdijkhuis.crypto.hash.sha2

import kotlin.test.Test
import kotlin.test.assertContentEquals

@OptIn(ExperimentalStdlibApi::class)
class Sha256Spec {

    @Test
    fun `test vector`() {
        val message = ("6d1e72ad03ddeb5de891e572e2396f8da015d899ef0e79503152d6010a3fe691" +
                "6d1e72ad03ddeb5de891e572e2396f8da015d899ef0e79503152d6010a3fe691" +
                "6d1e72ad03ddeb5de891e572e2396f8da015d899ef0e79503152d6010a3fe691").hexToByteArray()
        val digest = sequenceOf(message).sha256().value
        assertContentEquals("48ce52ff25e30519ea7a047d23869065c3c6ed7bde0c9069e15fd4deb747e259".hexToByteArray(), digest)
    }
}
