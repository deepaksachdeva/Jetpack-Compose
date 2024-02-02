package com.deepak.jetpack_compose.text

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun TextFields() {
    LazyColumn {
        item {
            SimpleText("Basic Text Field")
            BasicTextField()

            SimpleText("Basic Number Text Field")
            BasicNumberTextField()

            SimpleText("Simple Text Field")
            SimpleTextField()

            SimpleText("Number Text Field")
            NumberTextField()

            SimpleText("Password Text Field")
            PasswordTextField()

            SimpleText("Placeholder Text Field")
            PlaceHolderTextField()

            SimpleText("Done icon Field")
            DoneIconTextField()

            SimpleText("Placeholder Text Field")
            ProfileIconTextField()

            SimpleText("Show Hide Password Text Field")
            ShowHidePasswordTextField()
        }
    }
}

@Composable
fun BasicTextField() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var text by remember { mutableStateOf("Enter text here") }
        BasicTextField(
            value = text,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = {
                text = it
            }
        )
    }
}

@Composable
fun BasicNumberTextField() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var text by remember { mutableStateOf("Enter text here") }
        BasicTextField(
            value = text,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                text = it
            }
        )
    }
}


@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        label = { Text("Enter text") },
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun NumberTextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        label = { Text("Enter number") },
        onValueChange = {
            text = it
        }
    )
}


@Composable
fun PasswordTextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        label = { Text("Enter password") },
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = {
            text = it
        }
    )
}


@Composable
fun PlaceHolderTextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        label = { Text("Enter details") },
        placeholder = { Text("Placeholder") },
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun DoneIconTextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        label = { Text("Enter details") },
        placeholder = { Text("Placeholder") },
        trailingIcon = { Icon(Icons.Filled.Done, contentDescription = "Localized description") },
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun ProfileIconTextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        label = { Text("Enter name") },
        placeholder = { Text("Placeholder") },
        leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Localized description") },
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun ShowHidePasswordTextField() {

    var password by remember { mutableStateOf(value = "") }
    var showPassword by remember { mutableStateOf(value = false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        value = password,
        onValueChange = {
            password = it
        },
        label = {
            Text(text = "Password")
        },
        placeholder = { Text(text = "Type password here") },
        shape = RoundedCornerShape(percent = 20),
        visualTransformation = if (showPassword) {

            VisualTransformation.None

        } else {

            PasswordVisualTransformation()

        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "hide_password"
                    )
                }
            } else {
                IconButton(
                    onClick = { showPassword = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "hide_password"
                    )
                }
            }
        }
    )
}