package com.teddac.toutdouxliste.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskCard(){
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column {
            TaskCardTitle("Title")
            TaskCardDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, ullamco laboris nisi ut aliquip")
        }
    }
}

@Composable
fun TaskCardTitle(text: String = ""){
    Text(
        text,
        modifier = Modifier
            .size(24.dp)
    )
}

@Composable
fun TaskCardDescription(text: String = ""){
    Text(text)
}