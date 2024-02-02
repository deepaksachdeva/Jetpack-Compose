package com.deepak.jetpack_compose.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleText(displayText: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = displayText
        )
    }
}

@Composable
fun StyleText() {
    LazyColumn {
        item {
            SetTextStyling(
                "I am a Simple Text"
            )

            // Text with Font Size
            SetTextStyling(
                "I am having font size as 30sp",
                style = TextStyle(
                    fontSize = 30.sp
                )
            )

            // Text with Font Style
            SetTextStyling(
                "I am an Italic Text",
                style = TextStyle(
                    fontStyle = FontStyle.Italic
                )
            )

            // Text with Font Style and Font Size
            SetTextStyling(
                "I am an Italic text of size 20sp",
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp
                )
            )

            // Text with Color
            SetTextStyling(
                "I am a Simple Text with Green Color",
                style = TextStyle(
                    color = Color.Green
                )
            )

            // Text with Font Weight
            SetTextStyling(
                "I am a Bold Text",
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )


            // Text with Font Family
            SetTextStyling(
                "My font is Cursive",
                style = TextStyle(
                    fontFamily = FontFamily.Cursive
                )
            )
            // Text with Blue Color, Bold Font Weight, Italic Font Style and 16 Font Size
            SetTextStyling(
                "I am a text with more than one Text Style",
                style = TextStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 16.sp
                )
            )
            // Text with Decoration
            SetTextStyling(
                "I am an Underlined Text",
                style = TextStyle(
                    textDecoration = TextDecoration.Underline
                )
            )
            // Text with LineThrough
            SetTextStyling(
                "I am a LineThrough Text",
                style = TextStyle(
                    textDecoration = TextDecoration.LineThrough
                )
            )

            // Text with Yellow Background Color
            SetTextStyling(
                "I am a text having background color",
                style = TextStyle(
                    background = Color.Yellow
                )
            )

            // Text with Shadow
            SetTextStyling(
                "I am a text with shadow",
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Red, blurRadius = 6f,
                        offset = Offset(2f, 2f)
                    )
                )
            )

            // Text with Padding = 30sp
            SetTextStyling(
                "I am a text having 16dp padding in first line",
                style = TextStyle(
                    textIndent = TextIndent(firstLine = 30.sp)
                )
            )

            // Text with Alignment
            SetTextStyling(
                "I am a Text having Justified alignment " +
                        "I am a Text having Justified alignment " +
                        "I am a Text having Justified alignment " +
                        "I am a Text having Justified alignment " +
                        "I am a Text having Justified alignment.",
                style = TextStyle(
                    textAlign = TextAlign.Justify
                )
            )

            // Text with Centre Alignment
            SetTextStyling(
                "I am a Text having Centered alignment. " +
                        "I am a Text having Centered alignment " +
                        "I am a Text having Centered alignment " +
                        "I am a Text having Centered alignment " +
                        "I am a Text having Centered alignment.",
                style = TextStyle(
                    textAlign = TextAlign.Center
                )
            )

            // Text with Alignment and Line Height
            SetTextStyling(
                "I am a Text having Centered alignment and 16sp line height. " +
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                        "eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                        "nisi ut aliquip ex ea commodo consequat.",
                style = TextStyle(
                    textAlign = TextAlign.Justify,
                    lineHeight = 16.sp
                )
            )


        }
    }
}

@Composable
fun SetTextStyling(displayText: String, style: TextStyle? = null) {
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis
    )
}


@Preview
@Composable
fun SimpleTextPreview() {
    SimpleText("Hi, I am learning Jetpack Compose")
}

@Preview
@Composable
fun FontTextPreview() {
    StyleText()
}