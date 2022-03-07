package com.ottogo.weekly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ottogo.weekly.ui.login.*
import com.ottogo.weekly.ui.theme.WeeklyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeeklyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginNavigation()
                }
            }
        }
    }
}

@Composable
fun LoginNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "landingPage") {

        composable("landingPage") { LandingPage(navController) }
        composable( "loginPage") { LoginPage(navController) }
        composable("signupPage") { SignupPage(navController) }
        composable("signupInterestsPage/{token}") { backStackEntry -> SignupInterestsPage(navController,
            backStackEntry.arguments?.getString("token")!!
        ) }
        composable("signupProfilePage/{token}") { backStackEntry -> SignupProfilePage(navController,
            backStackEntry.arguments?.getString("token")!!
        ) }
        composable("signupBirthdayPage") { SignupBirthdayPage(navController) }
        composable("signupVerifyPage/{token}") { backStackEntry -> SignupVerifyPage(navController,
            backStackEntry.arguments?.getString("token")!!
        ) }
        /*...*/
    }
}

