package com.teddac.toutdouxliste.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teddac.toutdouxliste.ui.component.TaskCard
import com.teddac.toutdouxliste.ui.theme.ToutDouxListeTheme

@Composable
fun ListPage(modifier: Modifier = Modifier){
    Box {
        TaskList()
        FloatingActionButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomEnd).padding(16.dp)
        ) {
            Icon(Icons.Filled.Add, "Add task button.")
        }
    }
}

@Composable
fun TaskList(modifier: Modifier = Modifier){
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(16.dp), // padding around list, not between each element
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
    ) {
        item {
            TaskCard()
        }
        item {
            TaskCard()
        }
        item {
            TaskCard()
        }
        item {
            TaskCard()
        }
        item {
            TaskCard()
        }
        item {
            TaskCard()
        }
        item {
            TaskCard()
        }
        item {
            TaskCard()
        }
        item {
            TaskCard()
        }
        item {
            TaskCard()
        }
        item {
            TaskCard()
        }
        item {
            TaskCard()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun listPagePreview() {
    ToutDouxListeTheme {
        ListPage()
    }
}