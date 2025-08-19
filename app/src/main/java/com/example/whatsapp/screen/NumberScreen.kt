package com.example.whatsapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsapp.navigation.Routes
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun NumberScreen(navHostController: NavHostController){
    var number by remember { mutableStateOf("") }
    var conform by  remember { mutableStateOf(false) }
    var cuntinue by remember { mutableStateOf(false) }
    var click  = remember { mutableStateOf(false) }
    LaunchedEffect(click.value){
         if(click.value){
             cuntinue=true
             delay(2000)
             cuntinue=false
             conform=true
             click.value=false
         }

    }
    Scaffold(topBar = { Top() },bottomBar = { Down3(click) }){
        Surface(modifier = Modifier.fillMaxSize(),
            color = Color(0xFF0A1218)
        ) {
            Column(modifier = Modifier.fillMaxSize().padding(it),
                horizontalAlignment = Alignment.CenterHorizontally){
                Spacer(Modifier.height(7.dp))
                Text("Enter your phone number", fontSize = 30.sp, color = Color.White, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.height(20.dp))
                Text("WhatApp will need to verify your phone number.", fontSize = 16.sp, color = Color(0xFFE5EAF1))
                Spacer(Modifier.height(7.dp))
                Row { Text("Carries change may apply. ",fontSize = 15.sp, color = Color(0xFFE5EAF1))
                    Text("What's my number?", fontSize = 16.sp, color=Color(0xFF00BBD4), fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(35.dp))
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp)) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "India",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color(0xFF00C853)
                        )
                    }

                    Divider(
                        color = Color(0xFF00C853),
                        thickness = 1.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 0.dp)
                    )
                }
                Spacer(Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp).padding(start = 37.dp),
                    verticalAlignment = Alignment.Bottom // Important for baseline alignment
                ) {
                    // +91 text and underline
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "+ 91",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .width(50.dp)
                                .height(1.dp)
                                .background(Color(0xFF00C853))
                        )
                    }



                    // Phone number field
                    TextField(
                        value = number,
                        onValueChange = {  number=it},
                        placeholder = {
                            Text("Phone number", color = Color.Gray, fontSize = 18.sp)
                        },
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 18.sp,
                            color = Color.White
                        ),
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(

                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color(0xFF00C853),
                            unfocusedIndicatorColor = Color(0xFF00C853),
                            cursorColor = Color(0xFF00C853)
                        ),
                        modifier = Modifier.padding(horizontal = 40.dp)
                    )
                }

                Spacer(Modifier.height(70.dp))
                if(conform){
                Box(modifier = Modifier.fillMaxWidth().height(160.dp).padding(horizontal = 40.dp).background(color = Color(0xFF2C2F33), shape = RoundedCornerShape(20.dp))){
                     Column(modifier = Modifier.fillMaxSize().padding(start = 20.dp, top = 25.dp)){
                         Text("Is this the Correct number?", fontSize = 17.sp, color = Color(0xFFE5EAF1))
                         Spacer(Modifier.height(23.dp))
                         Text("+91 $number", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
                         Spacer(Modifier.height(22.5.dp))
                         Row(Modifier.fillMaxSize().padding(start = 160.dp)){
                             Text("Edit", fontSize = 17.sp, color = Color(0xFF00C853), fontWeight = FontWeight.Bold, modifier = Modifier.clickable { conform=false })
                             Spacer(Modifier.width(40.dp))
                             Text("Yes", fontSize = 17.sp, color = Color(0xFF00C853), fontWeight = FontWeight.Bold, modifier = Modifier.clickable { navHostController.navigate(Routes.VerifyScreen) })
                         }
                     }
                }
                }
                else if(cuntinue){
                    Box(modifier = Modifier.height(80.dp).padding(horizontal = 50.dp).background(color = Color(0xFF2C2F33), shape = RoundedCornerShape(3.dp))){
                        Row(Modifier.fillMaxSize().padding(start = 26.dp), verticalAlignment = Alignment.CenterVertically){
                            CircularProgressIndicator(
                                color = Color(0xFF00C853),
                                strokeWidth = 3.9.dp,
                                modifier = Modifier.size(39.dp)
                            )
                            Spacer(Modifier.width(18.dp))
                            Text("Connecting...", fontSize = 17.sp, color = Color(0xFFE5EAF1))
                        }
                    }
                }




            }
        }
    }
}
@Composable
fun Top(){
    Box(modifier = Modifier.fillMaxWidth().height(70.dp).background(color = Color(0xFF0A1218))){
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 310.dp, top = 30.dp)){
            Icon(imageVector = Icons.Default.VolumeUp,contentDescription = null, modifier = Modifier.size(25.dp), tint = Color.White)
            Spacer(Modifier.width(20.dp))
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, modifier = Modifier.size(25.dp),tint = Color.White)
        }
    }
}
@Composable
fun Down3(click:MutableState<Boolean>){
    Box(modifier = Modifier.fillMaxWidth().height(90.dp).background(color = Color(0xFF0A1218))){
        Box(Modifier.fillMaxWidth().height(45.dp).padding(horizontal = 20.dp).clickable { click.value=true }
            .background(color = Color(0xFF00C853), shape = RoundedCornerShape(20.dp))){
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                Text("Next", fontSize = 20.sp,fontWeight = FontWeight.Bold, color = Color(0xFF121B22))
            }
        }
    }
}