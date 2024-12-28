package com.teddac.toutdouxliste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
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
                        startDestination = TodoScreen.List.name,
                        enterTransition = {
                            fadeIn(
                                animationSpec = tween(
                                    250, easing = EaseOut
                                )
                            ) + slideIntoContainer(
                                animationSpec = tween(250, easing = EaseOut),
                                towards = AnimatedContentTransitionScope.SlideDirection.Start
                            )
                        },
                        exitTransition = {
                            fadeOut(
                                animationSpec = tween(
                                    200, easing = EaseIn
                                )
                            ) /*+ slideOutOfContainer(
                                animationSpec = tween(300, easing = EaseOut),
                                towards = AnimatedContentTransitionScope.SlideDirection.Start
                            )*/
                        }
                    ){
                        composable(
                            route = TodoScreen.List.name
                        ){
                            ListPage(
                                onSelectionChange = {navController.navigate(TodoScreen.Edit.name)},
                                onClickAddItem = {navController.navigate(TodoScreen.Edit.name)}
                            )
                        }
                        composable(
                            route = TodoScreen.Edit.name
                        ){
                            EditPage()
                        }
                    }
                }
            }
        }
    }
}