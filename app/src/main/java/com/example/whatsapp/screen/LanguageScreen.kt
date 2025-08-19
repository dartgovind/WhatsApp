package com.example.whatsapp.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsapp.R
import com.example.whatsapp.navigation.Routes

@SuppressLint("MutableCollectionMutableState")
//@Preview(showBackground = true)
@Composable
fun LanguageScreen(navHostController: NavHostController){
    val language = mapOf(
        "(device's language)" to "English",
        "हिन्दी" to "Hindi",
        "मराठी" to "Marathi",
        "ગુજરાતી" to "Gujarati",
        "தமிழ்" to "Tamil",
        "বাংলা" to "Bangla",

    )
    var selectedLanguage by remember { mutableStateOf("English") }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navHostController.navigate(Routes.WelcomeScreen)},
                containerColor = Color(0xFF00C853),
                contentColor = Color(0xFF0A1218),
                modifier = Modifier.size(61.dp)
            ) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(30.dp))
            }
        }
        , bottomBar = { Down2() }
    ){
        Surface(modifier = Modifier.fillMaxSize(),
            color = Color(0xFF121B22))
        {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(it)
            ){
                //SAME WHATSAPP LOGO(NO AI ONLY ME SKILL)
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .height(350.dp).padding(horizontal = 32.dp)
                ){
                    Image(painter = painterResource(id= R.drawable.home_logo),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().height(400.dp))
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
                        Spacer(Modifier.height(225.7.dp))
                        Text("Welcome to WhatsApp", fontSize = 31.5.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                        Spacer(Modifier.height(7.dp))
                        Text("Chosse your language to get started", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }


                }

                Column(modifier = Modifier.fillMaxWidth()){
                    for ((key, value) in language) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) { RadioButton(
                            selected = selectedLanguage == value,
                            onClick = { selectedLanguage = value },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF00C853),
                                unselectedColor = Color.Gray
                            )
                        )
                            Spacer(Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = value,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Spacer(Modifier.height(3.dp))
                                Text(
                                    text = key,
                                    fontSize = 15.sp,
                                    color = Color(0xFFE5EAF1)
                                )
                            }
                        }
                        Spacer(Modifier.height(5.dp))
                    }


                }

            }
        }
    }
}
@Composable
fun Down2(){
    Box(modifier = Modifier.fillMaxWidth().height(80.dp))
}

