package com.example.whatsapp.screen

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsapp.R
import com.example.whatsapp.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun ProfileScreen(navHostController: NavHostController) {
    var user by remember { mutableStateOf("") }
    var message by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { Top() },
        bottomBar = { Down3(navHostController) }
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {

            // ✅ Original content
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF0A1218)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(15.dp))
                    Text("Profile info", fontSize = 30.sp, color = Color.White)
                    Spacer(Modifier.height(22.dp))
                    Text(
                        "Please provide your name and an optional profile",
                        fontSize = 15.sp,
                        color = Color(0xFFABABAB)
                    )
                    Spacer(Modifier.height(7.dp))
                    Text("photo", fontSize = 15.sp, color = Color(0xFFABABAB))
                    Spacer(Modifier.height(7.dp))

                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier.size(202.dp)
                    )
                    Spacer(Modifier.height(10.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 20.dp)
                    ) {
                        TextField(
                            value = user,
                            onValueChange = { user = it },
                            placeholder = {
                                Text("User Name", color = Color.Gray, fontSize = 18.sp)
                            },
                            textStyle = LocalTextStyle.current.copy(
                                fontSize = 18.sp,
                                color = Color.White
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedIndicatorColor = Color(0xFF00C853),
                                unfocusedIndicatorColor = Color(0xFF00C853),
                                cursorColor = Color(0xFF00C853)
                            ),
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )

                        Spacer(Modifier.width(3.dp))

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Spacer(modifier = Modifier.height(30.dp))
                            Image(
                                painter = painterResource(id = R.drawable.emoji),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }
            }
            if(!message) {
                // ✅ Center box overlaid
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    // Main Popup Card
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .width(300.dp)
                            .background(Color(0xFF2C2F33), shape = RoundedCornerShape(10.dp))
                    ) {
                        // Top Green Section with Icons
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .background(
                                    Color(0xFF00C853),
                                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                                ),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Image,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(50.dp)
                            )
                            Spacer(Modifier.width(20.dp))
                            Text("+", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.width(20.dp))
                            Icon(
                                imageVector = Icons.Default.Folder,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(50.dp)
                            )
                        }

                        // Text Section
                        Column(modifier = Modifier.padding(20.dp)) {
                            Text(
                                text = "Contacts and media",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.White
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(
                                text = "To easily send messages and photos to friends and family, allow WhatsApp to access your contacts, photos and other media.",
                                fontSize = 14.sp,
                                color = Color(0xFFABABAB)
                            )
                        }

                        // Action Buttons Row
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Not now",
                                color = Color(0xFF00C853),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                modifier = Modifier.clickable { navHostController.navigate(Routes.ChatScreen) }
                            )
                            Text(
                                text = "Continue",
                                color = Color(0xFF00C853),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                modifier = Modifier.clickable { message=true }
                            )
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun Down3(navHostController: NavHostController){
    Box(modifier = Modifier.fillMaxWidth().height(90.dp).background(color = Color(0xFF0A1218))){
        Box(Modifier.fillMaxWidth().height(45.dp).padding(horizontal = 20.dp).clickable { navHostController.navigate(
            Routes.Initializing)}
            .background(color = Color(0xFF00C853), shape = RoundedCornerShape(20.dp))){
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                Text("Next", fontSize = 20.sp,fontWeight = FontWeight.Bold, color = Color(0xFF121B22))
            }
        }
    }
}