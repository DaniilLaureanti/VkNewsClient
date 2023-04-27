package com.example.vknewsclient.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vknewsclient.MainViewModel
import com.example.vknewsclient.navigation.AppNavGraph
import com.example.vknewsclient.navigation.NavigationState
import com.example.vknewsclient.navigation.Screen
import com.example.vknewsclient.navigation.rememberNavigationState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val navigationState = rememberNavigationState()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                items.forEach() {
                    BottomNavigationItem(
                        selected = currentRoute == it.screen.route,
                        onClick = {
                            navigationState.navigateTo(it.screen.route)
                        },
                        icon = {
                            Icon(it.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = it.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    ) { paddingValues ->

        AppNavGraph(
            navHostController = navigationState.navHostController,
            homeScreenContent = {
                HomeScreen(
                    viewModel = viewModel,
                    paddingValues = paddingValues
                )
            },
            favouriteScreenContent = {
                Text("Favourite", color = MaterialTheme.colors.onPrimary)
            },
            profileScreenContent = {
                Text("Profile", color = MaterialTheme.colors.onPrimary)
            }
        )
    }
}