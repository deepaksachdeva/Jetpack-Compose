package com.deepak.jetpack_compose.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

val dialogState by lazy { mutableStateOf(false) }
val statesList = listOf("Rajasthan", "Punjab", "Haryana", "J&K")
val selectedState by lazy { mutableStateOf("") }

@Composable
fun AlertDialogComp() {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            // onDismissRequest will be called when back button is pressed or there is some click
            // outside the AlertDialog and NOT on pressing the dismissButton
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Alert Dialog") },
            text = { Text("Hello! I am an Alert Dialog") },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            },
            containerColor = Color.Black,
            titleContentColor = Color.White,
            textContentColor = Color.White
        )
    }
}

@Composable
fun SingleChoiceDialogComp() {
    Column {
        Button(
            onClick = {
                dialogState.value = true
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            )
        ) {
            Text(
                text = "Show Countries List",
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}

@Composable
fun CountriesDialog() {
    if (dialogState.value) {
        var selectedOption by remember { mutableStateOf(statesList[0]) }
        Dialog(onDismissRequest = { dialogState.value = false }) {
            Surface {
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(text = "Select State")
                    statesList.forEach { state ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = (state == selectedOption),
                                onClick = { selectedOption = state }
                            )
                            Text(
                                text = state,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                    Text(
                        buildAnnotatedString {
                            append("The Selected Value is: ")
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Blue
                                )
                            ) {
                                append(selectedOption)
                            }
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun SingleChoiceDialogWithLazyColumnComp() {
    Column {
        Button(
            onClick = {
                dialogState.value = true
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            )
        ) {
            Text(
                text = "Show Countries List",
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
        Divider(color = Color.Black)
        Text(
            text = selectedState.value,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}


@Composable
fun CountriesDialogUsingLazyColumn() {
    if (dialogState.value) {
        var selectedOption by remember { mutableIntStateOf(-1) }
        Dialog(onDismissRequest = { dialogState.value = false }) {
            Surface(
                modifier = Modifier.width(300.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = "Select State")
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyColumn(
                        modifier = Modifier.height(300.dp)
                    ) {
                        val selectedValue = if (selectedOption == -1) {
                            ""
                        } else {
                            statesList[selectedOption]
                        }

                        items(statesList) { state ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = (state == selectedValue),
                                        onClick = {
                                            selectedOption = statesList.indexOf(state)
                                        }
                                    )
                                    .padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = (state == selectedValue),
                                    onClick = {
                                        selectedOption = statesList.indexOf(state)
                                    }
                                )
                                Text(
                                    text = state,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.bodyMedium.merge(),
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {
                            selectedState.value = statesList[selectedOption]
                            dialogState.value = false
                        },
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text(text = "Select")
                    }
                }
            }
        }
    }
}