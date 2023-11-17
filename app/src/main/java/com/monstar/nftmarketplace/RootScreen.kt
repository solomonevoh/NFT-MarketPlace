package com.monstar.nftmarketplace

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.monstar.nftmarketplace.home.HomeScreen
import com.monstar.nftmarketplace.onboarding.OnboardingScreen
import com.monstar.nftmarketplace.stats.StatsScreen
import com.monstar.nftmarketplace.ui.theme.NFTMarketplaceTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootScreen() {
    val navigationController = rememberNavController()


    Scaffold(bottomBar = {
        BottomBar()
    }) {
        NavHost(navController = navigationController, startDestination = NavigationItem.Login.route) {
            composable(NavigationItem.Login.route){
                OnboardingScreen()
            }
            composable(NavigationItem.Home.route){
                HomeScreen()
            }
            composable(NavigationItem.Stats.route){
                StatsScreen()
            }
            composable(NavigationItem.Add.route){
                Text("Add")
            }
            composable(NavigationItem.Search.route){
                Text("Search")
            }
            composable (NavigationItem.Profile.route){
                Text("Profile")
            }
        }
    }
}

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Login : NavigationItem("login", Icons.Filled.Home, "Home")
    object Home : NavigationItem("home", Icons.Filled.Home, "Home")
    object Stats : NavigationItem("stats", Icons.Filled.Analytics, "Home")
    object Add : NavigationItem("add", Icons.Filled.Add, "Add")
    object Search : NavigationItem("search", Icons.Filled.Search, "Search")
    object Profile : NavigationItem("profile", Icons.Filled.Person, "Profile")
}

@Composable
fun BottomBar() {
//    var selectedItem by remember {
//        mutableStateOf(0)
//    }
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Stats,
        NavigationItem.Search,
        NavigationItem.Add,
        NavigationItem.Profile
    )
    NavigationBar(
        containerColor = Color(33, 17, 25)
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = {/*TODO*/ },
                alwaysShowLabel = false,
                icon = {
                    Image(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(30.dp), colorFilter = ColorFilter.tint(Color.White)
                    )
                },
                label = { Text(item.title) },

                )
        }
    }
}


@Preview
@Composable
fun PreviewHomeRootScreen() {
    NFTMarketplaceTheme {
        RootScreen()
    }
}