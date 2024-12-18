package com.teddac.toutdouxliste.ui.page

import android.app.TimePickerDialog
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPage(){
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val datePickerState = rememberDatePickerState()
    val timePickerState = rememberDatePickerState()

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
        DueDatePicker(datePickerState)
        DueTimePicker(timePickerState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DueDatePicker(datePickerState: DatePickerState){
    var showDatePicker by remember { mutableStateOf(false) }
    val dueDateStr = LocalDateTime.ofInstant(
        Instant.ofEpochMilli(
            datePickerState.selectedDateMillis ?: Instant.now().toEpochMilli()
        ),
        ZoneId.systemDefault()
    ).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))

    OutlinedTextField(
        value = dueDateStr,
        onValueChange = { },
        label = { Text("Date") },
        placeholder = { Text("MM/DD/YYYY") },
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = "Select Date")
        },
        // Modifier.clickable doesn't work for text fields, so we use Modifier.pointerInput
        // in the Initial pass to observe events before the text field consumes them
        // in the Main pass.
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(datePickerState){
                awaitEachGesture {
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if (upEvent != null){
                        showDatePicker = true
                    }
                }
            }
    )

    if(showDatePicker){
        DatePickerDialog(
            onDismissRequest = {},
            confirmButton = {
                TextButton(onClick = {
                    showDatePicker = false
                }){
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDatePicker = false
                }) {
                    Text("Cancel")
                }
            }
        )  {
            DatePicker(state = datePickerState)
        }
    }
}