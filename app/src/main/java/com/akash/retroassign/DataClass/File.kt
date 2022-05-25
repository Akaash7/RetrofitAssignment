package com.akash.retroassign.DataClass

data class File(
    val additions: Int,
    val blob_url: String,
    val changes: Int,
    val contents_url: String,
    val deletions: Int,
    val filename: String,
    val patch: String,
    val raw_url: String,
    val sha: String,
    val status: String
)