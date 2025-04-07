package com.example.assessmate
// LandingScreen.kt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LandingScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top-left background circle
        Box(
            modifier = Modifier
                .size(200.dp)
                .offset((-50).dp, (-50).dp)
                .background(inputFieldColor, CircleShape)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(180.dp))

            // Illustration and content
            Image(
                painter = painterResource(id = R.drawable.landing_illustration),
                contentDescription = "Person with documents",
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Gets things with AssessMate",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Manage reviews and assessments with ease. Everything your review center needs—all in one place.",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFF666666),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(90.dp))

            // Button
            Button(
                onClick = { navController.navigate("signup") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryButtonColor,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Get Started", fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLandingScreen() {
    LandingScreen(rememberNavController())
}