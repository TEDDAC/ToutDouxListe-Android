package com.teddac.toutdouxliste.data

import com.teddac.toutdouxliste.model.Task
import java.time.LocalDateTime

class Stub {
    val tasks = mutableListOf(
        Task(title = "Todo1", description = "Lorem ipsum dolor sit amet", isDone = false, date = LocalDateTime.now()),
        Task(title = "Clean desktop", description = "delete icons guys", isDone = false, date = LocalDateTime.parse("2024-04-30T23:58:00")),
        Task(title = "Another thing to do", isDone = true, date = LocalDateTime.parse("2024-06-18T12:30:00")),
        Task(title = "Cook a tartiflette", description = "Be careful with the four", isDone = true, date = LocalDateTime.parse("2024-09-11T09:38:00")),
        Task(title = "Walk the dog", isDone = false),
        Task(title = "Cook a raclette", description = "tell me your french without tell it", isDone = true, date = LocalDateTime.parse("2026-12-25T00:00:00")),
    )
}