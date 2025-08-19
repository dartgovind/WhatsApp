package com.example.whatsapp.screen

import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavHostController
import com.example.whatsapp.R
import com.example.whatsapp.navigation.Routes

@androidx.annotation.OptIn(UnstableApi::class)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VideoItem(navHostController: NavHostController) {
    val videoList = listOf( R.raw.video2, R.raw.video3,R.raw.video4, R.raw.video5, R.raw.video6,R.raw.video7, R.raw.video8, R.raw.video9,R.raw.video10, R.raw.video11,R.raw.video1,)
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { videoList.size }
    )

    Scaffold(
        topBar = { Top7() },
        bottomBar = { Down6(navHostController) }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                VerticalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxSize()
                ) { page ->
                    val context = LocalContext.current
                    val videoResId = videoList[page]
                    val isVisible = pagerState.currentPage == page

                    val player = remember {
                        ExoPlayer.Builder(context).build().apply {
                            val uri = RawResourceDataSource.buildRawResourceUri(videoResId)
                            setMediaItem(MediaItem.fromUri(uri))
                            prepare()
                        }
                    }

                    LaunchedEffect(isVisible) {
                        player.playWhenReady = isVisible
                    }

                    DisposableEffect(Unit) {
                        onDispose {
                            player.release()
                        }
                    }

                    Box(modifier = Modifier.fillMaxSize()) {
                        AndroidView(
                            factory = {
                                PlayerView(it).apply {
                                    this.player = player
                                    useController = false
                                    layoutParams = ViewGroup.LayoutParams(
                                        ViewGroup.LayoutParams.MATCH_PARENT,
                                        ViewGroup.LayoutParams.MATCH_PARENT
                                    )
                                }
                            },
                            modifier = Modifier.fillMaxSize()
                        )

                        // Action buttons on right
                        Column(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            ActionButton(icon = Icons.Default.ThumbUp, label = "7.7K")
                            ActionButton(icon = Icons.Default.Share, label = "Share")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ActionButton(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color.White,
            modifier = Modifier
                .size(48.dp)
                .background(Color.Black.copy(alpha = 0.4f), shape = CircleShape)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = Color.White,
            style = MaterialTheme.typography.labelSmall
        )
    }
}
@Composable
fun Top7(){
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
                Icon(imageVector = Icons.Default.QrCodeScanner, contentDescription = null, modifier = Modifier.size(25.dp), Color(0xFF0A1218))
                Spacer(Modifier.width(20.dp))
                Icon(imageVector = Icons.Default.Search, contentDescription = null, modifier = Modifier.size(30.dp), tint = Color.White)
                Spacer(Modifier.width(15.dp))
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, modifier = Modifier.size(30.dp), tint = Color.White)

            }
        }

    }

}
@Composable
fun Down6(navHostController: NavHostController) {
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
                    modifier = Modifier.size(30.dp).clickable { navHostController.navigate(Routes.ChatScreen) },
                    tint = Color.White
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
                    modifier = Modifier.size(35.dp),
                    tint = Color.Green
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

