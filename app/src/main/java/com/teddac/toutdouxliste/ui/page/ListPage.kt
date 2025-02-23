package com.teddac.toutdouxliste.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.teddac.toutdouxliste.data.TaskViewModel
import com.teddac.toutdouxliste.model.Task
import com.teddac.toutdouxliste.ui.component.TaskCard
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPage(
    viewModel: TaskViewModel = TaskViewModel()
){
    val tasks = viewModel.getTasks()
    var selectedTaskId by remember { mutableStateOf<Int?>(null) }

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    val hideDrawer : () -> Unit = {
        scope.launch { sheetState.hide() }.invokeOnCompletion {
            if (!sheetState.isVisible) {
                showBottomSheet = false
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        "Tout Doux Liste",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxHeight()
        ) {
            TaskList(
                tasks = tasks,
                onSelectionChange = { id ->
                    selectedTaskId = id
                    showBottomSheet = true
                }
            )
            FloatingActionButton(
                onClick = {
                    showBottomSheet = true
                    selectedTaskId = null
                          },
                modifier = Modifier
                    .align(Alignment.BottomEnd).padding(16.dp)
            ) {
                Icon(Icons.Filled.Add, "Add task button.")
            }
        }

        if(showBottomSheet){
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 128.dp)
            ) {
                EditPage(
                    taskId = selectedTaskId,
                    onSave = hideDrawer,
                    onCancel = hideDrawer
                )
            }
        }
    }
}

@Composable
fun TaskList(
    tasks: List<Task>,
    onSelectionChange: (Int) -> Unit,
){
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(16.dp), // padding around list, not between each element
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
    ) {
        tasks.forEachIndexed { index, task ->
            // key is used by compose to identify unique composable.
            // https://developer.android.com/develop/ui/compose/lifecycle?hl=fr#add-info-smart-recomposition
            // https://stackoverflow.com/questions/68790215/lazycolumn-items-key-parameter-purpose
            item(key = index) { // TODO: use id as key
                TaskCard(
                    task = task,
                    onClick = { onSelectionChange(index) }
                )
            }
        }
    }
}