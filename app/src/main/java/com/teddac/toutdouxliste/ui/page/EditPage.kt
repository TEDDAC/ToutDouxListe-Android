package com.teddac.toutdouxliste.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.teddac.toutdouxliste.data.TaskViewModel
import com.teddac.toutdouxliste.model.Task
import com.teddac.toutdouxliste.ui.component.CustomDatePicker
import com.teddac.toutdouxliste.ui.component.CustomTimePicker
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPage(
    taskId: Int?,
    viewModel: TaskViewModel = TaskViewModel(),
    onSave: () -> Unit,
    onCancel: () -> Unit
){
    val task = if(taskId != null) viewModel.getTask(taskId) else Task()

    var title by remember { mutableStateOf(task.title) }
    var description by remember { mutableStateOf(task.description ?: "") }

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = task.date?.second?.times(1000)?.toLong()
    )

    val timePickerState =
        if(task.date != null ) {
            rememberTimePickerState(
                initialHour = task.date.hour,
                initialMinute = task.date.minute,
                is24Hour = true
            )
        } else {
            val currentTime = Calendar.getInstance()
            rememberTimePickerState(
                initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
                initialMinute = currentTime.get(Calendar.MINUTE),
                is24Hour = true
            )
        }

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(16.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") }
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )
        CustomDatePicker(datePickerState)
        CustomTimePicker(timePickerState)
        Row {
            Button(
                onClick = onSave,
                modifier = Modifier
                    .padding(end = 12.dp)
                    .fillMaxWidth(fraction = 0.5f)
            ) {
                Text("Save")
            }
            Button(
                onClick = onCancel,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Cancel")
            }
        }
    }
}