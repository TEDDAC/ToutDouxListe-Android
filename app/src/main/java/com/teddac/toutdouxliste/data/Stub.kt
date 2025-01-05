package com.teddac.toutdouxliste.data

import com.teddac.toutdouxliste.model.Task
import java.time.LocalDateTime

class Stub {
    val tasks = mutableListOf(
        Task(title = "Todo1", description = "Lorem ipsum dolor sit amet", isDone = false, date = LocalDateTime.now()),
        Task(title = "Clean desktop", description = "delete icons guys", isDone = false, date = LocalDateTime.now()),
        Task(title = "Another thing to do", description = "thins that you do (by Slynk)", isDone = true, date = LocalDateTime.now()),
        Task(title = "Cook a tartiflette", description = "Be careful with the four", isDone = true, date = LocalDateTime.now()),
        Task(title = "Walk the dog", description = "I have a dog ?!", isDone = false, date = LocalDateTime.now()),
        Task(title = "Cook a raclette", description = "tell me your french without tell it", isDone = true, date = LocalDateTime.now()),
    )
}