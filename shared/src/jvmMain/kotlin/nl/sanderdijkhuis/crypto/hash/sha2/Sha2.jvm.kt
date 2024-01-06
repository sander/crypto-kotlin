package nl.sanderdijkhuis.crypto.hash.sha2

import java.security.MessageDigest

actual fun Sequence<ByteArray>.sha256() = MessageDigest.getInstance("SHA-256").run {
    for (bytes in this@sha256) update(bytes)
    digest()
}.let { Sha256Digest(it) }
