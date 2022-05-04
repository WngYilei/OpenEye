package com.xl.openeye.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.xl.openeye.ui.home.HomeViewModel
import com.xl.openeye.ui.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : ComponentActivity() {

    val modle by viewModels<HomeViewModel>()

    @RequiresApi(Build.VERSION_CODES.M)
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(modle)
        }
    }
}

val title = mutableStateOf("")


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@Composable
fun MainScreen(viewModel: HomeViewModel) {
    val navController = rememberNavController()
    Scaffold(topBar = { TitleBar() }, bottomBar = { BottomNavigationBar(navController) }) {
        Navigation(navController = navController,  viewModel )
    }
}


@Composable
fun Navigation(navController: NavHostController,viewModel: HomeViewModel) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            title.value = "主页"
            HomeScreen(viewModel = viewModel)
        }
        composable(NavigationItem.Discovery.route) {
            title.value = "发现"
            FindScreen()
        }
        composable(NavigationItem.Hot.route) {
            title.value = "热门"
            HotScreen()
        }
        composable(NavigationItem.Mine.route) {
            title.value = "我的"
            ProfileScreen()
        }
    }
}


@Composable
fun TitleBar() {
    TopAppBar(
        title = {
            Text(
                text = title.value, fontSize = 18.sp,

                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(
                        Alignment.Center
                    )
            )
        },
        backgroundColor = Color.White,
        contentColor = Color.Black
    )
}

@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Discovery,
        NavigationItem.Hot,
        NavigationItem.Mine
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(painterResource(id = item.icon), contentDescription = item.title)
                },
                label = { Text(text = item.title) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }

    }
}