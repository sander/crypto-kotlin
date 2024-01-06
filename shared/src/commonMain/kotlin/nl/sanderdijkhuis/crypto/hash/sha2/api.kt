package nl.sanderdijkhuis.crypto.hash.sha2

import kotlin.jvm.JvmInline

expect fun ByteArray.sha256(): Sha256Digest

@JvmInline
value class Sha256Digest(val value: ByteArray) {
    init {
        require(value.size == 32)
    }
}
