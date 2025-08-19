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
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CurrencyRupee
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.whatsapp.R
import com.example.whatsapp.navigation.Routes
@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun ChatInScreen(navHostController: NavHostController) {
    var input by remember { mutableStateOf("") }
    Scaffold(topBar = { Top6(navHostController) },


    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF0A1218)
        ) {
            Box(modifier = Modifier.fillMaxSize().padding(it)) {
                // Background image
                Image(
                    painter = painterResource(id = R.drawable.backgound),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    colorFilter = ColorFilter.tint(Color(0xFFABABAB))
                )
                Column(modifier = Modifier.fillMaxSize()){
                    Spacer(Modifier.height(50.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 35.dp, vertical = 5.dp)
                            .background(
                                color = Color(0xFF2C2F33),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(12.dp) // inner padding
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Lock,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(16.dp)
                                        .padding(end = 4.dp),
                                    tint = Color(0xFFFAAE3C)
                                )
                                Text(
                                    text = "Messages and calls are end-to-end encrypted.",
                                    fontSize = 12.sp,
                                    color = Color(0xFFFAAE3C)
                                )
                            }
                            Spacer(modifier = Modifier.height(1.dp))
                            Text(
                                text = "Only people in this chat can read, listen to, or share",
                                fontSize = 12.sp,
                                color = Color(0xFFFAAE3C)
                            )
                            Text(
                                text = "them. Learn more.",
                                fontSize = 12.sp,
                                color = Color(0xFFFAAE3C)
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 530.dp), horizontalAlignment = Alignment.Start
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 6.dp), verticalAlignment = Alignment.CenterVertically
                        ) {
                            OutlinedTextField(
                                value = input,
                                onValueChange = {input=it},
                                placeholder = {
                                    Row(verticalAlignment = Alignment.CenterVertically){
                                        Image(painter = painterResource(id = R.drawable.emojiiiii), contentDescription = null, modifier = Modifier.size(45.dp).padding(bottom = 2.dp),colorFilter = ColorFilter.tint(
                                            Color.White))

                                        Text(
                                            "Message",
                                            color = Color(0xFFABABAB),
                                            fontSize = 18.sp
                                        )

                                        Spacer(Modifier.width(55.dp))
                                        Icon(imageVector = Icons.Default.AttachFile, contentDescription = null, modifier = Modifier.size(25.dp), tint = Color(0xFFABABAB))
                                        Spacer(Modifier.width(15.dp))
                                        Icon(imageVector = Icons.Default.CurrencyRupee, contentDescription = null, modifier = Modifier.size(25.dp), tint = Color(0xFFABABAB))
                                        Spacer(Modifier.width(15.dp))
                                        Icon(imageVector = Icons.Default.CameraAlt, contentDescription = null, modifier = Modifier.size(25.dp), tint = Color(0xFFABABAB))


                                    }

                                },
                                shape = RoundedCornerShape(25.dp),
                                textStyle = LocalTextStyle.current.copy(
                                    fontSize = 18.sp,
                                    color = Color.White
                                ),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    containerColor = Color(0xFF2C2F33),
                                    focusedBorderColor = Color(0xFF2C2F33),
                                    unfocusedBorderColor = Color(0xFF2C2F33),
                                    cursorColor = Color(0xFF00C853),
                                ),
                                modifier = Modifier
                                    .height(60.dp).width(314.dp)
                            )
                            Spacer(Modifier.width(7.dp))
                            Box(modifier = Modifier.size(58.dp).background(color = Color(0xFF00C853), shape = CircleShape)){
                                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                    if(input.isEmpty()) Icon(imageVector = Icons.Default.Mic, contentDescription = null, modifier = Modifier.size(30.dp), tint = Color(0xFF0A1218))
                                    else Icon(imageVector = Icons.Default.Send, contentDescription = null, modifier = Modifier.size(27.dp), tint = Color(0xFF0A1218))
                                }
                            }
                        }


                    }
                }

                // Foreground content

            }
        }
    }
}

@Composable
fun Top6(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(Modifier.height(60.dp))
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp).clickable { navHostController.navigate(Routes.ChatScreen) }
                        .graphicsLayer(scaleX = 1.5f, scaleY = 1.5f),
                    tint = Color.White
                )

                Spacer(Modifier.width(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.avtar_logo),
                    contentDescription = null,
                    modifier = Modifier.requiredSize(67.dp)
                )

                Spacer(Modifier.width(4.dp))

                Text(
                    "Name",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(Modifier.weight(1f)) // pushes icons to the end

                Icon(
                    imageVector = Icons.Default.Videocam,
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .graphicsLayer(scaleX = 1.5f, scaleY = 1.5f),
                    tint = Color.White
                )

                Spacer(Modifier.width(20.dp))

                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .graphicsLayer(scaleX = 1.5f, scaleY = 1.5f),
                    tint = Color.White
                )

                Spacer(Modifier.width(16.dp))

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .graphicsLayer(scaleX = 1.5f, scaleY = 1.5f),
                    tint = Color.White
                )
            }
        }
    }
}


