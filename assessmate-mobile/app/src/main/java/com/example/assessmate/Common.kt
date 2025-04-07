package com.example.assessmate

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Define shared colors
val primaryButtonColor = Color(0xFF36A9B4)
val inputFieldColor = Color(0xFFF8F8F8)  // Lighter background
val textColor = Color(0xFF333333)
val hintTextColor = Color(0xFFAAAAAA)    // Lighter hint text

@Composable
fun CustomTextField(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false
) {
    var text by remember { mutableStateOf(value) }
    
    TextField(
        value = text,
        onValueChange = { 
            text = it
            onValueChange(it)
        },
        placeholder = { 
            Text(
                text = placeholder,
                style = TextStyle(
                    color = hintTextColor,
                    fontSize = 16.sp
                )
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = inputFieldColor,
                shape = RoundedCornerShape(12.dp)
            ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = inputFieldColor,
            unfocusedContainerColor = inputFieldColor,
            disabledContainerColor = inputFieldColor,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = textColor
        ),
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
        )
    )
}