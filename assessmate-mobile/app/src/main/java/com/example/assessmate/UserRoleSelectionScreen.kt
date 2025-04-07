package com.example.assessmate
// UserRoleSelectionScreen.kt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// Define colors based on the image
val mintBackground = Color(0xFFD5EBE8)  // Mint green for top section
val tealButton = Color(0xFF36A9B4)      // Teal for student button and mentor border
val tealText = Color(0xFF37A6A6)        // Teal for HELLO text
val grayText = Color(0xFF8C8C8C)        // Gray for "Choose Your Role"

@Composable
fun UserRoleSelectionScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top mint green section with rounded bottom corners
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                    .background(mintBackground)
            ) {
                // Illustration centered in the mint section
                Image(
                    painter = painterResource(id = R.drawable.role_selection_illustration),
                    contentDescription = "User selecting role",
                    modifier = Modifier
                        .size(280.dp)
                        .align(Alignment.Center)
                )
            }

            // Content below mint section
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(32.dp))

                // Hello text
                Text(
                    text = "HELLO",
                    color = tealText,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Choose Your Role text
                Text(
                    text = "Choose Your Role",
                    color = grayText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(48.dp))

                // Student button
                Button(
                    onClick = {
                        navController.navigate("congratulations")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = tealButton),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        "STUDENT",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Mentor button
                OutlinedButton(
                    onClick = {
                        navController.navigate("congratulations")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .border(1.dp, tealButton, RoundedCornerShape(12.dp)),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = tealButton,
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        "MENTOR",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserRoleSelectionScreen() {
    UserRoleSelectionScreen(rememberNavController())
}