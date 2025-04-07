package com.example.assessmate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

// Define colors
val darkBackgroundColor = Color(0xFF4A4A5E)

@Composable
fun CongratulationsScreen(navController: NavController) {
    var isRedirecting by remember { mutableStateOf(true) }
    var hasNavigated by remember { mutableStateOf(false) }

    // Automatically redirect after 3 seconds
    LaunchedEffect(key1 = Unit) {
        try {
            delay(3000)
            if (!hasNavigated) {
                hasNavigated = true
                isRedirecting = false
                navController.navigate("elearning_homepage") {
                    popUpTo("landing") { inclusive = true }
                    launchSingleTop = true
                }
            }
        } catch (e: Exception) {
            // Handle any exceptions silently
            isRedirecting = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBackgroundColor)
    ) {
        // Main card content
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .align(Alignment.Center),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Use the congratulations illustration instead of drawing programmatically
                Image(
                    painter = painterResource(id = R.drawable.congratulations_illustration),
                    contentDescription = "Congratulations",
                    modifier = Modifier
                        .size(160.dp)
                        .padding(8.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Congratulations text
                Text(
                    text = "Congratulations",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Message text
                Text(
                    text = "Your Account is Ready to Use. You will be redirected to the Home Page in a Few Seconds.",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Loading indicator
                if (isRedirecting) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = darkBackgroundColor,
                        strokeWidth = 2.dp
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                
            }
        }
    }
}