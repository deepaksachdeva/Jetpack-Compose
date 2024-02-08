package com.deepak.jetpack_compose.uicomponents

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import com.deepak.jetpack_compose.R
import com.deepak.jetpack_compose.data.Friend

@Composable
fun ColumnComp() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("I am Deepak Sachdeva")
        Text("I am an Android Developer.", color = Color.Blue)
        Text("I am learning Jetpack compose", color = Color.Red)
    }
}

@Composable
fun LazyColumnComp(friendList: List<Friend>) {
    val context = LocalContext.current
    LazyColumn {
        item {
            friendList.forEach { friend ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable(onClick = {
                            Toast
                                .makeText(
                                    context,
                                    "First name: ${friend.firstName}",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Cyan
                    )
                ) {
                    Text(
                        text = "${friend.firstName} ${friend.lastName}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun RowComponent() {
    Row(modifier = Modifier.padding(16.dp)) {
        Text("I am Deepak Sachdeva")
        Text("I am an Android Developer.", color = Color.Blue)
        Text("I am learning Jetpack compose", color = Color.Red)
    }
}


@Composable
fun LazyRowComp(friendList: List<Friend>) {
    val context = LocalContext.current
    LazyRow {
        item {
            friendList.forEach { friend ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable(onClick = {
                            Toast
                                .makeText(
                                    context,
                                    "First name: ${friend.firstName}",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Cyan
                    )
                ) {
                    Text(
                        text = "${friend.firstName} ${friend.lastName}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun BoxComp() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_launcher_background
            ),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            text = "Android",
            color = Color.Blue
        )
    }
}

@Composable
fun ConstraintLayoutComponent() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (button, buttonTop, textBottom, textStart, textEnd) = createRefs()
        Button(
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            onClick = { /* Do something */ },
        ) {
            Text("Button")
        }
        Button(
            modifier = Modifier.constrainAs(buttonTop) {
                top.linkTo(parent.top)
                bottom.linkTo(button.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            onClick = { /* Do something */ },
        ) {
            Text("Button Top")
        }
        Button(modifier = Modifier.constrainAs(textBottom) {
            top.linkTo(button.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        },
            onClick = { /* Do something */ }
        ) {
            Text("Button Bottom")
        }
        Text("Text Start", Modifier.constrainAs(textStart) {
            start.linkTo(parent.start)
            end.linkTo(button.start)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })
        Text("Text End", Modifier.constrainAs(textEnd) {
            start.linkTo(button.end)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })
    }
}

@Composable
fun ButtonComp() {
    Box {
        Button(
            onClick = {
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            )
        ) {
            Text(
                text = "Submit",
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}

@Composable
fun CardComponent() {
    Box {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable(onClick = {

                }
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color.Cyan
            )
        ) {
            Text(
                text = "Text 1",
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .padding(16.dp)
            )

            Text(
                text = "Text 2",
                style = TextStyle(
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun ImageComponent() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        painter = painterResource(
            id = R.drawable.ic_launcher_background
        ),
        contentDescription = null
    )
}
