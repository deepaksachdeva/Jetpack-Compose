package com.deepak.jetpack_compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deepak.jetpack_compose.ui.theme.JetpackComposeTheme

@Composable
fun ListItems(
    uiItems: List<Int>,
    onNextButtonClicked: (String) -> Unit
) {
    val context = LocalContext.current
    LazyColumn {
        item {
            uiItems.forEach {
                val buttonText = context.resources.getString(it)
                ButtonComponent(buttonText, onNextButtonClicked)
                Divider(color = Color.Black)
            }
        }
    }
}

@Composable
fun ButtonComponent(text: String, onNextButtonClicked: (String) -> Unit) {
    Button(
        onClick = {
            onNextButtonClicked(text)
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Gray
        )
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            text = text,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        ButtonComponent("Simple Text", onNextButtonClicked = {})
    }
}