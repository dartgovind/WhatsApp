package com.example.whatsapp.screen

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PhoneIphone
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.CircularProgressIndicator
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
fun VerifyScreen(navHostController: NavHostController){
    var otp by remember { mutableStateOf("") }
    var open by remember { mutableStateOf(true) }
    LaunchedEffect(Unit){
        delay(2500)
        open=false

    }
    LaunchedEffect(otp){
        if (otp.length==6){
            delay(1000)
            navHostController.navigate(Routes.ProfileScreen)
        }


    }
    Scaffold(topBar = { Top2() }){
        Surface(modifier = Modifier.fillMaxSize(),
            color = Color(0xFF0A1218)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(10.dp))

                    Text(
                        "Verify +91 76990 04270",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFABABAB)
                    )

                    Spacer(Modifier.height(58.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.PhoneIphone,
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            tint = Color(0xFF00C853)
                        )
                        Icon(
                            imageVector = Icons.Default.MoreHoriz,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            tint = Color.White
                        )
                        Icon(
                            imageVector = Icons.Filled.PhoneIphone,
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            tint = Color(0x9EE3F399)
                        )
                    }

                    Spacer(Modifier.height(42.dp))

                    Text(
                        "Use your phone to confirm moving WhatsApp",
                        fontSize = 16.sp,
                        color = Color(0xFFABABAB),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(7.dp))

                    Text(
                        "to this one",
                        fontSize = 16.sp,
                        color = Color(0xFFABABAB),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(20.dp))

                    Text(
                        "Open WhatsApp on your Phone to get ",
                        fontSize = 16.sp,
                        color = Color(0xFFABABAB),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(7.dp))

                    Text(
                        "the 6_digit code.",
                        fontSize = 16.sp,
                        color = Color(0xFFABABAB),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(30.dp))

                    TextField(
                        value = otp,
                        onValueChange = {
                            otp=it},
                        placeholder = {
                            Text(
                                text = "-   -   -   -   -   -",
                                fontSize = 30.sp,
                                color = Color.LightGray
                            )
                        },
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 30.sp,
                            color = Color.White,
                            letterSpacing = 10.sp
                        ),
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = Color(0xFF00C853)
                        ),
                        modifier = Modifier
                            .width(220.dp)
                            .padding(start = 15.dp)
                    )


                    Spacer(Modifier.height(56.dp))

                    Text(
                        "Need help getting a code?",
                        fontSize = 16.sp,
                        color = Color(0xFF00C853),
                        modifier = Modifier.padding(start = 12.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f)) // pushes everything above the bottom loader
                }

                // ✅ Bottom fixed loader box
                if(open){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(106.dp)
                            .align(Alignment.Center)
                            .padding(horizontal = 50.dp, vertical = 20.dp)
                            .background(color = Color(0xFF2C2F33), shape = RoundedCornerShape(3.dp))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 26.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
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
fun Top2(){
    Box(
        modifier = Modifier.fillMaxWidth().height(80.dp)
    ){
     Row(modifier = Modifier.fillMaxSize().padding(start =17.dp), verticalAlignment = Alignment.CenterVertically){
         Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, modifier = Modifier.size(28.dp), tint = Color(
             0xFFABABAB
         ))
         Spacer(Modifier.width(260.dp))
         Icon(imageVector = Icons.Default.VolumeUp,contentDescription = null, modifier = Modifier.size(28.dp), tint = Color(
             0xFFABABAB
         ))
         Spacer(Modifier.width(20.dp))
         Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, modifier = Modifier.size(25.dp),tint = Color(
             0xFFABABAB
         ))
     }

    }
}