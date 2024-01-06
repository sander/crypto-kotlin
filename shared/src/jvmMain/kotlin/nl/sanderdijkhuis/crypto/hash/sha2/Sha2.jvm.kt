package nl.sanderdijkhuis.crypto.hash.sha2

import java.security.MessageDigest

actual fun ByteArray.sha256() = MessageDigest.getInstance("SHA-256").run {
    update(this@sha256)
    digest()
}.let { Sha256Digest(it) }
