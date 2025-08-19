package com.example.whatsapp.screen



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data classes
data class StatusUpdate(
    val name: String,
    val time: String,
    val hasStatus: Boolean = true,
    val isViewed: Boolean = false,
    val emoji: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Update() {
    val statusUpdates = remember {
        listOf(
            StatusUpdate("Juraji 😊", "5:55 PM", true, false),
            StatusUpdate("Priya 💛", "6:30 PM", true, false),
            StatusUpdate("Navratna Bhaiya (Ju) Civil", "12:38 AM", true, true),
            StatusUpdate("Adil Bhaiya Running", "1:01 PM", true, true),
            StatusUpdate("Mr Debojyoti Pariksha😂😂", "1:05 PM", true, true),
            StatusUpdate("ROHIT GROUNT", "Yesterday", true, true),
            StatusUpdate("Jitendra Bhaiya", "7:40 AM", true, true)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B141B))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top App Bar
            TopAppBar(
                title = {
                    Text(
                        text = "Updates",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Default.QrCode,
                            contentDescription = "QR Code",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Default.MoreVert,
                            contentDescription = "More",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0B141B)
                )
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                item {
                    // Status Section Header
                    Text(
                        text = "Status",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    // My Status
                    StatusItem(
                        name = "Add status",
                        subtitle = "Disappears after 24 hours",
                        time = "",
                        hasAddIcon = true,
                        isViewed = false
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Recent Updates Header
                    Text(
                        text = "Recent updates",
                        color = Color(0xFF8696A0),
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                items(statusUpdates) { status ->
                    StatusItem(
                        name = status.name,
                        subtitle = null,
                        time = status.time,
                        hasAddIcon = false,
                        isViewed = status.isViewed
                    )
                }
            }
        }

        // Floating Action Button
        FloatingActionButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = Color(0xFF00A884),
            contentColor = Color.White
        ) {
            Icon(
                Icons.Default.CameraAlt,
                contentDescription = "Add Status",
                modifier = Modifier.size(24.dp)
            )
        }

        // Bottom Navigation
        BottomNavigation(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun StatusItem(
    name: String,
    subtitle: String? = null,
    time: String,
    hasAddIcon: Boolean = false,
    isViewed: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            // Profile Picture
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
                    .border(
                        width = 2.dp,
                        color = if (isViewed) Color(0xFF8696A0) else Color(0xFF00A884),
                        shape = CircleShape
                    )
            )

            // Add icon for "Add status"
            if (hasAddIcon) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF00A884))
                        .align(Alignment.BottomEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = name,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            if (subtitle != null) {
                Text(
                    text = subtitle,
                    color = Color(0xFF8696A0),
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        if (time.isNotEmpty()) {
            Text(
                text = time,
                color = Color(0xFF8696A0),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        color = Color(0xFF0B141B)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(
                icon = Icons.Default.Chat,
                label = "Chats",
                badgeCount = 63,
                isSelected = false
            )
            BottomNavItem(
                icon = Icons.Default.Update,
                label = "Updates",
                badgeCount = null,
                isSelected = true
            )
            BottomNavItem(
                icon = Icons.Default.Groups,
                label = "Communities",
                badgeCount = null,
                isSelected = false
            )
            BottomNavItem(
                icon = Icons.Default.Call,
                label = "Calls",
                badgeCount = 2,
                isSelected = false
            )
        }
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    label: String,
    badgeCount: Int? = null,
    isSelected: Boolean = false
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Box {
            Icon(
                icon,
                contentDescription = label,
                tint = if (isSelected) Color(0xFF00A884) else Color(0xFF8696A0),
                modifier = Modifier.size(24.dp)
            )

            if (badgeCount != null) {
                Badge(
                    modifier = Modifier.align(Alignment.TopEnd),
                    containerColor = Color(0xFF00A884)
                ) {
                    Text(
                        text = badgeCount.toString(),
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            color = if (isSelected) Color(0xFF00A884) else Color(0xFF8696A0),
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WhatsAppStatusScreenPreview() {
    MaterialTheme {
        Update()
    }
}