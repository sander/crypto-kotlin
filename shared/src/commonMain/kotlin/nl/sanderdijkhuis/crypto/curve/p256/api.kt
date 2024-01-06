@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package nl.sanderdijkhuis.crypto.curve.p256

import nl.sanderdijkhuis.crypto.hash.sha2.Sha256Digest

expect fun generate(): Signer
expect fun Signer.verifier(): Verifier
expect fun Signer.ecdsa(digest: Sha256Digest): Signature
expect fun Signature.isEcdsa(digest: Sha256Digest, key: Verifier): Boolean

expect class Signer
expect class Verifier
expect class Signature
