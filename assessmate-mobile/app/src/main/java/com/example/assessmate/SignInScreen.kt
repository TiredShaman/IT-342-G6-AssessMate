package com.example.assessmate

// SignInScreen.kt
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
fun SignInScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // Illustration
            Image(
                painter = painterResource(id = R.drawable.signin_illustration),
                contentDescription = "Sign in illustration",
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Welcome back text
            Text(
                text = "Welcome back",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Input fields
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            CustomTextField(
                placeholder = "Enter your Email",
                value = email,
                onValueChange = { email = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                placeholder = "Enter Password",
                value = password,
                onValueChange = { password = it },
                isPassword = true
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Forgot password?",
                    color = primaryButtonColor,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Login button
            Button(
                onClick = { navController.navigate("user_role_selection") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primaryButtonColor),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    "Login",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Or continue with
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFEEEEEE),
                    thickness = 1.dp
                )

                Text(
                    text = "or continue with",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    fontSize = 14.sp,
                    color = Color(0xFF666666)
                )

                Divider(
                    modifier = Modifier.weight(1f),
                    color = Color(0xFFEEEEEE),
                    thickness = 1.dp
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Social login options
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Google sign-in
                IconButton(
                    onClick = { /* Implement Google sign-in */ },
                    modifier = Modifier
                        .size(44.dp)
                        .background(Color.White, CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Sign in with Google",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.width(32.dp))

                // GitHub sign-in
                IconButton(
                    onClick = { /* Implement GitHub sign-in */ },
                    modifier = Modifier
                        .size(44.dp)
                        .background(Color.White, CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.github),
                        contentDescription = "Sign in with GitHub",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignInScreen() {
    SignInScreen(rememberNavController())
}