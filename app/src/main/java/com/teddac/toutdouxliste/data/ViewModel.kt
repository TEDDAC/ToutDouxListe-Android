package com.teddac.toutdouxliste.data

import androidx.lifecycle.ViewModel
import com.teddac.toutdouxliste.model.Task
import com.teddac.toutdouxliste.utils.ImmutableList

class TaskViewModel : ViewModel() {
    private var _tasks = Stub().tasks

    fun getTasks(): List<Task>{
        return ImmutableList(_tasks)
    }

    fun getTask(taskId: Int): Task {
        return _tasks[taskId]
    }
}