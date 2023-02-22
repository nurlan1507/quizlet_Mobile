package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.edit_questions

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Answer
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Question
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.question_use_cases.SelectAnswer

sealed class QuestionEvent {
    data class GetQuestionsAndAnswers(var quizId:Long):QuestionEvent()
    data class SelectAnswer(var answer: Answer):QuestionEvent()
    data class DeleteQuestion(var question: Question):QuestionEvent()
    data class GetNextQuestion(var index:Int):QuestionEvent()
    data class UseChatGPT(var index:Int):QuestionEvent()
}