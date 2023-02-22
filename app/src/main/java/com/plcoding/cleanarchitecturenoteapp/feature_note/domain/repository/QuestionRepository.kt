package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Answer
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Question
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.QuestionAndAnswer
import kotlinx.coroutines.flow.Flow


interface QuestionRepository {
    fun getQuestions(): Flow<List<Question>>

    fun getQuestionsWithAnswers(quizId:Long): Flow<List<QuestionAndAnswer>>

    suspend fun createQuestion(question: Question):Long

    suspend fun addAnswer(answer: Answer)

    suspend fun deleteQuestion(question: Question)

    suspend fun deleteAnswer(answer: Answer)

    suspend fun getAnswer(answerId:Long, questionId:Long):Answer
}