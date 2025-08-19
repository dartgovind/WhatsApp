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
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

//@Preview(showBackground = true)
@Composable
fun WelcomeScreen(navHostController: NavHostController){
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFF121B22)
    ){
      Column(modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
      ){
          Image(painter = painterResource(id = R.drawable.main_logo),
              contentDescription = null,
              modifier = Modifier.size(350.dp))
          Spacer(Modifier.height(4.dp))
          Text("Welcome to WhatsApp", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White)
          Spacer(Modifier.height(15.dp))
          Row { Text("Read our ", fontSize = 15.sp, color = Color(0xFFE5EAF1))
              Text("Privacy Policy.", fontSize = 15.sp, color = Color(0xFF00BBD4), fontWeight = FontWeight.Bold)
              Text(" Tab Agree and continue to", fontSize = 15.sp,color = Color(0xFFE5EAF1))
          }
          Spacer(Modifier.height(5.dp))
          Row {
              Text("accept the ", fontSize = 15.sp,color = Color(0xFFE5EAF1))
              Text("Terms of Service.", fontSize = 15.sp,color = Color(0xFF00BBD4), fontWeight = FontWeight.Bold)
          }
          Spacer(Modifier.height(40.dp))
          Row(verticalAlignment = Alignment.CenterVertically){
              Icon(imageVector = Icons.Outlined.Public, contentDescription = null,
                  tint = Color(0xFF00C853), // same green
                  modifier = Modifier.size(24.dp))
              Spacer(Modifier.width(10.dp))
              Text("English", fontSize = 18.sp, color = Color(0xFF00C853))
              Spacer(Modifier.width(9.dp))

              Icon(
                  imageVector = Icons.Default.ArrowDropDown, // ▼ icon
                  contentDescription = "Dropdown",
                  tint = Color(0xFF00C853),
                  modifier = Modifier.size(30.dp)
              )

              }
          Spacer(Modifier.height(30.dp))
          Box(modifier = Modifier.fillMaxWidth().clickable { navHostController.navigate(Routes.NumberScreen) }
              .height(40.dp).padding(horizontal = 15.dp)
              .background(color = Color(0xFF00C853), shape = RoundedCornerShape(20.dp))
          ){
              Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                  Text("Agree and continue", fontSize = 17.sp, fontWeight = FontWeight.Bold, color = Color(0xFF121B22))
              }

          }

      }
    }
}