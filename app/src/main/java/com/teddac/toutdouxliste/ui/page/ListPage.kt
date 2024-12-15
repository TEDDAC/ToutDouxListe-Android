package com.teddac.toutdouxliste.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teddac.toutdouxliste.ui.component.TaskCard
import com.teddac.toutdouxliste.ui.theme.ToutDouxListeTheme

@Composable
fun ListPage(modifier: Modifier = Modifier){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
    ) {
        TaskCard()
        TaskCard()
        TaskCard()
        TaskCard()
        TaskCard()
        TaskCard()
        TaskCard()
    }
}

@Preview(showBackground = true)
@Composable
fun listPagePreview() {
    ToutDouxListeTheme {
        ListPage()
    }
}