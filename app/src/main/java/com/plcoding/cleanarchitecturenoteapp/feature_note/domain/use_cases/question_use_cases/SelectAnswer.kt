package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.question_use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.QuestionRepository

class SelectAnswer( private val questionRepository: QuestionRepository) {

    suspend operator fun invoke(questionId:Long, answerId:Long){

    }
}