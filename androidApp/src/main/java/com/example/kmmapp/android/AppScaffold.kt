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
import com.example.kmmapp.articles.ArticlesViewModel

@Composable
fun AppScaffold(articlesViewModel: ArticlesViewModel) {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            articlesViewModel
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    articlesViewModel: ArticlesViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                articlesViewModel = articlesViewModel,
                onAboutButtonClick = { navController.navigate(Screens.ABOUT_DEVICE.route) })
        }

        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen { navController.navigate(Screens.ARTICLES.route) }
        }
    }
}
