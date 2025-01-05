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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teddac.toutdouxliste.data.Stub
import com.teddac.toutdouxliste.model.Task
import com.teddac.toutdouxliste.ui.component.TaskCard
import com.teddac.toutdouxliste.ui.theme.ToutDouxListeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPage(
    onSelectionChange: () -> Unit,
    onClickAddItem: () -> Unit
){
    val tasks = Stub().tasks

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
                onSelectionChange = onSelectionChange
            )
            FloatingActionButton(
                onClick = onClickAddItem,
                modifier = Modifier
                    .align(Alignment.BottomEnd).padding(16.dp)
            ) {
                Icon(Icons.Filled.Add, "Add task button.")
            }
        }
    }
}

@Composable
fun TaskList(
    tasks: List<Task>,
    onSelectionChange: () -> Unit,
){
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(16.dp), // padding around list, not between each element
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
    ) {
        tasks.forEach { task ->
            item {
                TaskCard(
                    task = task,
                    onClick = onSelectionChange
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPagePreview() {
    ToutDouxListeTheme {
        ListPage(
            onSelectionChange = {},
            onClickAddItem = {}
        )
    }
}