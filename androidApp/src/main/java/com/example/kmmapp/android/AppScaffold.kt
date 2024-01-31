package com.example.kmmapp.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kmmapp.android.screens.AboutScreen
import com.example.kmmapp.android.screens.ArticlesScreen
import com.example.kmmapp.android.screens.Screens
import com.example.kmmapp.android.screens.SourcesScreen
import com.example.kmmapp.android.screens.examples.SignUpScreen

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screens.CHOOSE_SCREEN.route,
        modifier = modifier
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                onAboutButtonClick = { navController.navigate(Screens.ABOUT_DEVICE.route) },
                onSourceButtonClick = { navController.navigate(Screens.SOURCES.route) })
        }

        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen { navController.navigate(Screens.ARTICLES.route) }
        }

        composable(Screens.SOURCES.route) {
            SourcesScreen { navController.navigate(Screens.ARTICLES.route) }
        }

        composable(Screens.CHOOSE_SCREEN.route) {
            SignUpScreen()
        }
    }
}
