package com.teddac.toutdouxliste.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskCard(
    onClick: () -> Unit
){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
        val date = "7/08/2024 08:45"

        Column (
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TaskCardTitle("Title")
                Text(
                    date,
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                    style = TextStyle(fontSize = 12.sp),
                    color = Color(0xFF777777)
                    // Todo: Alignement
                )
                Spacer(Modifier.weight(1f))
                Checkbox(
                    checked = false,
                    onCheckedChange = {}
                )
            }
            TaskCardDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, ullamco laboris nisi ut aliquip")
        }
    }
}

@Composable
fun TaskCardTitle(text: String = ""){
    Text(
        text,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun TaskCardDescription(text: String = ""){
    Text(text)
}