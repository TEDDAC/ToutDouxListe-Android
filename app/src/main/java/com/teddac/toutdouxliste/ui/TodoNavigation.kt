package com.teddac.toutdouxliste.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.teddac.toutdouxliste.ui.config.TodoScreen
import com.teddac.toutdouxliste.ui.page.EditPage
import com.teddac.toutdouxliste.ui.page.ListPage

@Composable
fun TodoNavigation(
    modifier: Modifier = Modifier
){
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
        },
        modifier = modifier
    ){
        composable(
            route = TodoScreen.List.name
        ){
            ListPage(
                onSelectionChange = { index ->
                    navController.navigate(TodoScreen.Edit.name)
                },
                onClickAddItem = {navController.navigate(TodoScreen.Edit.name)}
            )
        }
        composable(
            route = TodoScreen.Edit.name
        ){
            EditPage(
                taskId = 0,
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}