package com.akash.retroassign.DataClass

data class VerificationX(
    val payload: String,
    val reason: String,
    val signature: String,
    val verified: Boolean
)