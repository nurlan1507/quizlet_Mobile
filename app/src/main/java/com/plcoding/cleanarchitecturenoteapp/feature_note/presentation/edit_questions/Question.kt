package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.edit_questions

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Answer
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Question

@Composable
fun Question(
    modifier: androidx.compose.ui.Modifier,
    question: Question,
    questionText:String,
    answers:List<Answer>
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .background(Color.White))
    {
        Row(modifier= modifier
            .fillMaxWidth()
            .heightIn(min = 70.dp)) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(MaterialTheme.colors.background)
            )
            {
                Text(text = questionText, style = MaterialTheme.typography.body1)
            }
        }
        Row(){
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){

            }

        }
    }
}