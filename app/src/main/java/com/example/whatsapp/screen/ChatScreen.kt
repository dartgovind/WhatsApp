package com.example.whatsapp.screen

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Update
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp.R
import com.example.whatsapp.navigation.Routes

@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun ChatScreen(navHostController: NavHostController){
    var search by remember { mutableStateOf("") }
    var name by remember {
        mutableStateOf(
            mutableMapOf(
                "Ramji" to "Always smiling!",
                "Ankit" to "The coder!",
                "Bikram" to "Loves adventures.",
                "Doremon" to "Brings gadgets.",
                "Shinchan" to "Funny and naughty.",
                "Mummy" to "Caring and lovely."
            )
        )
    }

    Scaffold(topBar = { Top5() }, bottomBar = { Down5(navHostController) }, floatingActionButton = {
        FloatingActionButton(
            onClick = {},
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.size(60.dp),
            containerColor = Color(0xFF00C853)
        ) {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Icon(imageVector = Icons.Default.AddComment, contentDescription = null, modifier = Modifier.size(25.dp), tint = Color(0xFF0A1218))
            }
        }
    }){
        Surface(modifier = Modifier.fillMaxSize(),
            color = Color(0xFF0A1218)) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(it), horizontalAlignment = Alignment.CenterHorizontally){
                Spacer(Modifier.height(10.dp))
                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    placeholder = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                modifier = Modifier.size(25.dp),
                                tint = Color(0xFFABABAB)
                            )
                            Spacer(Modifier.width(8.dp))
                            Text("Ask Meta AI or Search", color = Color(0xFFABABAB), fontSize = 18.sp)
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
                        cursorColor = Color.White,

                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp)
                        .height(60.dp)
                )
                Spacer(Modifier.height(30.dp))
                var cnt=0
                for ((name,msg) in name) {
                    Box(modifier = Modifier
                        .fillMaxWidth().clickable { navHostController.navigate(Routes.ChatInScreen) }
                        .height(60.dp)
                        .padding(horizontal = 20.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (cnt==0) {
                                Image(
                                    painter = painterResource(id = R.drawable.ramji),
                                    contentDescription = null,
                                    modifier = Modifier.requiredSize(62.dp).padding(start = 9.dp)
                                )
                            }
                            else if(cnt==1){
                                Image(
                                    painter = painterResource(id = R.drawable.ankit),
                                    contentDescription = null,
                                    modifier = Modifier.requiredSize(62.dp).padding(start = 9.dp)
                                )
                            }
                            else if(cnt==3){
                                Image(
                                    painter = painterResource(id = R.drawable.doremon),
                                    contentDescription = null,
                                    modifier = Modifier.requiredSize(67.dp)
                                )
                            }else if(cnt==4){
                                Image(
                                    painter = painterResource(id = R.drawable.chine),
                                    contentDescription = null,
                                    modifier = Modifier.requiredSize(67.dp)
                                )
                            }else if (cnt==5){
                                Image(
                                    painter = painterResource(id = R.drawable.mummy),
                                    contentDescription = null,
                                    modifier = Modifier.requiredSize(62.dp).padding(start = 9.dp)
                                )
                            }
                            else{
                                Image(
                                    painter = painterResource(id = R.drawable.avtar_logo),
                                    contentDescription = null,
                                    modifier = Modifier.requiredSize(67.dp)
                                )
                            }
                            if (cnt == 0||cnt==5 || cnt==1) {
                                Spacer(Modifier.width(15.dp))
                            }
                            else{
                                Spacer(Modifier.width(10.dp))
                            }
                            Column {
                                Text(name, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Spacer(Modifier.height(6.dp))
                                Text(msg, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFFABABAB))
                            }



                            Spacer(Modifier.weight(1f)) // Pushes time to the end

                            Text("10:00 AM", fontSize = 14.sp, color = Color(0xFFABABAB))
                        }
                    }
                    Spacer(Modifier.height(20.dp))
                    cnt++
                }




            }

        }
    }
}

@Composable
fun Top5(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .background(color = Color(0xFF0A1218))) {
        Column(modifier = Modifier.fillMaxSize()){
             Spacer(Modifier.height(40.dp))

            Row(modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp), verticalAlignment = Alignment.CenterVertically){
                Text("WhatApp", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(Modifier.width(125.dp))
                Icon(imageVector = Icons.Default.QrCodeScanner, contentDescription = null, modifier = Modifier.size(25.dp), tint = Color.White)
                Spacer(Modifier.width(20.dp))
                Icon(imageVector = Icons.Default.CameraAlt, contentDescription = null, modifier = Modifier.size(25.dp), tint = Color.White)
                Spacer(Modifier.width(16.dp))
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, modifier = Modifier.size(25.dp), tint = Color.White)

            }
        }

    }

}
@Composable
fun Down5(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(start = 15.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Message,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.Green
                )
                Spacer(Modifier.width(55.dp))
                Icon(
                    imageVector = Icons.Default.Update,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
                Spacer(Modifier.width(78.dp))
                Icon(
                    imageVector = Icons.Default.VideoLibrary,
                    contentDescription = null,
                    modifier = Modifier.size(35.dp).clickable { navHostController.navigate(Routes.VideoItem) },
                    tint = Color.White
                )
                Spacer(Modifier.width(70.dp))
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(start = 10.dp)
            ) {
                Text("Chats", fontSize = 14.sp, color = Color.White)
                Spacer(Modifier.width(50.dp))
                Text("Update", fontSize = 14.sp, color = Color.White)
                Spacer(Modifier.width(68.dp))
                Text("Reel", fontSize = 14.sp, color = Color.White)
                Spacer(Modifier.width(70.dp))
                Text("Call", fontSize = 14.sp, color = Color.White)
            }
        }
    }
}
@Preview(showBackground = true, backgroundColor = 0xFF0A1218)
@Composable
fun ChatScreenPreview() {
    val navController = rememberNavController()
    ChatScreen(navHostController = navController)
}