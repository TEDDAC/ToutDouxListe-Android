package com.teddac.toutdouxliste.model

import java.time.LocalDateTime

data class Task(
    val title: String = "",
    val description: String? = null,
    val isDone: Boolean = false,
    val date: LocalDateTime? = null
)