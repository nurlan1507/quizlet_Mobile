package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.question_use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Question
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.QuestionRepository

class InserQuestion(private val noteRepository: NoteRepository,private val repository: QuestionRepository) {
    suspend operator fun invoke(question: Question){
        repository.createQuestion(question)
    }
}