package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.question_use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Answer

data class QuestionUseCases(
    val getQuestionsWithAnswers: GetQuestionsWithAnswers,
    val inserQuestion: InserQuestion,
    val insertAnswer: InsertAnswer,
    val deleteQuestion: DeleteQuestion,
    val deleteAnswer: DeleteAnswer,
    val insertPDF: InsertPDF,
    val selectAnswer: SelectAnswer,
)