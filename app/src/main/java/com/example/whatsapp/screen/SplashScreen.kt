package com.example.whatsapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsapp.R
import com.example.whatsapp.navigation.Routes
import kotlinx.coroutines.delay

//@Preview(showBackground = true)
@Composable
fun SplashScreen(navHostController: NavHostController){
    LaunchedEffect(Unit){
        delay(1000)
        navHostController.navigate(Routes.LanguageScreen) {
            popUpTo(Routes.SplashScreen) {
                inclusive = true
            }
        }
    }
    Scaffold(
            bottomBar = {
                  Down()
            }
    ){
        Surface(modifier = Modifier.fillMaxSize(),
            color = Color(0xFF0A1218)) {
            Column(modifier = Modifier.fillMaxSize().padding(it), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                Image(painter = painterResource(id = R.drawable.whatsapp_logo),
                    contentDescription = null,
                    modifier = Modifier.size(150.dp))

            }
        }
    }
}

@Composable
fun Down(){
    Box(
        modifier = Modifier.fillMaxWidth()
            .height(150.dp)

    ){
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
            Text("  from", fontSize = 20.sp, color = Color(0xFFE5EAF1))
            Spacer(Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id= R.drawable.meta_logo),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp))
                Spacer(Modifier.width(3.dp))
                Text("Meta", fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.ExtraBold)

            }
        }

    }
}
