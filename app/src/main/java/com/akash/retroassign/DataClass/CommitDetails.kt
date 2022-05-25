package com.akash.retroassign.DataClass

data class CommitDetails(
    val author: AuthorXX,
    val comments_url: String,
    val commit: CommitX,
    val committer: CommitterXXX,
    val files: List<File>,
    val html_url: String,
    val node_id: String,
    val parents: List<ParentX>,
    val sha: String,
    val stats: Stats,
    val url: String
)