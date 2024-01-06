package nl.sanderdijkhuis.crypto.curve.p256

import nl.sanderdijkhuis.crypto.hash.sha2.Sha256Digest
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PublicKey
import java.security.spec.ECGenParameterSpec

private val spec get() = ECGenParameterSpec("secp256r1")
private val signature get() = java.security.Signature.getInstance("NONEwithECDSA")

actual fun generate(): Signer = KeyPairGenerator.getInstance("EC").run {
    initialize(spec)
    generateKeyPair()
}.let { Signer(it) }

actual fun Signer.verifier(): Verifier = Verifier(pair.public)

actual fun Signer.ecdsa(
    digest: Sha256Digest
): Signature = signature.run {
    initSign(pair.private)
    update(digest.bytes)
    sign()
}.let { Signature(it) }

actual fun Signature.isEcdsa(digest: Sha256Digest, key: Verifier): Boolean =
    signature.run {
        initVerify(key.value)
        update(digest.bytes)
        verify(value)
    }

actual data class Signer(val pair: KeyPair)
actual data class Verifier(val value: PublicKey)
actual data class Signature(val value: ByteArray) {
    @OptIn(ExperimentalStdlibApi::class)
    override fun toString(): String = "Signature(${value.toHexString()})"
}
