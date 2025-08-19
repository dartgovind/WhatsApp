package com.example.whatsapp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(){
    @Serializable
    data object SplashScreen:Routes()
    @Serializable
    data object LanguageScreen:Routes()
    @Serializable
    data object WelcomeScreen:Routes()
    @Serializable
    data object NumberScreen:Routes()
    @Serializable
    data object VerifyScreen:Routes()
    @Serializable
    data object ProfileScreen:Routes()
    @Serializable
    data object Initializing:Routes()
    @Serializable
    data object ChatScreen:Routes()
    @Serializable
    data object ChatInScreen:Routes()
    @Serializable
    data object VideoItem:Routes()
}