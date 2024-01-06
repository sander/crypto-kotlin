package nl.sanderdijkhuis.crypto.hash.sha2

expect fun Sequence<ByteArray>.sha256(): Sha256Digest

data class Sha256Digest(val bytes: ByteArray) {
    init {
        require(bytes.size == 32)
    }

    override fun equals(other: Any?) =
        this === other || (other as? Sha256Digest)?.let { bytes.contentEquals(it.bytes) } ?: false

    override fun hashCode() = bytes.contentHashCode()
}

fun ByteArray.asDigest() = Sha256Digest(this)
