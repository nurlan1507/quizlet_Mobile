package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.edit_questions

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.QuestionAndAnswer


data class QuizQuestionState(
    val questionList: List<QuestionAndAnswer> = listOf(),

)