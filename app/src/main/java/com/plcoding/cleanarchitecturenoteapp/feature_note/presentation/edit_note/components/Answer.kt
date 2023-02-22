package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.edit_note.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Answer(
    modifier: Modifier,
    answerText: String
){
    Text(modifier = modifier, text=answerText)
}