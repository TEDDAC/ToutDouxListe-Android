package com.teddac.toutdouxliste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.teddac.toutdouxliste.ui.TodoNavigation
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
                    TodoNavigation()
                }
            }
        }
    }
}