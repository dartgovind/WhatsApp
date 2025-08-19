package com.example.whatsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp.screen.ChatInScreen
import com.example.whatsapp.screen.ChatScreen
import com.example.whatsapp.screen.Initializing
import com.example.whatsapp.screen.LanguageScreen
import com.example.whatsapp.screen.NumberScreen
import com.example.whatsapp.screen.ProfileScreen
import com.example.whatsapp.screen.SplashScreen
import com.example.whatsapp.screen.VerifyScreen
import com.example.whatsapp.screen.VideoItem
import com.example.whatsapp.screen.WelcomeScreen

@Composable
fun Navigation(){
    val navController= rememberNavController()

    NavHost(navController=navController, startDestination = Routes.ChatScreen){
          composable<Routes.SplashScreen> {
              SplashScreen(navController)
          }
          composable<Routes.LanguageScreen> {
              LanguageScreen(navController)
          }
        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }
        composable<Routes.NumberScreen> {
            NumberScreen(navController)
        }
        composable<Routes.VerifyScreen> {
            VerifyScreen(navController)
        }
        composable<Routes.ProfileScreen> {
          ProfileScreen(navController)
        }
        composable<Routes.Initializing> {
               Initializing(navController)
        }
        composable<Routes.ChatScreen> {
            ChatScreen(navController)
        }
        composable<Routes.ChatInScreen> {
            ChatInScreen(navController)

        }
        composable<Routes.VideoItem> {
            VideoItem(navController)
        }
    }
}