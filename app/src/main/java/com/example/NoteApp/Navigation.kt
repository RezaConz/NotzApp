package com.example.NoteApp

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.NoteApp.screens.add.DetailScreen
import com.example.NoteApp.screens.add.AddNoteViewModel
import com.example.NoteApp.screens.home.Home
import com.example.NoteApp.screens.home.HomeViewModel
import com.example.NoteApp.screens.Login.LoginScreen
import com.example.NoteApp.screens.Login.LoginViewModel
import com.example.NoteApp.screens.Register.RegisterScreen
import com.example.NoteApp.screens.Register.RegisterViewModel

enum class LoginRoutes {
    Signup,
    SignIn
}

enum class HomeRoutes {
    Home,
    Detail
}

enum class NestedRoutes {
    Main,
    Login
}


@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel,
    registerViewModel: RegisterViewModel,
    addNoteViewModel: AddNoteViewModel,
    homeViewModel: HomeViewModel
) {
    NavHost(
        navController = navController,
        startDestination = NestedRoutes.Main.name
    ) {
        authGraph(navController, loginViewModel, registerViewModel)
        homeGraph(
            navController = navController,
            addNoteViewModel,
            homeViewModel
        )
    }


}

fun NavGraphBuilder.authGraph(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    registerViewModel: RegisterViewModel
) {
    navigation(
        startDestination = LoginRoutes.SignIn.name,
        route = NestedRoutes.Login.name
    ) {
        composable(route = LoginRoutes.SignIn.name) {
            LoginScreen(onNavToHomePage = {
                navController.navigate(NestedRoutes.Main.name) {
                    launchSingleTop = true
                    popUpTo(route = LoginRoutes.SignIn.name) {
                        inclusive = true
                    }
                }
            },
                loginViewModel = loginViewModel,

            ) {
                navController.navigate(LoginRoutes.Signup.name) {
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name) {
                        inclusive = true
                    }
                }
            }
        }

        composable(route = LoginRoutes.Signup.name) {
            RegisterScreen(onNavToHomePage = {
                navController.navigate(NestedRoutes.Main.name) {
                    popUpTo(LoginRoutes.Signup.name) {
                        inclusive = true
                    }
                }
            },
                registerViewModel = registerViewModel
            ) {
                navController.navigate(LoginRoutes.SignIn.name)
            }
        }

    }

}

fun NavGraphBuilder.homeGraph(
    navController: NavHostController,
    addNoteViewModel: AddNoteViewModel,
    homeViewModel: HomeViewModel
){
    navigation(
        startDestination = HomeRoutes.Home.name,
        route = NestedRoutes.Main.name,
    ){
        composable(HomeRoutes.Home.name){
            Home(
                homeViewModel = homeViewModel,
                onNoteClick = { noteId ->
                      navController.navigate(
                          HomeRoutes.Detail.name + "?id=$noteId"
                      ){
                          launchSingleTop = true
                      }
                },
                navToDetailPage = {
                    navController.navigate(HomeRoutes.Detail.name)
                }
            ) {
                navController.navigate(NestedRoutes.Login.name){
                    launchSingleTop = true
                    popUpTo(0){
                        inclusive = true
                    }
                }

            }
        }

        composable(
            route = HomeRoutes.Detail.name + "?id={id}",
            arguments = listOf(navArgument("id"){
                type = NavType.StringType
                defaultValue = ""
            })
        ){ entry ->

            DetailScreen(
                addNoteViewModel = addNoteViewModel,
                noteId = entry.arguments?.getString("id") as String,
            ) {
                navController.navigateUp()

            }


        }



    }




}






















