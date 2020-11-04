package com.cmbytes.compose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Triangle(color: Color) {
    Canvas(modifier = Modifier.preferredSize(10.dp)) {
        drawLine(
            color = color,
            Offset(10f, 0f),
            Offset(40f, 20f),
            strokeWidth = 4f
        )
        drawLine(
            color = color,
            Offset(40f, 20f),
            Offset(10f, 40f),
            strokeWidth = 4f
        )
        drawLine(
            color = color,
            Offset(10f, 40f),
            Offset(10f, 0f),
            strokeWidth = 4f
        )
    }
}

@Composable
fun RecipeButton(
    onClick: () -> Unit,
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    shapeSlot: @Composable() () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.padding(start = 26.dp).height(32.dp),
        border = BorderStroke(
            width = 1.dp,
            color = color
        ),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()) {
            shapeSlot()
            Text(
                modifier = modifier,
                text = text,
                style = MaterialTheme.typography.body2,
                color = color
            )
        }
    }
}

@Composable
fun RecipeTitle(title: String, maxLines: Int = 1) {
    Text(
        text = title,
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        maxLines = maxLines,
        fontSize = 18.sp,
        overflow = TextOverflow.Ellipsis
    )
}