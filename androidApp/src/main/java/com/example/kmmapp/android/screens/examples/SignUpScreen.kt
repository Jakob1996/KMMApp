package com.example.kmmapp.android.screens.examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFFBEEE0)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignUpTitle()
            SignUpSubtitle()
            Spacer(modifier = Modifier.padding(10.dp))
            SignUpFields()
        }
    }
}

@Composable
fun SignUpTitle() {
    Text(text = "Sign up", style = TextStyle(fontSize = 25.sp), fontWeight = FontWeight.Medium)
}

@Composable
fun SignUpSubtitle() {
    Text(
        text = "Just a few quick things to get started",
        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Light)
    )
}

@Composable
fun SignUpFields() {

    var emailText by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = emailText,
                onValueChange = { email -> emailText = email },
                modifier = Modifier
                    .weight(1f),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                placeholder = { Text(text = "Email") },
                shape = RoundedCornerShape(40),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFFFBEEE0),
                    unfocusedIndicatorColor = Color(0xFFFBEEE0),
                    disabledContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.padding(4.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = userName,
                onValueChange = { email -> userName = email },
                modifier = Modifier
                    .weight(1f),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                placeholder = { Text(text = "Username") },
                shape = RoundedCornerShape(40),
                leadingIcon = { Icon(imageVector = Icons.Filled.Info, contentDescription = null) },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFFFBEEE0),
                    unfocusedIndicatorColor = Color(0xFFFBEEE0),
                    disabledContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.padding(4.dp))

        PasswordTextField(
            password,
            onValueChange = { pass -> password = pass },
            textLabel = "Password"
        )
    }
}

@Composable
fun PasswordTextField(text: String, onValueChange: (String) -> Unit, textLabel: String) {
    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            shape = RoundedCornerShape(40),
            label = { Text(text = textLabel) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Accessibility,
                    contentDescription = null
                )
            },
            visualTransformation = if (passwordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                val image = if (passwordVisible) {
                    Icons.Filled.Visibility
                } else {
                    Icons.Filled.VisibilityOff
                }

                IconButton(onClick = { passwordVisible = passwordVisible.not() }) {
                    Icon(imageVector = image, contentDescription = null)
                }
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFFFBEEE0),
                unfocusedIndicatorColor = Color(0xFFFBEEE0),
                disabledContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )
    }
}

@Preview
@Composable
fun SignUpScreenPrev() {
    SignUpScreen()
}