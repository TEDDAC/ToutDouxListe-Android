package com.teddac.toutdouxliste.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedTimePicker(
    timePickerState: TimePickerState
){

    var showTimePicker by remember { mutableStateOf(false) }
    val dueTimeStr = "${timePickerState.hour}:${timePickerState.minute}"

    var showDial by remember { mutableStateOf(true) }

    OutlinedTextField(
        value = dueTimeStr,
        onValueChange = { },
        label = { Text("Due Time") },
        placeholder = { Text("HH:MM") },
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = "Select Time")
        },
        // Modifier.clickable doesn't work for text fields, so we use Modifier.pointerInput
        // in the Initial pass to observe events before the text field consumes them
        // in the Main pass.
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(timePickerState){
                awaitEachGesture {
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if (upEvent != null){
                        showTimePicker = true
                    }
                }
            }
    )

    if(showTimePicker){
        val toggleIcon = if (showDial){
            Icons.Filled.EditCalendar
        } else {
            Icons.Filled.AccessTime
        }

        AdvancedTimePickerDialog(
            onDismiss = { showTimePicker = false },
            onConfirm = { showTimePicker = false },
            toggle = {
                IconButton(onClick = { showDial = !showDial}) {
                    Icon(
                        imageVector = toggleIcon,
                        contentDescription = "Time picker type toggle",
                    )
                }
            }
        ) {
            if (showDial) {
                TimePicker(state = timePickerState)
            } else {
                TimeInput(state = timePickerState)
            }
        }
    }
}

/**
 * https://developer.android.com/develop/ui/compose/components/time-pickers-dialogs?hl=fr
 */
@Composable
fun AdvancedTimePickerDialog(
    title: String = "Select Time",
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    toggle: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
){
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Surface (
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = MaterialTheme.colorScheme.surface
                ),
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    text = title,
                    style = MaterialTheme.typography.labelMedium
                )
                content()
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                ) {
                    toggle()
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = onDismiss) { Text("Cancel") }
                    TextButton(onClick = onConfirm) { Text("OK") }
                }
            }
        }
    }
}