package com.example.assessmate

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EnrollScreen(
    onEnrollClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFD5EBE5) // Light mint color as shown in the design
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Back button
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.align(Alignment.Start)
            ) {
                Text(
                    text = "←",
                    fontSize = 24.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Header with course title
            Text(
                text = "Object Oriented Programming",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Course details card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // Name section
                    Text(
                        text = "Name",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.DarkGray
                    )

                    TextField(
                        value = "Object Oriented Programming",
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            unfocusedIndicatorColor = Color.LightGray,
                            focusedIndicatorColor = Color.LightGray
                        ),
                        readOnly = true
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Description section
                    Text(
                        text = "Description",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.DarkGray
                    )

                    TextField(
                        value = "Description",
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            unfocusedIndicatorColor = Color.LightGray,
                            focusedIndicatorColor = Color.LightGray
                        ),
                        readOnly = true
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Enrollment code section
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "[m/ht]1",
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.weight(1f)
                        )


                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Student count
                    Text(
                        text = "150 Students",
                        fontSize = 16.sp,
                        color = Color.DarkGray
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Enroll button
            Button(
                onClick = onEnrollClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF30AFAD) // Teal color as shown in design
                )
            ) {
                Text(
                    text = "Enroll",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

// Preview for the EnrollScreen
@Composable
@Preview(showBackground = true)
fun EnrollScreenPreview() {
    MaterialTheme {
        EnrollScreen()
    }
}