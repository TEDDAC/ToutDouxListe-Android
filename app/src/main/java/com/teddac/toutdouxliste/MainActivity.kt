package com.teddac.toutdouxliste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.teddac.toutdouxliste.ui.config.TodoScreen
import com.teddac.toutdouxliste.ui.page.EditPage
import com.teddac.toutdouxliste.ui.page.ListPage
import com.teddac.toutdouxliste.ui.theme.ToutDouxListeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ToutDouxListeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        // Evite que les composant s'affiche derrière les barres d'état et de navigation.
                        // https://developer.android.com/develop/ui/compose/layouts/insets?hl=fr
                        .safeDrawingPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = TodoScreen.List.name
                    ){
                        composable(route = TodoScreen.List.name){
                            ListPage(
                                onSelectionChange = {navController.navigate(TodoScreen.Edit.name)}
                            )
                        }
                        composable(route = TodoScreen.Edit.name){
                            EditPage()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToutDouxListeTheme {
        ListPage({})
    }
}