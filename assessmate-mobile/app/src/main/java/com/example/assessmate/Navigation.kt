package com.example.assessmate

// Navigation.kt
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "landing"
    ) {
        composable("landing") {
            LandingScreen(navController)
        }
        composable("signup") {
            SignUpScreen(navController)
        }
        composable("signin") {
            SignInScreen(navController)
        }
        composable("user_role_selection") {
            UserRoleSelectionScreen(navController)
        }
        composable("congratulations") {
            CongratulationsScreen(navController)
        }
        // composable("test") {
        //     TestScreen(navController)
        // }
        composable("elearning_homepage") {
            ELearningHomepage(navController)
        }
        // composable("simple_homepage") {
        //     SimpleHomepage(navController)
        // }
        composable("courses") {
            MyCoursesScreen(navController)
        }
        composable("inbox") {
            InboxScreen(navController)
        }
        composable("transaction") {
            TransactionScreen(navController)
        }
        composable("profile") {
            ProfileScreen(navController)
        }
    }
}