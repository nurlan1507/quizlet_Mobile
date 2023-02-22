package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.question_use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.QuestionAndAnswer
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.QuestionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetQuestionsWithAnswers(private var noteRepository: NoteRepository, private val repository: QuestionRepository) {
    operator fun invoke(id: Long ): Flow<List<QuestionAndAnswer>> {
        return repository.getQuestionsWithAnswers(id).map {
            it
        }
    }
}