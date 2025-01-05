package com.teddac.toutdouxliste.model

import java.time.LocalDateTime

data class Task(
    val title: String,
    val description: String,
    val isDone: Boolean,
    val date: LocalDateTime
)