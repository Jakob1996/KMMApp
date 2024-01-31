package com.example.kmmapp.android.screens.examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChooseAccountScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF6868AF)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GetTextContent()
            AccountButtons()
            LoginFooter()
        }
    }
}

@Composable
fun GetTextContent() {
    Text(
        text = "Make mymories",
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Color(0xFFF9FAFC)
        )
    )

    Text(
        modifier = Modifier.padding(8.dp),
        text = "Record, recall and share your favourite mymories anytime.",
        style = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFFF9FAFC)
        )
    )
}

@Composable
fun AccountButtons() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(5.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color(0xFF83D0D7)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Continue with Apple",
                color = Color.Black,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.padding(5.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(5.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color(0xFFFBEEE0)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Continue with Google",
                color = Color.Black,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
        }
        Spacer(modifier = Modifier.padding(5.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(5.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color(0xFFFFFEFF)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Sign up with email",
                color = Color(0xFF6868AF),
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}

@Composable
fun LoginFooter() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Already have an account?",
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium),
            color = Color.White
        )

        Spacer(modifier = Modifier.padding(2.dp))

        Text(
            "Log in",
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            color = Color.White
        )
    }
}

@Preview
@Composable
fun ChooseAccountScreenPrev() {
    ChooseAccountScreen()
}