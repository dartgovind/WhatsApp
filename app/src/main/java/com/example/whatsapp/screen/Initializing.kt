package com.example.whatsapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsapp.R
import com.example.whatsapp.navigation.Routes
import kotlinx.coroutines.delay

//@Preview(showBackground = true)
@Composable
fun Initializing(navHostController: NavHostController) {
    LaunchedEffect(Unit){
        delay(1000)
        navHostController.navigate(Routes.ChatScreen) {
            popUpTo(Routes.Initializing) {
                inclusive = true
            }
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF0A1218)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(60.dp))
            Text("Initializing...", fontSize = 30.sp, color = Color.White)
            Spacer(Modifier.height(7.dp))
            Text("Please wait a moment", fontSize = 16.sp, color = Color(0xFFABABAB))

            Spacer(Modifier.height(120.dp)) // Add some spacing before image and loader

            // Center block
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.main_logo),
                    contentDescription = null,
                    modifier = Modifier.size(350.dp)
                )
                Spacer(Modifier.height(95.dp)) // Space between image and loader
                CircularProgressIndicator(
                    color = Color(0xFF00C853),
                    strokeWidth = 3.9.dp,
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}
