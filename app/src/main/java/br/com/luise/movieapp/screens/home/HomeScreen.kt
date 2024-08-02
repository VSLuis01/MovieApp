package br.com.luise.movieapp.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import br.com.luise.movieapp.MovieRow
import br.com.luise.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Filmes") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray)
            )
        },
        content = { innerPadding ->
            MainContent(navController = navController, contentPadding = innerPadding)
        }
    )
}

@Composable
fun MainContent(
    navController: NavController,
    contentPadding: PaddingValues,
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "LASDAS",
        "ASDAS",
        "AAAA",
        "AAA"
    )
) {
    LazyColumn(
        modifier = Modifier.consumeWindowInsets(contentPadding),
        contentPadding = contentPadding
    ) {
        items(movieList) { movie ->
            MovieRow(movie = movie) { movieName ->
                navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movieName")

            }
        }
    }
}